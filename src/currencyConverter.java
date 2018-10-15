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
                        System.out.println("Podaj kwotę którą dysponujesz");
                        double val = in.nextDouble();
                        System.out.println("Podaj kod waluty w której wpłacasz pieniądze");
                        String code = in.next();
                        System.out.println("Podaj kod waluty wyjściowej");
                        String code2 = in.next();
                        CurrencyEntity w1 = col.getCurrencyByCode(code);
                        CurrencyEntity w2 = col.getCurrencyByCode(code2);
                        System.out.println("Otrzymana wartosc to: " + calc.convert(w1, w2, val) + " " + w2.getCode());
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
