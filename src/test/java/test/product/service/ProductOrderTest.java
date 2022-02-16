package test.product.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.domain.Product;
import product.service.ProductOrder;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductOrderTest {

    @DisplayName("주문인지 종료인지 입력된 값 비교")
    @Test
    void compareInputValueTest() {
        final ProductOrder productOrder = new ProductOrder();
        final String[] inputStr = {"o", "q", "w"};

        productOrder.compareInputValue(inputStr[0]);
        productOrder.compareInputValue(inputStr[1]);
    }


    @DisplayName("제품 수량이 구매수량 만큼 있는지 확인하는 테스트")
    @Test
    void countOrderProductTest() {
        Product productA = Product.addProduct(
                12345, "마우스", 50000, 5);
        Product productB = null;
        ProductOrder productOrder = new ProductOrder();

        Boolean resultA = productOrder.countOrderProduct(productA, 3);
        Boolean resultB = productOrder.countOrderProduct(productB, 3);

        assertThat(resultA).isTrue();
        assertThat(resultB).isFalse();
    }

    @DisplayName("입력받은 제품코드가 판매목록에 있는지 체크하는 테스트")
    @Test
    void findOrderProductTest() {
        ProductOrder productOrder = new ProductOrder();
        List<Product> productList = new ArrayList<>();
        productList.add(Product.addProduct(
                12345, "마우스", 50000, 5));
        productList.add(Product.addProduct(
                98765, "키보드", 100000, 10));
        productList.add(Product.addProduct(
                55555, "모니터", 500000, 3));
        productList.add(Product.addProduct(
                882231, "스피커", 30000, 4));
        int productCodeNum = 12345;

        Product product = productOrder.findOrderProduct(productList, productCodeNum);

        assertThat(product).isEqualTo(productList.get(0));
        assertThat(product).isNotEqualTo(productList.get(1));
    }


}
