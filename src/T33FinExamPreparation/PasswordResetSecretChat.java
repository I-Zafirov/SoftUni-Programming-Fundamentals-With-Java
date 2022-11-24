package T33FinExamPreparation;

import java.util.Scanner;

public class PasswordResetSecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "TakeOdd":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            sb.append(password.charAt(i));
                        }
                    }
                    password = sb.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    int endIndexExclusive = index + length;

                    String firstPart = password.substring(0, index);
                    String lastPart = password.substring(endIndexExclusive);
                    password = firstPart + lastPart;

//                    91/100
//                    String substringToRemoveItsFirstOccurrence = password.substring(index, endIndexExclusive);
//                    password = password.replace(substringToRemoveItsFirstOccurrence, ""); // remove all occurrences

                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];

                    if (password.contains(substring)) {
                        password = password.replaceAll(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + tokens[0]);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
