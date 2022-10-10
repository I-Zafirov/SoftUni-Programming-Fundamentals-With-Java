package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String emojiRegex = "(?<separator>\\*{2}|:{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        String coolThresholdRegex = "([0-9])";

        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Pattern coolThresholdPattern = Pattern.compile(coolThresholdRegex);
        Matcher emojiMatcher = emojiPattern.matcher(input);
        Matcher thresholdMatcher = coolThresholdPattern.matcher(input);

        long coolThresholdSum = 1;
        List<String> emojis = new ArrayList<>();
        List<String> coolEmojis = new ArrayList<>();
        List<String> textPartOfEmojis = new ArrayList<>();

        while (thresholdMatcher.find()) {
            coolThresholdSum *= Integer.parseInt(thresholdMatcher.group());
        }
        while (emojiMatcher.find()) {
            emojis.add(emojiMatcher.group());
            String separator = emojiMatcher.group("separator");
            String textPartOfEmoji = emojiMatcher.group("emoji");
            String fullEmoji = separator + textPartOfEmoji + separator;
            if (isEmojiCool(textPartOfEmoji, coolThresholdSum)) {
                coolEmojis.add(fullEmoji);
            }
        }
        System.out.printf("Cool threshold: %d%n", coolThresholdSum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojis.size());
        coolEmojis.forEach(coolEmoji -> System.out.println(coolEmoji));
    }

    private static boolean isEmojiCool(String textPartOfEmoji, long coolThresholdSum) {
        boolean isCool = false;
        int emojiCoolness = 0;
        for (int i = 0; i < textPartOfEmoji.length(); i++) {
            char currentChar = textPartOfEmoji.charAt(i);
            emojiCoolness += currentChar;
        }
        return emojiCoolness >= coolThresholdSum;
    }
}
