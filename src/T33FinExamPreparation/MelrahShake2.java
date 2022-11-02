package T33FinExamPreparation;

import java.util.Scanner;

public class MelrahShake2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder line = new StringBuilder(sc.nextLine());
        StringBuilder pattern = new StringBuilder(sc.nextLine());

        boolean shaked = true;

        while (shaked && pattern.length() != 0) {
            int firstIndex = line.indexOf(pattern.toString());
            shaked = false;
            if (firstIndex != -1) {
                int lastIndex = line.substring(firstIndex + pattern.length()).lastIndexOf(pattern.toString()) + firstIndex + pattern.length();
                if (lastIndex != -1) {
                    line.replace(lastIndex, lastIndex + pattern.length(), "");
                    line.replace(firstIndex, firstIndex + pattern.length(), "");
                    shaked = true;
                    System.out.println("Shaked it.");

                    if (pattern.length() > 1) {
                        pattern = pattern.replace(pattern.length() / 2, pattern.length() / 2 + 1, "");
                    } else {
                        pattern = new StringBuilder("");
                    }
                }
            }
        }
        System.out.println("No shake.");
        System.out.println(line);
    }
}
