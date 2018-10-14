package src;

import java.util.Map;

public class View {
    private Calculator calc;
    public void Display(){
        Map<String, CurrencyEntity> map=calc.getAll().getMap();

        for (String element: map.keySet()){
            System.out.printf("%s(%s): %f przelicznik: %f",map.get(element).getName(),
                    map.get(element).getCode(),
                    map.get(element).getExchangeRate() ,
                    map.get(element).getMultipliciand());
        }
    }

    public double Calculate(CurrencyEntity w1, CurrencyEntity w2, double val){
        return calc.convert(w1,w2,val);
    }

}
