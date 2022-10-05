package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicMessages {
    private static Pattern pattern;
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String encryption;
        while (!"Over!".equals(encryption = reader.readLine())) {
            int length = Integer.parseInt(reader.readLine());
            String regex = String.format("^[0-9]+(?<message>[A-Za-z]{%d})[^A-Za-z]*$", length);
            pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(encryption);

            if (matcher.find()) {
                String message = matcher.group("message");
                int[] indexes = Arrays.stream(encryption.replaceAll("[^0-9]+", "").split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                String output = getStringBuilder(message, indexes);
                System.out.println(String.format("%s == %s", message, output));
            }
        }

    }

    private static String getStringBuilder(String message, int[] indexes) {
        StringBuilder output = new StringBuilder();
        for (int index : indexes) {
            if (inRange(index, message.length())) {
                output.append(message.charAt(index));
            } else {
                output.append(" ");
            }
        }
        return output.toString();
    }

    private static boolean inRange(int index, int length) {
        return index >= 0 && index < length;
    }
}
