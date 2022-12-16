package T33FinExamPreparation;

import java.util.Scanner;

public class ValidYourUsernameMustContainSignUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Sign up")) {
            String[] data = input.split(" ");
            String cmd = data[0];
            switch (cmd) {
                case "Case":
                    String type = data[1];
                    if (type.equals("lower")) {
                        username = username.toLowerCase();
                    } else {
                        username = username.toUpperCase();
                    }
                    System.out.println(username);
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]);
                    if (checkIndex(username, startIndex) && checkIndex(username, endIndex)) {
                        String sub = username.substring(startIndex, endIndex + 1);
                        for (int i = sub.length() - 1; i >= 0; i--) {
                            System.out.print(sub.charAt(i));
                        }
                        System.out.println();
                    }
                    break;
                case "Cut":
                    String subString = data[1];
                    if (username.contains(subString)) {
                        username = username.replace(subString, "");
                        System.out.println(username);
                    } else {
                        System.out.println("The word " + username + " doesn't contain " + subString + ".");
                    }
                    break;
                case "Replace":
                    String c = data[1];
                    if (username.contains(c)) {
                        username = username.replaceAll(c, "*");
                    }
                    System.out.println(username);
                    break;
                case "Check":
                    String ch = data[1];
                    if (!username.contains(ch)) {
                        System.out.println("Your username must contain " + ch + ".");
                    } else {
                        System.out.println("Valid");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static boolean checkIndex(String s, int index) {
        return index >= 0 && index < s.length();
    }
}
