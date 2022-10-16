package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstAlbum {
    private static BufferedReader reader;
    private static final String NAME_REGEX;
    private static final String LYRICS_REGEX;
    private static final String MIN_REGEX;
    private static final String SEC_REGEX;
    private static Pattern pattern;
    private static int found;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        NAME_REGEX = "\\[(?<name>[\\w][\\w\\s-]+[\\w])]";
        LYRICS_REGEX = "\"(?<lyrics>[\\w\\s]+?)\"";
        MIN_REGEX = "(?<min>[0-9]?[0-9]):(?<sec>[0-9][0-9])m";
        SEC_REGEX = "(?<sec>[0-9]+)s";
        found = 0;
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (!"Rock on!".equals(input = reader.readLine()) && found != 4) {
            String name;
            String lyrics;
            String length;

            pattern = Pattern.compile(NAME_REGEX);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                name = matcher.group("name");
            } else {
                continue;
            }

            pattern = Pattern.compile(LYRICS_REGEX);
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                lyrics = matcher.group("lyrics");
            } else {
                continue;
            }

            pattern = Pattern.compile(MIN_REGEX);
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                long sec = Long.parseLong(matcher.group("sec"));
                long min = Long.parseLong(matcher.group("min"));
                long seconds = sec + (min * 60);
                length = calculateTime(seconds);
            } else {
                pattern = Pattern.compile(SEC_REGEX);
                matcher = pattern.matcher(input);
                if (matcher.find()) {
                    long sec = Long.parseLong(matcher.group("sec"));
                    length = calculateTime(sec);
                } else {
                    continue;
                }
            }


            System.out.println(String.format("%s -> %s => %s", name, length, lyrics));
            found++;
        }

    }

    private static String calculateTime(long seconds) {
        long sec = seconds % 60;
        long minutes = seconds % 3600 / 60;
        DecimalFormat df = new DecimalFormat("00");
        return String.format("%s:%s", df.format(minutes), df.format(sec));
    }
}
