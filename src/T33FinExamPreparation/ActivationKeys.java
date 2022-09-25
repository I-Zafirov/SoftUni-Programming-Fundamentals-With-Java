package T33FinExamPreparation;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawActivationKey = scanner.nextLine();
        String input = scanner.nextLine();

        while (!"Generate".equals(input)) {
            String[] tokens = input.split(">>>");

            switch (tokens[0]) {
                case "Contains":
                    String substring = tokens[1];
                    if (rawActivationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", rawActivationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String letterCase = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndexExclusive = Integer.parseInt(tokens[3]);
                    String subStr = rawActivationKey.substring(startIndex, endIndexExclusive);

                    switch (letterCase) {
                        case "Upper":
                            rawActivationKey = rawActivationKey.replace(subStr, subStr.toUpperCase());
                            // !!!
                            break;
                        case "Lower":
                            rawActivationKey = rawActivationKey.replace(subStr, subStr.toLowerCase());
                            break;
                    }
                    System.out.println(rawActivationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndexExclusive = Integer.parseInt(tokens[2]);
                    rawActivationKey = rawActivationKey.substring(0, startIndex) + rawActivationKey.substring(endIndexExclusive);
                    //String toBeReplaced = rawActivationKey.substring(startIndex, endIndexExclusive);
                    //rawActivationKey = rawActivationKey.replace(toBeReplaced, "");
                    System.out.println(rawActivationKey);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", rawActivationKey);
    }
}
