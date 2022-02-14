package product.controller;

import java.util.Scanner;

public class InputView {
    private InputView() {

    }

    public static String initialConsoleView() {
        System.out.print("o(order): 주문, q(quit): 종료 ) : ");
        Scanner scanner = new Scanner(System.in);
        String UserInput = scanner.nextLine();
        return UserInput;
    }
}
