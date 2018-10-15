package src;

public class ValidateNumber implements Validate {
    @Override
    public Boolean check(String name) {
        try {
            Double.parseDouble(name);
        }
        catch (NumberFormatException | NullPointerException e){
            return false;
        }
        return true;
    }
}
