package T33FinExamPreparation;

import java.util.Scanner;

public class DoneChangeIncludesEndUppercaseFindIndexCut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] com = command.split("\\s+");
            String first = com[0];

            switch (first) {
                case "Change":
                    char c = com[1].charAt(0);
                    String repl = com[2];
                    input = input.replaceAll(Character.toString(c), repl);
                    System.out.println(input);
                    break;
                case "Includes":
                    String contains = com[1];
                    if (input.contains(contains)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String end = com[1];
                    if (input.endsWith(end)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    StringBuilder str = new StringBuilder(input);
                    for (int i = 0; i < input.length(); i++) {
                        str.setCharAt(i, Character.toUpperCase(str.charAt(i)));
                    }
                    input = str.toString();
                    System.out.println(input);
                    break;
                case "FindIndex":
                    char ch = com[1].charAt(0);
                    int index = input.indexOf(ch);
                    System.out.println(index);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(com[1]);
                    int length = Integer.parseInt(com[2]);
                    input = input.substring(startIndex, startIndex + length);
                    System.out.println(input);
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
