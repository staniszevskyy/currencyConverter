package src;

public class ValidateNumber implements Validate {
    @Override
    public Boolean check(String name) {
        try {
            double val = Double.parseDouble(name);
        }
        catch (NumberFormatException | NullPointerException e){
            return false;
        }
        return true;
    }
}
