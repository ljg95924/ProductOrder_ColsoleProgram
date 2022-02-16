package test.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.domain.Product;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

    @DisplayName("제품이 잘들어가는지 테스트")
    @Test
    void addProductTest() {
        // given
        Product productA = Product.addProduct(12345, "마우스", 50000, 5);
        Product productB = Product.addProduct(12345, "키보드", 30000, 2);
        Product productC = Product.addProduct(12341, "마우스", 50000, 5);

        // then
        assertThat(productA).isEqualTo(productB);
        assertThat(productA).isNotEqualTo(productC);
    }

    @DisplayName("재고감소가 잘되는지 테스트")
    @Test
    void minusStockTest() {
        // given
        Product product = Product.addProduct(12345, "마우스", 50000, 5);
        int orderAmount = 1;
        // when
        product.minusStock(orderAmount);
        // then
        assertThat(product.getStockAmount()).isEqualTo(4);
    }

    @DisplayName("주문이들어왔을때 재고수량체크")
    @Test
    void checkStockAmountTest() {
        Product product = Product.addProduct(12345, "마우스", 50000, 5);
        int orderAmountA = 1;
        int orderAmountB = 6;

        product.checkStockAmount(orderAmountA);
        product.checkStockAmount(orderAmountB);

        assertThat(product.getStockAmount()).isEqualTo(4);
    }



}
