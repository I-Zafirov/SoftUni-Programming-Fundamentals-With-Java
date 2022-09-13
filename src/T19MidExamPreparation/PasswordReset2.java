package T19MidExamPreparation;

import java.util.Scanner;

public class PasswordReset2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 1; i < password.length(); i += 2) {
                        newPassword.append(password.charAt(i));
                    }
                    password = newPassword;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    password.replace(index, index + length, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if (password.indexOf(substring) == -1) {
                        System.out.println("Nothing to replace!");
                    } else {
                        while (password.indexOf(substring) != -1) {
                            password.replace(password.indexOf(substring), password.indexOf(substring) + substring.length(), substitute);
                        }
                        System.out.println(password);
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
