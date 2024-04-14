package Models;

import java.util.HashMap;

public class NutrientAdder {

    public  void addNutrients(HashMap nutrientStatus){
        if (nutrientStatus.get("NitrogenLess").equals(true)){
            System.out.println("Adding nitrogen");
        }
        if (nutrientStatus.get("PhosphorousLess").equals(true)){
            System.out.println("Adding phosphorous");
        }
        if (nutrientStatus.get("PotassiumLess").equals(true)){
            System.out.println("Adding potassium");
        }
        if (nutrientStatus.get("OMCLess").equals(true)){
            System.out.println("Adding OMC");
        }
        if (nutrientStatus.get("SaltLess").equals(true)){
            System.out.println("Adding salt");
        }
        if (nutrientStatus.get("PHLevelLess").equals(true)){
            System.out.println("Adding ph");
        }
        if (nutrientStatus.get("CalciumLess").equals(true)){
            System.out.println("Adding calcium");
        }
        if (nutrientStatus.get("MagnesiumLess").equals(true)){
            System.out.println("Adding magnesium");
        }
    }
}
