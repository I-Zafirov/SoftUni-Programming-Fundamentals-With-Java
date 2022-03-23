package T30RegularExpressions.lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L0DemoDate {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\b(?<day>\\d{1,2})([-/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b");
// Pattern pattern = Pattern.compile("\\b(?<day>\\d{1,2})([-/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b",
// Pattern.MULTILINE | Pattern.CASE_INSENSITIVE); -> ^ new line
        String text = "Hey guys, on 22-Jan-2015 I met a 08-Dec-2022   girl in bar. Then 2-Feb/2015 on 2/Fen/2015 we 5-Djv-2022 went on24-Dec-2022 3D a date. She had just turned 23 and I was going to have a birthday in 3-Mar 24\\Dec\\2022";

        Matcher matcher = pattern.matcher(text);

        boolean foundSomething = matcher.find();
//List<String>
        while (foundSomething) {
            System.out.println(matcher.group(0)); //System.out.println(matcher.group("name"));
            System.out.println(matcher.group("day"));
            System.out.println(matcher.group("month"));
            System.out.println(matcher.group("year"));

            foundSomething = matcher.find();
        }
    }
}
