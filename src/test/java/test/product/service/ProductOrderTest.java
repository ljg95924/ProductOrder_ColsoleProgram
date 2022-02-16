package product.service;

import org.junit.jupiter.api.*;

//import static org.junit.Assert.*;

public class ProductOrderTest {

    @DisplayName("주문인지 종료인지 입력된 값 비교")
    @Test
    void compareInputValueTest(){
        final ProductOrder productOrder = new ProductOrder();
        final String[] inputStr = {"o","q","w"};

        productOrder.compareInputValue(inputStr[0]);

    }
}