package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinatesFoundNothingFound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String regex = "(?<n>((#[A-Za-z]+#)|(\\$[A-Za-z]+\\$)|(%[A-Za-z]+%)|(\\*[A-Za-z]+\\*)|(&[A-Za-z]+&)))=" +
                    "(?<num>([0-9]+))!!(?<geo>(.{1,}))";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int length = Integer.parseInt(matcher.group("num"));
                String geoHashCode = matcher.group("geo");
                String name = matcher.group("n");
                name = name.substring(1, name.length() - 1);
                if (length == geoHashCode.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < geoHashCode.length(); i++) {
                        int symbol = geoHashCode.charAt(i);
                        sb.append((char) (symbol + length));
                    }
                    System.out.println(String.format("Coordinates found! %s -> %s", name, sb));
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }
        }
    }
}
