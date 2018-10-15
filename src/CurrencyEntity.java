package src;

public class CurrencyEntity {
    private String code;
    private String name;
    private int multiplicand;
    private double exchangeRate;

    public CurrencyEntity(String name, int multipliciand, String code, double exchangeRate) {
        this.code = code;
        this.name = name;
        this.multiplicand = multipliciand;
        this.exchangeRate = exchangeRate;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getMultiplicand() {
        return multiplicand;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }


}
