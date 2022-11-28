package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    private static final String REGEX;
    private static Pattern pattern;
    private static BufferedReader reader;

    static {
        REGEX = "([^0-9]{1,20})([0-9]+)";
        pattern = Pattern.compile(REGEX);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input = reader.readLine().toUpperCase();
        Matcher matcher = pattern.matcher(input);
        StringBuilder output = new StringBuilder();
        StringBuilder strings = new StringBuilder();
        while (matcher.find()) {
            int times = Integer.parseInt(matcher.group(2));
            if (times > 0) {
                String string = matcher.group(1);
                output.append(generateFrom(string, times));
                strings.append(string);
            }
        }

        System.out.println(String.format("Unique symbols used: %d", strings.toString().chars().distinct().count()));
        System.out.println(output.toString());
    }

    private static String generateFrom(String input, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(input);
        }
        return builder.toString();
    }
}
