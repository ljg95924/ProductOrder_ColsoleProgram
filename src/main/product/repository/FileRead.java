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
        List<Product> csvList = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        File csv = new File("C:\\Users\\ljg95\\Downloads\\items.csv");
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            int increment = 0;
            while ((line = br.readLine()) != null) {
                increment++;
                String[] var = line.split(",");
                list.add(Arrays.asList(var));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list);

        return csvList;
    }
/*
        if(increment ==1)

    {
        continue;
    }
        if(increment ==13)

    {
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
        csvList.add(new

    Product(productNumber, name, price, stock));*/


}
