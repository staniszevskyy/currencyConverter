package src;

import java.util.ArrayList;
import java.util.Map;

public class CurrenciesCollection {
    private Map<String, CurrencyEntity> map;

    // dorobic konstruktor dzialajacy na xmlu


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
}
