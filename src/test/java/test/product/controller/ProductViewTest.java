package test.product.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.controller.ProductView;
import product.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductViewTest {

    @DisplayName("제품목록 출력")
    @Test
    void productListViewTest() {
        List<Product> productList = new ArrayList<>();

        productList.add(Product.addProduct(
                12345, "마우스", 50000, 5));
        productList.add(Product.addProduct(
                98765, "키보드", 100000, 10));
        productList.add(Product.addProduct(
                55555, "모니터", 500000, 3));
        productList.add(Product.addProduct(
                882231, "스피커", 30000, 4));

        ProductView.productListView(productList);
    }

    @DisplayName("주문내역 출력")
    @Test
    void orderListTest() {
        final List<Product> orderProductList = new ArrayList<>();

        orderProductList.add(Product.orderedProduct(
                12345, "마우스", 50000, 3));
        orderProductList.add(Product.orderedProduct(
                98765, "키보드", 100000, 5));

        ProductView.orderList(orderProductList);
    }

    @DisplayName("결제금액 출력")
    @Test
    void printOrderTotalPriceTest() {
        final int totalPrice;

        totalPrice = 40000;

        ProductView.printOrderTotalPrice(totalPrice);
    }
}
