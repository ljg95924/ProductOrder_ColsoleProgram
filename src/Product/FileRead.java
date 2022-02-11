package Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileRead {
    public FileRead() {
    }

    public List ReadCSV() {
        List<Product> csvList = new ArrayList<>();
        File csv = new File("C:\\Users\\ljg95\\Downloads\\items.csv");
        BufferedReader br = null;
        String line = "";

        try {
            int increment = 0;
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                increment++;
                String[] var = line.split(",");
                if (increment == 1) {
                    continue;
                }
                if (increment == 13) {
                    long productNumber = Long.parseLong(var[0].trim());
                    String name = var[1].trim();
                    int price = Integer.parseInt(var[3].trim());
                    int stock = Integer.parseInt(var[4].trim());
                    csvList.add(new Product(productNumber, name, price, stock));
                    continue;
                }
                //System.out.println(line);
                long productNumber = Long.parseLong(var[0].trim());
                String name = var[1].trim();
                int price = Integer.parseInt(var[2].trim());
                int stock = Integer.parseInt(var[3].trim());
                csvList.add(new Product(productNumber, name, price, stock));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvList;
    }
}
