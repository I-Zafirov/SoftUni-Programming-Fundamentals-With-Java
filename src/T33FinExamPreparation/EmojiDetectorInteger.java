package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetectorInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern digitPattern = Pattern.compile("\\d");
        Matcher matcher = digitPattern.matcher(text);
        int coolThresholdSum = 1;
        while (matcher.find()) {
            int digit = Integer.parseInt(matcher.group(0));
            coolThresholdSum *= digit;
        }

        List<String> coolEmojis = new ArrayList<>();
        int countOfAllEmojis = 0;
        Pattern emojiPattern = Pattern.compile("([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        matcher = emojiPattern.matcher(text);
        while (matcher.find()) {
            StringBuilder emoji = new StringBuilder(matcher.group("emoji"));
            countOfAllEmojis++;
            int emojiCoolness = 0;
            for (int i = 0; i < emoji.length(); i++) {
                int number = emoji.charAt(i);
                emojiCoolness += number;
            }
            if (emojiCoolness >= coolThresholdSum) {
                coolEmojis.add(matcher.group(0));
            }
        }
        System.out.printf("Cool threshold: %d%n", coolThresholdSum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countOfAllEmojis);
        for (String coolEmoji : coolEmojis) {
            System.out.println(coolEmoji);
        }
    }
}
