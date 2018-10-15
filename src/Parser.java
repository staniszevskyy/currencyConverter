package src;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

public interface Parser {
    String link="http://www.nbp.pl/kursy/xml/LastA.xml";
    Map<String, CurrencyEntity> Parse() throws IOException, ParserConfigurationException, SAXException;

}
