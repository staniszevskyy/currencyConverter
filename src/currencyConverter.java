package src;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class currencyConverter {
    public static void main(String args[]){
        ParserXML parser = new ParserXML();
        try {
            CurrenciesCollection col = new CurrenciesCollection(parser.Parse());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
