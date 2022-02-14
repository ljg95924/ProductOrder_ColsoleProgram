package product.controller;

import java.util.List;

public class ProductView {
    private static String productListName = "상품번호\t 상품명\t\t판매가격 \t재고수";

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
}
