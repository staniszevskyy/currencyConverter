package src;

import java.util.ArrayList;
import java.util.Map;

public class CurrenciesCollection {
    private Map<String, CurrencyEntity> map;

    public CurrenciesCollection(Map<String, CurrencyEntity> map) {
        this.map = map;
    }

    public CurrencyEntity getCurrencyByCode(String code){
        for (String name : map.keySet()){
            if (map.get(name).getCode().equals(code))
                return map.get(name);
        }
        return null;
    }

    public Map<String, CurrencyEntity> getMap() {
        return map;
    }

    public void Display(){
        for (String element: map.keySet()){
            System.out.printf("%s(%s): %f przelicznik: %d\n",
                    map.get(element).getName(),
                    map.get(element).getCode(),
                    map.get(element).getExchangeRate(),
                    map.get(element).getMultipliciand());
        }
    }

}
