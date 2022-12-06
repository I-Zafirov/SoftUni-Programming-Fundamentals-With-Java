package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StarEnigma {
    private static BufferedReader reader;
    private static final String REGEX;
    private static Pattern pattern;
    private static List<String> attacked;
    private static List<String> destroyed;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        REGEX = "^[^-@!:>\\n]*@(?<planet>[A-Za-z]+)[^-@!:>\\n]*:(?<population>[0-9]+)[^-@!:>\\n]*!(?<type>A|D)![^-@!:>\\n]*->(?<soldiersCount>[0-9]+)[^-@!:>\\n]*$";
        pattern = Pattern.compile(REGEX);
        attacked = new ArrayList<>();
        destroyed = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String encryptedMessage = reader.readLine();
            encryptedMessage = mapMessage(encryptedMessage);
            processPlanets(encryptedMessage);
        }

        System.out.println(String.format("Attacked planets: %d", attacked.size()));
        if (attacked.size() > 0) {
            attacked.stream()
                    .sorted()
                    .forEach(p -> System.out.println(String.format("-> %s", p)));
        }
        System.out.println(String.format("Destroyed planets: %d", destroyed.size()));
        if (destroyed.size() > 0) {
            destroyed.stream()
                    .sorted()
                    .forEach(p -> System.out.println(String.format("-> %s", p)));
        }


    }

    private static void processPlanets(String encryptedMessage) {
        Matcher matcher = pattern.matcher(encryptedMessage);

        if (matcher.find()) {
            String type = matcher.group("type");
            switch (type) {
                case "A":
                    attacked.add(matcher.group("planet"));
                    break;
                case "D":
                    destroyed.add(matcher.group("planet"));
                    break;
            }
        }
    }

    private static String mapMessage(String encryptedMessage) {
        int count = (int) encryptedMessage
                .toLowerCase()
                .chars()
                .filter(e -> e == 's' || e == 't' || e == 'a' || e == 'r')
                .count();

        return encryptedMessage.chars()
                .map(ch -> ch - count)
                .mapToObj(i -> String.format("%c", i))
                .collect(Collectors.joining(""));
    }
}
