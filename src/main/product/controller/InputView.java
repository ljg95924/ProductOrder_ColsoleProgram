package product.controller;

import product.util.UserInput;

public class InputView {
    private InputView() {

    }

    public static String initialConsoleView() {
        System.out.print("o(order): 주문, q(quit): 종료 ) : ");
        return UserInput.oneInputValue();
    }

    public static String InputProductNum() {
        System.out.print("구매할 상품번호 : ");
        return UserInput.oneInputValue();
    }

    public static String InputProductAmount() {
        System.out.print("구매할 개수: ");
        return UserInput.oneInputValue();
    }
}
