package Models;

import Interfaces.Agent;
import com.opencsv.CSVReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class NutrientAgent implements Agent {

    public static int nitrogen = 32; //unit ppm
    public static int phosphorous = 15; //unit ppm
    public static int potassium = 40; //unit ppm
    public static double phLevel = 6.5; //unit ph

    public static double organicMatterContent = 3.2; //(organic matter content) unit percentage

    public static double electricalConductivity = 0.8; // electrical conductivity unit -> ds/m

    public static int calcium = 1500; //unit ppm
    public static int magnesium = 200; //unit ppm

    public static HashMap currentNutrientStatus = new HashMap();


    public void readSensors() {

        System.out.println("Reading nutrient level...");
        XSSFSheet sensorData = readXLSX();
        HashMap nutrientDefficiencyMap = analyseNutrient(sensorData);
        currentNutrientStatus = nutrientDefficiencyMap;
    }

    public static HashMap analyseNutrient(XSSFSheet mysheet){
        HashMap nutrientMap = new HashMap();
        for (int rowIndex = 1; rowIndex <= mysheet.getLastRowNum(); rowIndex++) {
            Row row = mysheet.getRow(rowIndex);
            if (row != null) {
                Cell nitro = row.getCell(0);
                Cell phosp = row.getCell(1);
                Cell potash = row.getCell(2);
                Cell ph = row.getCell(3);
                Cell omc = row.getCell(4);
                Cell ec = row.getCell(5);
                Cell calc = row.getCell(6);
                Cell magn = row.getCell(7);

                if (nitro != null) {
                    // Found column and there is value in the cell.
                    Integer nitroVal = Double.valueOf(nitro.getNumericCellValue()).intValue();
                    if (nitroVal< nitrogen){
                        nutrientMap.put("NitrogenLess",true);
                    }
                    else{
                        nutrientMap.put("NitrogenLess",false);
                    }
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                }
                if (phosp != null) {
                    // Found column and there is value in the cell.
                    Integer phospVal = Double.valueOf(phosp.getNumericCellValue()).intValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (phospVal< phosphorous){
                        nutrientMap.put("PhosphorousLess",true);
                    }
                    else{
                        nutrientMap.put("PhosphorousLess",false);
                    }
                }
                if (potash != null) {
                    // Found column and there is value in the cell.
                    Integer potashVal = Double.valueOf(potash.getNumericCellValue()).intValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (potashVal< potassium){
                        nutrientMap.put("PotassiumLess",true);
                    }
                    else{
                        nutrientMap.put("PotassiumLess",true);
                    }
                }
                if (magn != null) {
                    // Found column and there is value in the cell.
                    Integer magnVal = Double.valueOf(magn.getNumericCellValue()).intValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (magnVal< magnesium){
                        nutrientMap.put("MagnesiumLess",true);
                    }
                    else{
                        nutrientMap.put("MagnesiumLess",false);
                    }
                }
                if (calc != null) {
                    // Found column and there is value in the cell.
                    Integer calcVal = Double.valueOf(calc.getNumericCellValue()).intValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (calcVal< calcium){
                        nutrientMap.put("CalciumLess",true);
                    }
                    else{
                        nutrientMap.put("CalciumLess",false);
                    }
                }
                if (omc != null) {
                    // Found column and there is value in the cell.
                    Double omcVal = omc.getNumericCellValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (omcVal< organicMatterContent){
                        nutrientMap.put("OMCLess",true);
                    }
                    else{
                        nutrientMap.put("OMCLess",false);
                    }
                }
                if (ec != null) {
                    // Found column and there is value in the cell.
                    Double ecVal = ec.getNumericCellValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (ecVal< electricalConductivity){
                        nutrientMap.put("SaltLess",true);
                    }
                    else{
                        nutrientMap.put("SaltLess",false);
                    }
                }
                if (ph != null) {
                    // Found column and there is value in the cell.
                    Double phVal = ph.getNumericCellValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (phVal< phLevel){
                        nutrientMap.put("PHLevelLess",true);
                    }
                    else{
                        nutrientMap.put("PHLevelLess",false);
                    }
                }
            }
        }
        return nutrientMap;
    }



    public static XSSFSheet readXLSX() {
        File file  = new File("NutrientSensorData.xlsx");
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


    public void run() {
        System.out.println("Adding nutrients...");
    }
}
