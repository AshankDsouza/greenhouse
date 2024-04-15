package Models;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class NutrientAdder {

    public  void addNutrients(HashMap nutrientStatus) throws InterruptedException {
        if (nutrientStatus.get("NitrogenLess").equals(true)){
            System.out.println("Adding nitrogen");
            TimeUnit.SECONDS.sleep(4);

        }
        if (nutrientStatus.get("PhosphorousLess").equals(true)){
            System.out.println("Adding phosphorous");
            TimeUnit.SECONDS.sleep(4);

        }
        if (nutrientStatus.get("PotassiumLess").equals(true)){
            System.out.println("Adding potassium");
            TimeUnit.SECONDS.sleep(4);

        }
        if (nutrientStatus.get("OMCLess").equals(true)){
            System.out.println("Adding OMC");
            TimeUnit.SECONDS.sleep(4);

        }
        if (nutrientStatus.get("SaltLess").equals(true)){
            System.out.println("Adding salt");
            TimeUnit.SECONDS.sleep(4);

        }
        if (nutrientStatus.get("PHLevelLess").equals(true)){
            System.out.println("Adding ph");
            TimeUnit.SECONDS.sleep(4);

        }
        if (nutrientStatus.get("CalciumLess").equals(true)){
            System.out.println("Adding calcium");
            TimeUnit.SECONDS.sleep(4);

        }
        if (nutrientStatus.get("MagnesiumLess").equals(true)){
            System.out.println("Adding magnesium");
            TimeUnit.SECONDS.sleep(4);

        }
    }
}
