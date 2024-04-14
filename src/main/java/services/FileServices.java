package services;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class FileServices {
    public static XSSFSheet readXLSX(String filepath) {
        File file  = new File(filepath);
        try {
            FileInputStream fis = new FileInputStream(file);
            // finds the workbook instance for xlsx file
            XSSFWorkbook myWorkBook =  new XSSFWorkbook(fis);
            // returns the first sheet
            XSSFSheet mysheet = myWorkBook.getSheetAt(0);
            return mysheet;

        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
