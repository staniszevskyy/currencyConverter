package src;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    private CurrenciesCollection collection;

    public Calculator(CurrenciesCollection collection) {
        this.collection = collection;
    }

    public double convert(CurrencyEntity input, CurrencyEntity output, double value){
        if (input.getCode().equals("PLN")) {
            value /= output.getExchangeRate() * output.getMultiplicand();
            BigDecimal conv = new BigDecimal(value);
            conv = conv.setScale(2, RoundingMode.HALF_UP);
            return conv.doubleValue();
        }
        else if (output.getCode().equals("PLN")) {
            value *= input.getExchangeRate() * input.getMultiplicand();
            BigDecimal conv = new BigDecimal(value);
            conv = conv.setScale(2, RoundingMode.HALF_UP);
            return conv.doubleValue();
        }
        else{
            double plnEquivalent = value*input.getExchangeRate()*input.getMultiplicand();
            plnEquivalent/=output.getExchangeRate()*output.getMultiplicand();

            // rounding to 2 decimal places
            BigDecimal conv = new BigDecimal(plnEquivalent);
            conv = conv.setScale(2, RoundingMode.HALF_UP);
            return conv.doubleValue();
        }
    }

    public CurrencyEntity getCurrencyByCode (String code){
        return collection.getCurrencyByCode(code);
    }

    public CurrenciesCollection getAll() {
        return collection;
    }
}
