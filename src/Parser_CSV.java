package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parser_CSV implements Parser {
    @Override
    public Map<String, CurrencyEntity> Parse() {
        String csvFile = "F:/workspace/View/src/waluty.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Map<String, CurrencyEntity> map = new HashMap<>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] temp = line.split(cvsSplitBy);
                temp[0]=temp[0].replace("\"",""); temp[1]=temp[1].replace("\"","");
                temp[2]=temp[2].replace("\"",""); temp[3]=temp[3].replace("\"","");
                map.put(temp[2], new CurrencyEntity(temp[0],Integer.parseInt(temp[1]),temp[2],Double.parseDouble(temp[3])));


            }
            map.put("PLN",new CurrencyEntity("polski złoty", 1, "PLN",1));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }
}
