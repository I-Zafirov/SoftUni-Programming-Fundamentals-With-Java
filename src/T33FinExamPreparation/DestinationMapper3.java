package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        String regex = "(?<separator>[=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        List<String> destinationList = new ArrayList<>();
        while (matcher.find()) {
            String destinations = matcher.group("destination");
            destinationList.add(destinations);
        }
        System.out.printf("Destinations: %s%n", String.join(", ", destinationList));
        System.out.printf("Travel Points: %d%n", calculateTravelPoints(destinationList));
    }

    private static int calculateTravelPoints(List<String> destinationList) {
        int travelPoints = 0;
        for (String destination : destinationList) {
            travelPoints += destination.length();
        }
        return travelPoints;
    }
}
