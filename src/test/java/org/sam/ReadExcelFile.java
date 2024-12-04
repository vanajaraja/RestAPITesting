package org.sam;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadExcelFile {

    public void readFile() throws FileNotFoundException {
        File f = new File("C:\\Users\\vanaj\\Desktop\\Vanaja\\Interview Contacts.xlxs");
        FileInputStream fi = new FileInputStream(f);
        Workbook book = new XSSFWorkbook();
        Sheet s = book.getSheet("Sheet1");
        System.out.println("Hello"); 



    }
}

