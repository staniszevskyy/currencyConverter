package src;

public class CurrencyEntity {
    private String code;
    private String name;
    private int multipliciand;
    private double exchangeRate;

    public CurrencyEntity(String name, int multipliciand, String code, double exchangeRate) {
        this.code = code;
        this.name = name;
        this.multipliciand = multipliciand;
        this.exchangeRate = exchangeRate;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getMultipliciand() {
        return multipliciand;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setMultipliciand(int multipliciand) {
        this.multipliciand = multipliciand;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
