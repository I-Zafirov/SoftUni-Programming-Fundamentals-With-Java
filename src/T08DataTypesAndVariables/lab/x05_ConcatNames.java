package T08DataTypesAndVariables.lab;

import java.util.Scanner;

public class x05_ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String result = firstName + delimiter + lastName;
        System.out.println(result);
    }
}
