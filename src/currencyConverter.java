package src;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class currencyConverter {

    public static void displayMenu(){
        System.out.println("**************************************************");
        System.out.println("Podaj co chcesz zrobić");
        System.out.println("1. Wypisz wszystkie waluty");
        System.out.println("2. Przekonwertuj walutę");
        System.out.println("3. Zakończ");
        System.out.println("**************************************************");
    }

    public static void secondCaseQuery(Scanner in, Calculator calc){
        Validate validateCode = new ValidateCode(calc);
        Validate validateNumber = new ValidateNumber();

        System.out.println("Podaj kwotę którą dysponujesz");
        String val = in.next();
        validateNumber.check(val);
        System.out.println("Podaj kod waluty w której wpłacasz pieniądze");
        String code = in.next();
        validateCode.check(code);
        System.out.println("Podaj kod waluty wyjściowej");
        String code2 = in.next();
        validateCode.check(code2);
        if (validateNumber.check(val) && validateCode.check(code) && validateCode.check(code2)) {
            code=code.toUpperCase();
            code2=code2.toUpperCase();
            CurrencyEntity w1 = calc.getCurrencyByCode(code); // col.getCurr before changes
            CurrencyEntity w2 = calc.getCurrencyByCode(code2);
            System.out.println("Otrzymana wartosc to: " + calc.convert(w1, w2, Double.parseDouble(val)) + " " + w2.getCode());
        }
        else
            System.out.println("Niepoprawne dane");
    }



    public static void main(String args[]){

            CurrenciesCollection col =  WebClient.getBuffer();
            Calculator calc = new Calculator(col);
            Scanner in = new Scanner(System.in);
            displayMenu();

            while(true) {
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        col.Display();
                        break;
                    case 2:
                        secondCaseQuery(in, calc);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Niepoprawna opcja");
                        break;

                }
                displayMenu();

            }




    }
}
