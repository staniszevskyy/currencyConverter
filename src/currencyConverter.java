package src;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class currencyConverter {
    public static void main(String args[]){
        ParserXML parser = new ParserXML();

            Scanner in = new Scanner(System.in);
            System.out.println("Podaj kwotę którą dysponujesz");
            double val = in.nextDouble();
            System.out.println("Podaj kod waluty w której wpłacasz pieniądze");
            String code = in.next();
            System.out.println("Podaj kod waluty wyjściowej");
            String code2 = in.next();

            try {
                CurrenciesCollection col = new CurrenciesCollection(parser.Parse());
                CurrencyEntity w1 = col.getCurrencyByCode(code);
                CurrencyEntity w2 = col.getCurrencyByCode(code2);
                Calculator calc = new Calculator(col);
                System.out.println(calc.convert(w1,w2, val));
            }

            catch (IOException | ParserConfigurationException | SAXException e){
                Parser_CSV parser_csv = new Parser_CSV();
                CurrenciesCollection col = new CurrenciesCollection(parser_csv.Parse());
                CurrencyEntity w1 = col.getCurrencyByCode(code);
                CurrencyEntity w2 = col.getCurrencyByCode(code2);
                Calculator calc = new Calculator(col);
                System.out.println(calc.convert(w1,w2, val));
            }













    }
}
