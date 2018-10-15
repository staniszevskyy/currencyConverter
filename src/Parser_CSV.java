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
        String csvFile = "F:/workspace/currencyConverter/src/waluty.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Map<String, CurrencyEntity> map = new HashMap<>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] temp = line.split(cvsSplitBy);
                map.put(temp[2], new CurrencyEntity(temp[0],Integer.parseInt(temp[1]),temp[2],Double.parseDouble(temp[3])));

            }

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
