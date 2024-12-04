package org.sam.utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sam.models.Users;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Utility {

    public static Users createPayload() {
        // Read data from Excel
        Map<String, String> excelData = null;
        Users users;
        try {
            excelData = readExcelData("src/test/resources/TestData/CreateUser.xlsx");
            // Read the existing JSON data (you can specify your own JSON structure)
            File jsonFile = new File("src/test/resources/PayLoad/createUser.json");
            ObjectMapper objectMapper = new ObjectMapper();
             users = objectMapper.readValue(jsonFile, Users.class);
            // Update JSON object with non-null values from Excel data
            for (Map.Entry<String, String> entry : excelData.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().isEmpty()) {
                    // Set values in JSON object (assuming MyData class has appropriate setters)
                    if ("name".equals(entry.getKey())) {
                        users.setName(entry.getValue());
                    } else if ("age".equals(entry.getKey())) {
                        users.setJob(entry.getValue());
                    }
                    // Add other fields as needed...
                }
            }

            // Write updated data to a new JSON file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("updated_data.json"), users);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Updated JSON file has been created!");
        return users;
    }


    // Method to read data from Excel file and return as a map of key-value pairs
    public static Map<String, String> readExcelData(String filePath) throws Exception {
        Map<String, String> data = new HashMap<>();
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assume data is in the first sheet
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            // Assuming the first column is the key and second column is the value
            if (cellIterator.hasNext()) {
                Cell keyCell = cellIterator.next();
                String key = keyCell.getStringCellValue();

                if (cellIterator.hasNext()) {
                    Cell valueCell = cellIterator.next();
                    String value = valueCell.getStringCellValue();
                    data.put(key, value);
                }
            }
        }

        workbook.close();
        fis.close();
        return data;
    }
}

