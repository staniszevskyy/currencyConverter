package src;

public class Calculator {
    private CurrenciesCollection collection;

    public Calculator(CurrenciesCollection collection) {
        this.collection = collection;
    }

    public double convert(CurrencyEntity input, CurrencyEntity output, double value){
        if (input.getCode().equals("PLN"))
            return value/=output.getExchangeRate()*output.getMultipliciand();
        else if (output.getCode().equals("PLN"))
            return value*=input.getExchangeRate()*input.getMultipliciand();
        else{
            double plnEquivalent = value*input.getExchangeRate()*input.getMultipliciand();
            return plnEquivalent/=output.getExchangeRate()*output.getMultipliciand();
        }
    }

    public CurrencyEntity getCurrencyByCode (String code){
        return collection.getCurrencyByCode(code);
    }

    public CurrenciesCollection getAll() {
        return collection;
    }
}
