package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regexValidEmoji = "([:]{2}|[*]{2})(?<validEmoji>[A-Z][a-z]{2,})\\1";
        String regexDigit = "\\d";
        String input = scanner.nextLine();

        Pattern patternEmoji = Pattern.compile(regexValidEmoji);
        Matcher matcherEmoji = patternEmoji.matcher(input);
        Pattern patternDigit = Pattern.compile(regexDigit);
        Matcher matcherDigit = patternDigit.matcher(input);

        List<String> listCoolEmojis = new ArrayList<>();
        int multiplyingDigits = 1;
        while (matcherDigit.find()) {
            multiplyingDigits *= Integer.parseInt(matcherDigit.group());
        }
        int countValidEmoji = 0;
        while (matcherEmoji.find()) {
            String currentString = matcherEmoji.group("validEmoji");
            int sumChars = 0;
            for (int i = 0; i < currentString.length(); i++) {
                sumChars += currentString.charAt(i);
            }
            if (sumChars > multiplyingDigits) {
                listCoolEmojis.add(matcherEmoji.group());
                countValidEmoji++;
            } else {
                countValidEmoji++;
            }
        }
        System.out.printf("Cool threshold: %d\n", multiplyingDigits);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", countValidEmoji);
        listCoolEmojis.forEach(e -> System.out.println(e));
    }
}
