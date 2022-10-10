package T33FinExamPreparation;

import java.util.Scanner;

public class EmailValidator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();
        while (!"Complete".equals(input)) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Make":
                    switch (command[1]) {
                        case "Upper":
                            text = text.toUpperCase();
                            System.out.println(text);
                            break;
                        case "Lower":
                            text = text.toLowerCase();
                            System.out.println(text);
                            break;
                    }
                    break;
                case "GetDomain":
                    int count = Integer.parseInt(command[1]);
                    System.out.println(text.substring(text.length() - count));
                    break;
                case "GetUsername":
                    if (text.contains("@")) {
                        System.out.println(text.substring(0, text.indexOf("@")));
                    } else
                        System.out.printf("The email %s doesn't contain the @ symbol.\n", text);
                    break;
                case "Replace":
                    text = text.replace(command[1], "-");
                    System.out.println(text);
                    break;
                case "Encrypt":
                    char[] charArr = text.toCharArray();
                    for (int i = 0; i < charArr.length; i++) {
                        System.out.print((int) charArr[i] + " ");
                    }
                    break;
            }
        }
    }
}
