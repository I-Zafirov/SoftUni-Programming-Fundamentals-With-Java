package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String placesString = scanner.nextLine();
//        String expression = "([=/])[A-Z][A-Za-z]{2,}\\1";
//        Pattern placesPattern = Pattern.compile(expression); // state machine
        Pattern pattern = Pattern.compile("([=/])(?<places>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(placesString);

        List<String> locations = new ArrayList<>();
        while (matcher.find()) {
            //locations.add(matcher.group(2));
            locations.add(matcher.group("places"));
        }
        System.out.println("Destinations: " + String.join(", ", locations));
        System.out.println("Travel Points: " + locations.stream().mapToInt(l -> l.length()).sum());
        //System.out.println("Travel Points: " + locations.stream().mapToInt(String::length).sum());
    }
}

