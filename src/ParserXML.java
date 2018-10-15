package src;

import java.io.BufferedInputStream;
import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class ParserXML implements Parser{
    @Override
    public Map<String, CurrencyEntity> Parse() throws IOException, ParserConfigurationException, SAXException {
        //parser buffer into xml
        Map<String, CurrencyEntity> map = new HashMap<>();

        BufferedInputStream buffer = WebClient.getBuffer();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(buffer);
        Element root = doc.getDocumentElement();
        NodeList nList = doc.getElementsByTagName("pozycja");
        for (int i = 0; i < nList.getLength(); i++)
        {
            Node node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;

                CurrencyEntity curEl = new CurrencyEntity(
                        eElement.getElementsByTagName("nazwa_waluty").item(0).getTextContent(),
                        Integer.parseInt(eElement.getElementsByTagName("przelicznik").item(0).getTextContent()),
                        eElement.getElementsByTagName("kod_waluty").item(0).getTextContent(),
                        Double.parseDouble(eElement.getElementsByTagName("kurs_sredni").item(0).getTextContent().replaceAll(",","."))
                );
                map.put( curEl.getCode(), curEl);

            }
        }
        return map;
    }
}
