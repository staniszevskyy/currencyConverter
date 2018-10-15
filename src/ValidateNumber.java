package src;

public class ValidateNumber implements Validate {
    @Override
    public Boolean check(String name) {
        try {
            double number = Double.parseDouble(name);
            if (number<0) return false;
        }
        catch (NumberFormatException | NullPointerException e){
            return false;

        }
        return true;
    }
}
