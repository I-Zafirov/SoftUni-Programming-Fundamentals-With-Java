package T33FinExamPreparation;

import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();
        while (!"Sign up".equals(input)) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "Case":
                    switch (tokens[1]) {
                        case "lower":
                            text = text.toLowerCase();
                            System.out.println(text);
                            break;
                        case "upper":
                            text = text.toUpperCase();
                            System.out.println(text);
                            break;
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < text.length() && endIndex > 0 && endIndex < text.length()) {
                        String reverse = text.substring(startIndex, endIndex + 1);
                        char[] charArr = reverse.toCharArray();
                        for (int i = charArr.length - 1; i >= 0; i--) {
                            System.out.print(charArr[i]);
                            ;
                        }
                        System.out.println();
                    }
                    break;
                case "Cut":
                    if (text.contains(tokens[1])) {
                        text = text.replace(tokens[1], "");
                        System.out.println(text);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.\n", text, tokens[1]);
                    }
                    break;
                case "Replace":
                    text = text.replace(tokens[1], "*");
                    System.out.println(text);
                    break;
                case "Check":
                    if (text.contains(tokens[1])) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %s.\n", tokens[1]);
                    }
                    break;
            }
        }
    }
}
