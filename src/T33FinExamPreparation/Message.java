package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("([*|@])(?<tag>[A-Z][a-z]{2,})\\1: (?<letters>(\\[[A-Za-z]+\\]\\|){3})$");
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                String letters = matcher.group("letters");
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < letters.length(); j++) {
                    if (Character.isLetter(letters.charAt(j))) {
                        int num = letters.charAt(j);
                        sb.append(num + " ");
                    }
                }

                System.out.printf("%s: %s%n", tag, sb);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
