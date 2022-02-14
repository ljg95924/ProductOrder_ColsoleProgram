package product.repository;

import product.domain.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileRead {
    public FileRead() {
    }

    public List ReadCSV() {
        //List<Product> csvList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        File csv = new File("C:\\Users\\ljg95\\Downloads\\items.csv");
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            //int increment = 0;
            while ((line = br.readLine()) != null) {
                //increment++;
                //String[] var = line.split(",");
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(list.get(1));

        return list;
    }

}
