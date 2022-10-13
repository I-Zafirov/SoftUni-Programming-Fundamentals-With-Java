package T33FinExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojisFoundInTheText {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> coolEmojis = new LinkedHashMap<>();

        String string = scan.nextLine();
        String regex = "(?<emoji>(::|\\*\\*)[A-Z][a-z][a-z]+(\\2))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        String regexForDigits = "([0-9])";
        Pattern patternDigits = Pattern.compile(regexForDigits);

        Long coolThreshold = 1l;

        Matcher matcherDigits = patternDigits.matcher(string);

        while (matcherDigits.find()) {
            int number = Integer.parseInt(matcherDigits.group(1));
            coolThreshold *= number;
        }
        int countOfEmojis = 0;
        while (matcher.find()) {
            countOfEmojis++;
            int coolness = 0;
            String emoticon = matcher.group("emoji");
            for (int i = 2; i < emoticon.length() - 2; i++) {
                coolness += emoticon.charAt(i);
            }
            if (coolness >= coolThreshold) {
                coolEmojis.put(emoticon, coolness);
            }
        }

        System.out.println(String.format("Cool threshold: %d", coolThreshold));
        System.out.println(String.format("%d emojis found in the text. The cool ones are:", countOfEmojis));
        coolEmojis
                .entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey()));


    }
}
