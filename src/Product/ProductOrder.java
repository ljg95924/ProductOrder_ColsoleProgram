package Product;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductOrder {
    public static void main(String[] args) {
        ProductOrder productOrder = new ProductOrder();
        FileRead fileRead = new FileRead();
        InputView inputView = new InputView();
        ProductView productView = new ProductView();

        List<Product> productList = fileRead.ReadCSV();

        while (true) {
            inputView.inputConsoleVeiw();
            Scanner scanner = new Scanner(System.in);
            String UserInput = scanner.nextLine();
            productOrder.CompareInputValue(UserInput);

            productView.ListView(productList);
            productOrder.Order(productList);
        }
    }

    public void CompareInputValue(String UserInput) {
        if (UserInput.equals("o")) {

        } else if (UserInput.equals("q")) {
            System.out.println("고객님의 주문 감사합니다.");
            System.exit(0);
        } else {
            System.out.print("다시 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            String ReInput = scanner.nextLine();
            CompareInputValue(ReInput);
        }
    }

    public List Order(List productList) {
        do {
            OrderOne()
        }
        while ()

    }

    public List OrderOne(List productList) {
        System.out.print("상품번호 : ");
        Scanner scanner = new Scanner(System.in);
        int productNum = scanner.nextInt();
        System.out.print("수량: ");
        int stockNum = scanner.nextInt();

    }
}
