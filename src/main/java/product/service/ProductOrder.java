package product.service;

import product.controller.InputView;
import product.controller.ProductView;
import product.domain.Product;
import product.repository.ClassifyFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductOrder {
    static boolean OrderMode = true;

    public static void start() {
        ProductOrder productOrder = new ProductOrder();
        ClassifyFile classifyFile = new ClassifyFile();
        List<Product> productList = classifyFile.classifyFile(classifyFile.getFileToList());
        while (true) {
            productOrder.compareInputValue(InputView.initialConsoleView());
            if (!OrderMode) break;
            ProductView.productListView(productList);
            productOrder.order(productList);
        }
    }


    public void compareInputValue(String userInput) {
        if (userInput.equals("o")) {

        } else if (userInput.equals("q")) {
            System.out.println("고객님의 주문 감사합니다.");
            OrderMode = false;
        } else {
            System.out.print("다시 입력해주세요. ");
            compareInputValue(InputView.initialConsoleView());
        }
    }

    public void order(List<Product> productList) {
        int totalPrice = 0;
        int productCodeNum, purchaseAmountNum;
        StringBuilder productCode = new StringBuilder();
        StringBuilder purchaseAmount = new StringBuilder();
        List<Product> orderProductList = new ArrayList<>();
        do {
            productCode.append(InputView.inputProductNum());
            purchaseAmount.append(InputView.inputProductAmount());

            if (!productCode.isEmpty() && !purchaseAmount.isEmpty()) {
                productCodeNum = Integer.parseInt(String.valueOf(productCode));
                purchaseAmountNum = Integer.parseInt(String.valueOf(purchaseAmount));
                productCode.setLength(0);
                purchaseAmount.setLength(0);
                Product product = findOrderProduct(productList, productCodeNum);
                if (countOrderProduct(product, purchaseAmountNum)) {
                    totalPrice += product.getPrice() * purchaseAmountNum;
                    orderProductList.add(Product.orderedProduct(product.getNumber(), product.getName(), product.getPrice(), purchaseAmountNum));
                } else break;


            } else break;
        }
        while (true);
        if (!orderProductList.isEmpty()) {
            ProductView.orderList(orderProductList);
            ProductView.printOrderTotalPrice(totalPrice);
        }
        // return productList;
    }

    public boolean countOrderProduct(Product product, int purchaseAmountNum) {
        if (product == null) {
            return false;
        }
        return product.checkStockAmount(purchaseAmountNum);

    }

    public Product findOrderProduct(List<Product> productList, int productCodeNum) {
        Iterator<Product> iterator = productList.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (productCodeNum == product.getNumber()) {
                return product;
            }
        }
        System.out.println("찾는 제품이없습니다.");
        return null;
    }


}
