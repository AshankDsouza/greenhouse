package Models;


import java.util.HashMap;

public class NutrientReactComponent {

    public void stabilizeNutrientsContent(HashMap nutrientStatus){
        if (nutrientStatus.get("NitrogenExcess").equals(true)){
            System.out.println("Stabilizing nitrogen level...");

        }
        if (nutrientStatus.get("PhosphorousExcess").equals(true)){
            System.out.println("Stabilizing phosphorous level...");
        }
        if (nutrientStatus.get("PotassiumExcess").equals(true)){
            System.out.println("Stabilizing potassium level...");
        }
        if (nutrientStatus.get("MagnesiumExcess").equals(true)){
            System.out.println("Stabilizing magnesium level...");
        }
        if (nutrientStatus.get("CalciumExcess").equals(true)){
            System.out.println("Stabilizing calcium level...");
        }
        if (nutrientStatus.get("OMCExcess").equals(true)){
            System.out.println("Stabilizing OMC level...");
        }
        if (nutrientStatus.get("SaltExcess").equals(true)){
            System.out.println("Stabilizing salt level...");
        }
        if (nutrientStatus.get("PHLevelLess").equals(true)){
            System.out.println("Stabilizing PH level...");
        }
        if (nutrientStatus.get("PHLevelExceeded").equals(true)){
            System.out.println("Stabilizing PH level...");
        }
    }

}
