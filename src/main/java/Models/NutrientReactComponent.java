package Models;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class NutrientReactComponent {

    public void stabilizeNutrientsContent(HashMap nutrientStatus) throws InterruptedException {
        if (nutrientStatus.get("NitrogenExcess").equals(true)){
            System.out.println("Stabilizing nitrogen level...");
            TimeUnit.SECONDS.sleep(4);

        }
        if (nutrientStatus.get("PhosphorousExcess").equals(true)){
            System.out.println("Stabilizing phosphorous level...");
            TimeUnit.SECONDS.sleep(4);
        }
        if (nutrientStatus.get("PotassiumExcess").equals(true)){
            System.out.println("Stabilizing potassium level...");
            TimeUnit.SECONDS.sleep(4);
        }
        if (nutrientStatus.get("MagnesiumExcess").equals(true)){
            System.out.println("Stabilizing magnesium level...");
            TimeUnit.SECONDS.sleep(4);
        }
        if (nutrientStatus.get("CalciumExcess").equals(true)){
            System.out.println("Stabilizing calcium level...");
            TimeUnit.SECONDS.sleep(4);
        }
        if (nutrientStatus.get("OMCExcess").equals(true)){
            System.out.println("Stabilizing OMC level...");
            TimeUnit.SECONDS.sleep(4);
        }
        if (nutrientStatus.get("SaltExcess").equals(true)){
            System.out.println("Stabilizing salt level...");
            TimeUnit.SECONDS.sleep(4);
        }
        if (nutrientStatus.get("PHLevelLess").equals(true)){
            System.out.println("Stabilizing PH level...");
            TimeUnit.SECONDS.sleep(4);
        }
        if (nutrientStatus.get("PHLevelExceeded").equals(true)){
            System.out.println("Stabilizing PH level...");
            TimeUnit.SECONDS.sleep(4);
        }
    }

}
