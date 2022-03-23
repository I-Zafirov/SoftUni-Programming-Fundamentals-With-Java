package T30RegularExpressions.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L2MatchPhoneNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\+359([- ])2(\\1)[\\d]{3}(\\1)\\d{4}\\b";
        String phones = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher phoneMatcher = pattern.matcher(phones);

        List<String> matchedPhones = new ArrayList<>();
        while (phoneMatcher.find()) {
            matchedPhones.add(phoneMatcher.group());
        }
        System.out.print(String.join(", ", matchedPhones));
    }
}
