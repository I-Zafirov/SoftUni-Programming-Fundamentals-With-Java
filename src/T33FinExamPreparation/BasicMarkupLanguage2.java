package T33FinExamPreparation;

import java.util.Scanner;

public class BasicMarkupLanguage2 {
    private static String inverse(String line) {
        int startOfInput = line.indexOf("\"") + 1;
        int endOfInput = line.lastIndexOf("\"");
        String output = "";
        for (char c : line.substring(startOfInput, endOfInput).toCharArray()) {
            if (Character.isUpperCase(c)) {
                output += Character.toString(c).toLowerCase();
            } else if (Character.isLowerCase(c)) {
                output += Character.toString(c).toUpperCase();
            } else {
                output += Character.toString(c);
            }
        }
        return output;
    }

    private static String reverse(String line) {
        int startOfInput = line.indexOf("\"") + 1;
        int endOfInput = line.lastIndexOf("\"");
        return new StringBuilder(line.substring(startOfInput, endOfInput)).reverse().toString();
    }

    private static int repeat(String line, int count) {
        int startOfRepeat = line.indexOf("\"") + 1;
        int endOfRepeat = line.substring(startOfRepeat, line.length()).indexOf("\"") + startOfRepeat;
        int startOfInput = line.substring(endOfRepeat + 1, line.length()).indexOf("\"") + 2 + endOfRepeat;
        int endOfInput = line.lastIndexOf("\"");

        int repeat = Integer.parseInt(line.substring(startOfRepeat, endOfRepeat));
        String output = line.substring(startOfInput, endOfInput);

        if (output.equals("")) {
            return count;
        }

        for (int i = count; i < repeat + count; i++) {
            System.out.println(i + ". " + output);
        }
        return count + repeat - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        int count = 1;
        do {
            line = sc.nextLine();
            if (line.replaceAll(" ", "").contains("inverse")) {
                String output = inverse(line);
                if (!output.equals("")) {
                    System.out.println(count + ". " + output);
                } else {
                    count--;
                }
            } else if (line.replaceAll(" ", "").contains("reverse")) {
                String output = reverse(line);
                if (!output.equals("")) {
                    System.out.println(count + ". " + output);
                } else {
                    count--;
                }
            } else if (line.replaceAll(" ", "").contains("repeat")) {
                count = repeat(line, count);
            }
            count++;
        } while (!line.replaceAll(" ", "").contains("stop"));

    }
}
