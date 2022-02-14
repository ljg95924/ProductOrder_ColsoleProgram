package product.service;

import product.controller.ProductView;
import product.controller.InputView;
import product.dao.Product;
import product.repository.FileRead;

import java.text.DecimalFormat;
import java.util.*;

public class ProductOrder {
    public static void main(String[] args) {
        ProductOrder productOrder = new ProductOrder();
        FileRead fileRead = new FileRead();
        ProductView productView = new ProductView();

        List<Product> productList = fileRead.ReadCSV();

        while (true) {
            InputView.inputConsoleVeiw();
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

    public List Order(List<Product> productList) {
        int totalPrice = 0;
        List<Product> orderProduct = new ArrayList<>();
        do {
            System.out.print("상품번호 : ");
            Scanner scanner = new Scanner(System.in);
            String productCodeNum = scanner.nextLine();
            System.out.print("수량: ");
            String purchaseAmount = scanner.nextLine();

            if (productCodeNum.isEmpty() && purchaseAmount.isEmpty()) {
                break;
            } else if (!productCodeNum.isEmpty() && !purchaseAmount.isEmpty()) {
                Iterator<Product> iterator = productList.iterator();
                int CodeNum = Integer.parseInt(productCodeNum);
                int purchaseAmountNum = Integer.parseInt(purchaseAmount);
                while (iterator.hasNext()) {
                    Product product = iterator.next();
                    if (CodeNum == product.getNumber()) {
                        product.setStockAmount(product.getStockAmount() - purchaseAmountNum);
                        if (CheckStock(product.getStockAmount(), purchaseAmountNum)) {
                            totalPrice += (purchaseAmountNum * product.getPrice());
                            orderProduct.add(new Product(product.getNumber(), product.getName(), product.getPrice(), purchaseAmountNum));
                        }
                        break;
                    }

                }
            }
        }
        while (true);
        if (!orderProduct.isEmpty()) {
            OrderList(orderProduct, totalPrice);
        }
        return productList;
    }


    public boolean CheckStock(int stockAmount, int purchaseAmount) {
        if (stockAmount > purchaseAmount && stockAmount > 0) {
            return true;
        }
        return false;
    }

    public void OrderList(List<Product> orderProduct, int totalPrice) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        System.out.println("주문내역: ");
        for (Product product : orderProduct
        ) {
            System.out.println(product.getName() + " - " + product.getStockAmount() + "개");
        }
        System.out.println("주문금액: " + formatter.format(totalPrice) + "원");
        if (totalPrice < 50000) {
            totalPrice += 2500;
            System.out.println("배송비: " + formatter.format(2500) + "원");
        }
        System.out.println("지불금액: " + formatter.format(totalPrice) + "원");
    }

}
