package Models;
import Interfaces.Agent;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import services.FileServices;

import java.util.HashMap;


public class NutirentFeedbackAgent implements Agent {
    public static int nitrogen = 80; //unit ppm
    public static int phosphorous = 60; //unit ppm
    public static int potassium = 200; //unit ppm
    public static double phLevelMax = 8.5; //unit ph

    public static double phLevelMin = 5.5; //unit ph

    public static double organicMatterContent = 10; //(organic matter content) unit percentage

    public static double electricalConductivity = 4; // electrical conductivity unit -> ds/m

    public static int calcium = 2000; //unit ppm
    public static int magnesium = 400; //unit ppm

    public static boolean feedbackRequired = false;

    public static HashMap currentNutrientStatus = new HashMap();
    public void readSensors() {
        System.out.println("Reading nutrient level in feedback...");
        XSSFSheet sensorData = FileServices.readXLSX("NutrientSensorData.xlsx");
        HashMap nutrientDefficiencyMap = analyseNutrientAfterNutrientAddition(sensorData);
        currentNutrientStatus = nutrientDefficiencyMap;
    }

    public void run() {
        if (feedbackRequired){
        System.out.println("Calling back nutrient agent for discrepancy.....");
        }
    }

    @Override
    public void alert(String message) {

    }

    @Override
    public void waitForSomeTime() {

    }

    public static HashMap analyseNutrientAfterNutrientAddition(XSSFSheet mysheet){
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
                        nutrientMap.put("NitrogenExcess",true);
                        feedbackRequired = true;
                    }
                    else{
                        nutrientMap.put("NitrogenExcess",false);
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
                        nutrientMap.put("PhosphorousExcess",true);
                        feedbackRequired = true;
                    }
                    else{
                        nutrientMap.put("PhosphorousExcess",false);
                    }
                }
                if (potash != null) {
                    // Found column and there is value in the cell.
                    Integer potashVal = Double.valueOf(potash.getNumericCellValue()).intValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (potashVal< potassium){
                        nutrientMap.put("PotassiumExcess",true);
                        feedbackRequired = true;
                    }
                    else{
                        nutrientMap.put("PotassiumExcess",false);
                    }
                }
                if (magn != null) {
                    // Found column and there is value in the cell.
                    Integer magnVal = Double.valueOf(magn.getNumericCellValue()).intValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (magnVal> magnesium){
                        nutrientMap.put("MagnesiumExcess",true);
                        feedbackRequired = true;
                    }
                    else{
                        nutrientMap.put("MagnesiumExcess",false);
                    }
                }
                if (calc != null) {
                    // Found column and there is value in the cell.
                    Integer calcVal = Double.valueOf(calc.getNumericCellValue()).intValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (calcVal> calcium){
                        nutrientMap.put("CalciumExcess",true);
                        feedbackRequired = true;
                    }
                    else{
                        nutrientMap.put("CalciumExcess",false);
                    }
                }
                if (omc != null) {
                    // Found column and there is value in the cell.
                    Double omcVal = omc.getNumericCellValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (omcVal> organicMatterContent){
                        nutrientMap.put("OMCExcess",true);
                        feedbackRequired = true;
                    }
                    else{
                        nutrientMap.put("OMCExcess",false);
                    }
                }
                if (ec != null) {
                    // Found column and there is value in the cell.
                    Double ecVal = ec.getNumericCellValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (ecVal> electricalConductivity){
                        nutrientMap.put("SaltExcess",true);
                        feedbackRequired = true;
                    }
                    else{
                        nutrientMap.put("SaltExcess",false);
                    }
                }
                if (ph != null) {
                    // Found column and there is value in the cell.
                    Double phVal = ph.getNumericCellValue();
                    // Do something with the cellValueMaybeNull here ...
                    // break; ???
                    if (phVal< phLevelMin){
                        nutrientMap.put("PHLevelLess",true);
                        feedbackRequired = true;
                    }
                    else{
                        nutrientMap.put("PHLevelLess",false);
                    }
                    if (phVal> phLevelMax){
                        nutrientMap.put("PHLevelExceeded",true);
                        feedbackRequired = true;
                    }
                    else{
                        nutrientMap.put("PHLevelExceeded",false);
                    }
                }
            }
        }
        return nutrientMap;
    }



}
