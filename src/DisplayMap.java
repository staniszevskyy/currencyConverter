package src;

import java.util.Map;

public class DisplayMap {
    public static void display(Map<String, CurrencyEntity> map){
        for (String element: map.keySet()){
            System.out.printf("%s(%s): %f przelicznik: %d\n",
                    map.get(element).getName(),
                    map.get(element).getCode(),
                    map.get(element).getExchangeRate(),
                    map.get(element).getMultipliciand());
        }
    }
}
