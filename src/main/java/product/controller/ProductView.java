package product.controller;

import product.domain.Product;

import java.text.DecimalFormat;
import java.util.List;

public class ProductView {
    private static final String productListName = "상품번호\t 상품명\t\t판매가격 \t재고수";

    private ProductView() {

    }

    public static void productListView(List productList) {
        System.out.println(productListName);
        for (Object o : productList
        ) {
            System.out.println(o.toString());
        }

        System.out.println();
    }

    public static void printOrderTotalPrice(int totalPrice) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        System.out.println("주문금액: " + formatter.format(totalPrice) + "원");
        if (totalPrice < 50000) {
            totalPrice += 2500;
            System.out.println("배송비: " + formatter.format(2500) + "원");
        }
        System.out.println("지불금액: " + formatter.format(totalPrice) + "원");
    }

    public static void orderList(List<Product> orderProduct) {
        System.out.println("주문내역: ");
        for (Product product : orderProduct
        ) {
            product.printOrderProduct();
        }

    }
}
