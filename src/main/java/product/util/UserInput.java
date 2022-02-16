package product.util;

import java.util.Scanner;

public class UserInput {
    static Scanner scanner = new Scanner(System.in);

    public static String oneInputValue() {
        return scanner.nextLine();
    }

}
