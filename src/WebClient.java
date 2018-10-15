package src;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public abstract class WebClient {
    public static CurrenciesCollection getBuffer()  {

        try {
            Parser parser = new ParserXML();
            CurrenciesCollection col = new CurrenciesCollection(parser.Parse());
            return col;
        }
        catch (IOException | ParserConfigurationException | SAXException e){
            Parser parser_csv = new Parser_CSV();
            try {
                CurrenciesCollection col = new CurrenciesCollection(parser_csv.Parse());
                return col;
            }
            catch (IOException | ParserConfigurationException | SAXException e1){
                }
        }
        return null;
        }
    }