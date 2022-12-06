package T33FinExamPreparation;

import java.util.Scanner;

public class StringGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("Done")) {
            switch (command[0]) {
                case "Change":
                    str = str.replaceAll(command[1], command[2]);
                    System.out.println(str);
                    break;
                case "Includes":
                    if (str.contains(command[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    if (str.endsWith(command[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    str = str.toUpperCase();
                    System.out.println(str);
                    break;
                case "FindIndex":
                    System.out.println(str.indexOf(command[1]));
                    break;
                case "Cut":
                    StringBuilder newStr = new StringBuilder();
                    int startIndex = Integer.parseInt(command[1]);
                    int count = Integer.parseInt(command[2]);

                    for (int i = 0; i < count; i++) {
                        newStr.append(str.charAt(startIndex));
                        startIndex++;
                    }

                    System.out.println(newStr);
                    break;
            }

            command = scanner.nextLine().split(" ");
        }
    }
}
