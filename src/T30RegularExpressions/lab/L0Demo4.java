package T30RegularExpressions.lab;

public class L0Demo4 {
    public static void main(String[] args) {
        String text = "Hey guys, on 22-Jan-2015 I met a 08-Dec-2022   girl in bar. Then 2-Feb/2015 on 2/Fen/2015 we 5-Djv-2022 went on24-Dec-2022 3D a date. She had just turned 23 and I was going to have a birthday in 3-Mar 24\\Dec\\2022";

        String censored = text.replaceAll("\\b(?<day>\\d{1,2})([-/\\\\])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b", "***");
// String censored = text.replaceFirst("\\b(?<day>\\d{1,2})([-/\\\\])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b", "***");
        System.out.println(censored);
    }
}

