package T33FinExamPreparation;

import java.util.Scanner;

public class MelrahShake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String inputPattern = scanner.nextLine();
        StringBuilder builder = new StringBuilder(inputPattern);
        while (true) {
            int count;
            int length = inputPattern.length();
            count = findOccurrences(text, inputPattern);
            if (count <= 1 || length < 1) {
                System.out.println("No shake.");
                break;
            }
            if (count >= 2) {
                text = text.substring(0, text.indexOf(inputPattern))
                        + text.substring(text.indexOf(inputPattern)
                        + inputPattern.length(), text.length());
                text = text.substring(0, text.lastIndexOf(inputPattern))
                        + text.substring(text.lastIndexOf(inputPattern)
                        + inputPattern.length(), text.length());
                System.out.println("Shaked it.");
            }
            builder.deleteCharAt(length / 2);
            inputPattern = builder.toString();
        }
        System.out.println(text);
    }

    private static int findOccurrences(String mainString, String subString) {
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1 && mainString.length() > 0 && subString.length() > 0) {
            lastIndex = mainString.indexOf(subString, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += subString.length();
            }
        }
        return count;
    }
}
