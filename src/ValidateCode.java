package src;

public class ValidateCode implements Validate{
    public Calculator calc;

    public ValidateCode(Calculator calc) {
        this.calc = calc;
    }

    @Override
    public Boolean check(String name) {
        name = name.toUpperCase();
        if (calc.getCurrencyByCode(name) == null)
            return false;

        return true;
    }
}
