package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = 0;
        String expression, current = "", peak = "", geoHashCode = "";

        Pattern pattern1 = Pattern.compile("^(?<current>[A-Za-z0-9!@#$?]+)(=(?<number>\\d+))(<<(?<geoHashCode>[\\w\\W\\d]+))$");
        Pattern pattern2 = Pattern.compile("(?<peak>[A-Za-z0-9]+)");

        while (!(expression = scanner.nextLine()).equals("Last note")) {
            Matcher matcher1 = pattern1.matcher(expression);
            while (matcher1.find()) {
                current = matcher1.group("current");
                number = Integer.parseInt(matcher1.group("number"));
                geoHashCode = matcher1.group("geoHashCode");
            }
            if (current == "" && number == 0 && geoHashCode == "") {
                System.out.println("Nothing found!");
                continue;
            }
            if (number != geoHashCode.length()) {
                System.out.println("Nothing found!");
                continue;
            }
            Matcher matcher2 = pattern2.matcher(current);
            while (matcher2.find()) {
                peak = peak + matcher2.group("peak");
            }
            System.out.printf("Coordinates found! %s -> %s%n", peak, geoHashCode);

            current = "";
            number = 0;
            geoHashCode = "";
            peak = "";
        }
    }
}
