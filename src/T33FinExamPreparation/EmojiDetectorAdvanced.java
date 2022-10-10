package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EmojiDetectorAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        long coolEmojisThreshold = input.chars()
                .filter(Character::isDigit)
                .mapToObj(Character::getNumericValue)
                .map(Long::valueOf)
                .reduce((a, b) -> a * b)
                .orElse(0L);

        Matcher emojiMatcher = Pattern
                .compile("(?<emoji>(?<symbols>[:]{2}|[*]{2})(?<name>[A-Z][a-z]{2,})\\k<symbols>)")
                .matcher(input);

        int emojisFound = 0;
        List<String> coolEmojis = new ArrayList<>();

        while (emojiMatcher.find()) {
            emojisFound++;
            emojiMatcher.group("name").chars()
                    .mapToObj(Long::valueOf)
                    .reduce(Long::sum)
                    .filter(current -> current.compareTo(coolEmojisThreshold) >= 0)
                    .ifPresent(sum -> coolEmojis.add(emojiMatcher.group("emoji")));
        }

        System.out.printf(
                "Cool threshold: %d%n%d emojis found in the text. The cool ones are:%n%s%n",
                coolEmojisThreshold,
                emojisFound,
                coolEmojis.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
