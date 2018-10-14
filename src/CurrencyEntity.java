package src;

public class CurrencyEntity {
    private String code;
    private String name;
    private double multipliciand;
    private double exchangeRate;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getMultipliciand() {
        return multipliciand;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setMultipliciand(double multipliciand) {
        this.multipliciand = multipliciand;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
