package product.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileRead {
    public FileRead() {
    }

    public List readCSV() {
        List<String> stringArrayList = new ArrayList<>();
        File csv = new File("C:\\Users\\ljg95\\Downloads\\items.csv");
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {

            while ((line = br.readLine()) != null) {

                stringArrayList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringArrayList;
    }

}
