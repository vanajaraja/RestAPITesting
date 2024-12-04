package org.sam.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sam.models.Users;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class Utility {

    public static Users createPayload() {
        // Read data from Excel
        List<Map<String, String>> excelData = null;
        Users users;
        try {
            excelData = readExcelData("src/test/resources/TestData/CreateUser.xlsx");
            // Read the existing JSON data (you can specify your own JSON structure)
            File jsonFile = new File("src/test/resources/PayLoad/createUser.json");
            ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(jsonFile, Users.class);
            // Update JSON object with non-null values from Excel data
            for (Map.Entry<String, String> entry : excelData.get(0).entrySet()) {
                if (entry.getValue() != null && !entry.getValue().isEmpty()) {
                    // Set values in JSON object (assuming MyData class has appropriate setters)
                    if ("name".equals(entry.getKey())) {
                        users.setName(entry.getValue());
                    } else if ("job".equals(entry.getKey())) {
                        users.setJob(entry.getValue());
                    }
                    // Add other fields as needed...
                }
            }

            // Write updated data to a new JSON file
          //  objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/test/resources/PayLoad/createUser.json"), users);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Updated JSON file has been created!");
        return users;
    }


    // Method to read data from Excel file and return as a map of key-value pairs
    public static List<Map<String, String>> readExcelData(String filePath) throws Exception {

        List<Map<String, String>> dataList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assume data is in the first sheet
        Iterator<Row> rowIterator = sheet.iterator();

        // Get the headers from the first row
        Row headerRow = sheet.getRow(0);
        Iterator<Cell> headerIterator = headerRow.cellIterator();
        List<String> headers = new ArrayList<>();

        while (headerIterator.hasNext()) {
            Cell headerCell = headerIterator.next();
            headers.add(headerCell.getStringCellValue());  // Add headers (column names)
        }

        // Skip the first row because it contains headers
        rowIterator.next();  // Skipping the header row

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Map<String, String> rowData = new HashMap<>();

            // Iterate over each cell in the row and add data to the map
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = row.getCell(i);
                if (cell != null) {
                    String value = getCellValue(cell);
                    rowData.put(headers.get(i), value);
                } else {
                    rowData.put(headers.get(i), null);  // If cell is empty, put null
                }
            }

            dataList.add(rowData);  // Add the row map to the list
        }
        workbook.close();
        fis.close();
        return dataList;
    }

    // Helper method to get the value of the cell based on its type
    public static String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            /*case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();*/
            default:
                return null;
        }
    }
}


