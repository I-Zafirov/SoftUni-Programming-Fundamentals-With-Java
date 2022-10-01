package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars {
    private static final String END = "wife is happy";
    private static final String[] REGEX_ARRAY;
    private static final int[] minutes;

    private static BufferedReader reader;

    static {
        minutes = new int[3];
        reader = new BufferedReader(new InputStreamReader(System.in));
        REGEX_ARRAY = new String[]{
                "<(?<dishes>[0-9a-z]+)>",
                "\\[(?<cleaning>[0-9A-Z]+)\\]",
                "\\{(?<laundry>.+?)\\}",
        };
    }

    public static void main(String[] args) throws IOException {
        runApp();
    }

    private static void runApp() throws IOException {
        String input;
        while (!END.equals(input = reader.readLine())) {

            for (int i = 0; i < REGEX_ARRAY.length; i++) {
                String regex = REGEX_ARRAY[i];
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);
                int sum = 0;
                while (matcher.find()) {
                    sum += getSum(matcher.group());
                }
                minutes[i] += sum;
            }
        }

        int total = Arrays.stream(minutes).sum();

        String result = String.format(
                "Doing the dishes - %d min.\n" +
                        "Cleaning the house - %d min.\n" +
                        "Doing the laundry - %d min.\n" +
                        "Total - %d min.",
                minutes[0], minutes[1], minutes[2], total
        );

        System.out.println(result);

    }

    private static int getSum(String input) {
        return Arrays.stream(input.split(""))
                .filter(s -> s.matches("[0-9]"))
                .map(Integer::parseInt)
                .reduce((a, b) -> a + b)
                .orElse(0);
    }
}
