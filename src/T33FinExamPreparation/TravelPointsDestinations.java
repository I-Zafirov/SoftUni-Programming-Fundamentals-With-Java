package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TravelPointsDestinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(=|\\/)(?<place>[A-Z][A-Za-z]{2,})\\1";
        List<String> place = new ArrayList<>();
        int sum = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String currentPlace = matcher.group("place");
            place.add(currentPlace);
        }
        for (String s : place) {
            sum += s.length();
        }
        System.out.print("Destinations: ");
        for (int i = 0; i < place.size(); i++) {
            String currentPlace = place.get(i);
            if ((i) == (place.size() - 1)) {
                System.out.print(currentPlace);
            } else {
                System.out.print(currentPlace + ", ");
            }
        }
        System.out.println();
        System.out.printf("Travel Points: %d", sum);
    }
}
