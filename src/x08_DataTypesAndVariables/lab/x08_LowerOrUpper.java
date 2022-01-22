package x08_DataTypesAndVariables.lab;

import java.util.Scanner;

public class x08_LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input = scanner.nextLine().charAt(0);

        if (input > 64 && input < 91) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
