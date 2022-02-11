package x14_Methods.lab;

import java.util.Scanner;

public class x07_RepeatString4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int repetition = Integer.parseInt(scanner.nextLine());
        System.out.print(printString(s, repetition));
    }

    public static StringBuilder printString(String input, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(input);
        }
        return result;
    }
}
