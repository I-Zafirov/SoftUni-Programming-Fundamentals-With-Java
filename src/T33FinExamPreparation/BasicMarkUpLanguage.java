package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicMarkUpLanguage {
    private static int count = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while (!line.equals("<stop/>")) {
            String[] command = line.split("\\s+");
            if (command[0].equals("<inverse") || command[1].equals("inverse")) {
                inverse(line);
            } else if (command[0].equals("<reverse") || command[1].equals("reverse")) {
                reverse(line);
            } else if (command[0].equals("<repeat") || command[1].equals("repeat")) {
                repeat(line);
            }

            line = scanner.nextLine();
        }
    }

    private static void repeat(String line) {
        // String repeatPattern = "(repeat)\\s+(value=)\"(\\d)\"\\s+(content)=\"(\\w+)\"";
        String repeatPattern = "\\<\\s*([\\w]+)\\s+value\\s*\\=\\s*\"([0-9]+)\"\\s*content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\s*\\>";
        Pattern pattern = Pattern.compile(repeatPattern);
        Matcher repeatMatcher = pattern.matcher(line);
        int numOfRepeats = 0;
        String content = "";
        while (repeatMatcher.find()) {
            numOfRepeats = Integer.parseInt(repeatMatcher.group(2));
            content = repeatMatcher.group(3);
        }

        for (int i = 0; i < numOfRepeats; i++) {
            System.out.println(count + ". " + content);
            count++;
        }
    }

    private static void reverse(String line) {
        //String reversePattern = "(reverse)\\s+(content)=\"(\\w+)\"";
        String reversePattern = "\\<\\s*([\\w]+)\\s+content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\>";
        Pattern pattern = Pattern.compile(reversePattern);
        Matcher repeatMatcher = pattern.matcher(line);
        String content = "";
        while (repeatMatcher.find()) {
            content = repeatMatcher.group(2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(content);
        sb.reverse();
        System.out.println(count + ". " + sb.toString());
        count++;
    }

    private static void inverse(String line) {
        String inversePattern = "\\<\\s*([\\w]+)\\s+content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\>";
        Pattern pattern = Pattern.compile(inversePattern);
        Matcher repeatMatcher = pattern.matcher(line);
        String content = "";
        while (repeatMatcher.find()) {
            content = repeatMatcher.group(2);
        }

        String result = "";

        for (int i = 0; i < content.length(); i++) {
            int charValue = (int) content.charAt(i);
            if (charValue >= 65 && charValue <= 90) {
                charValue += 32;
            } else if (charValue >= 97 && charValue <= 122) {
                charValue -= 32;
            }

            result += (char) charValue;
        }

        System.out.println(count + ". " + result);
        count++;
    }
}
