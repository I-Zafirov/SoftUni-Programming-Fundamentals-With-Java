package T27TextProcessing.lab;

import java.util.Scanner;

public class L2RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        StringBuilder repeatedWords = new StringBuilder();
        for (String word : words) {
            int count = word.length();
            for (int i = 0; i < count; i++) {
                repeatedWords.append(word);
            }
        }
        System.out.println(repeatedWords);
    }
}
