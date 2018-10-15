package src;

public class Calculator {
    private CurrenciesCollection collection;

    public Calculator(CurrenciesCollection collection) {
        this.collection = collection;
    }

    public double convert(CurrencyEntity input, CurrencyEntity output, double value){
        if (input.getCode().equals("PLN"))
            return value/output.getExchangeRate()*output.getMultiplicand();
        else if (output.getCode().equals("PLN"))
            return value*input.getExchangeRate()*input.getMultiplicand();
        else{
            double plnEquivalent = value*input.getExchangeRate()*input.getMultiplicand();
            return plnEquivalent/output.getExchangeRate()*output.getMultiplicand();
        }
    }

    public CurrencyEntity getCurrencyByCode (String code){
        return collection.getCurrencyByCode(code);
    }

    public CurrenciesCollection getAll() {
        return collection;
    }
}
