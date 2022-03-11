package T14Methods.lab;

import java.util.Scanner;

public class x07_RepeatString3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int repetition = Integer.parseInt(scanner.nextLine());

        System.out.print(getString(s, repetition));
    }

    private static String getString(String str, int num) {
        String finalStr = "";
        for (int i = 1; i <= num; i++) {
            finalStr += str;
        }
        return finalStr;
    }
}
