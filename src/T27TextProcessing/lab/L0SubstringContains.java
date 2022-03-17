package T27TextProcessing.lab;

import java.util.Scanner;

public class L0SubstringContains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String text = scanner.nextLine();

        while (text.contains(key)) {
            text = text.replace(key, "");

        }
        System.out.println(text);
    }
}
