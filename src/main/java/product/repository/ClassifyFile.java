package product.repository;

import product.domain.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassifyFile {
    String line = "";
    String[] var;
    int increment = 0;
    long productNumber;
    String name;
    int price, stock;

    public List<String> getFileToList() {
        FileRead fileRead = new FileRead();
        return fileRead.readCSV();
    }

    public List<Product> classifyFile(List<String> lists) {
        Iterator iterator = lists.iterator();
        List<Product> productList = new ArrayList<>();
        while (iterator.hasNext()) {
            increment++;
            line = (String) iterator.next();
            var = line.split(",");
            if (increment == 1) {
                continue;
            }
            if (increment == 13) {
                productNumber = Long.parseLong(var[0].trim());
                name = var[1].trim();
                price = Integer.parseInt(var[3].trim());
                stock = Integer.parseInt(var[4].trim());
                productList.add(Product.addProduct(productNumber, name, price, stock));
                continue;
            }
            productNumber = Long.parseLong(var[0].trim());
            name = var[1].trim();
            price = Integer.parseInt(var[2].trim());
            stock = Integer.parseInt(var[3].trim());
            productList.add(Product.addProduct(productNumber, name, price, stock));
        }
        return productList;
    }
}
