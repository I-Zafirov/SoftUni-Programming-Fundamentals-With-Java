package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(?<separator>=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> listDestinations = new ArrayList<>();

        while (matcher.find()) {
            listDestinations.add(matcher.group("destination"));
        }
        int points = 0;
        for (var e : listDestinations) {
            points += e.length();
        }
        System.out.printf("Destinations: %s\n", String.join(", ", listDestinations));
        System.out.printf("Travel Points: %d", points);
    }
}
