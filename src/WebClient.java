package src;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class WebClient  {
    public static final String link="http://www.nbp.pl/kursy/xml/LastA.xml";


    public static BufferedInputStream getBuffer() throws MalformedURLException, IOException {
        URL url = new URL(link);
        BufferedInputStream buffer =  new BufferedInputStream(url.openStream());
        return buffer;
    }

}
