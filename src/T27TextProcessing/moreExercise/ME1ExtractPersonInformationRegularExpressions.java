package T27TextProcessing.moreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME1ExtractPersonInformationRegularExpressions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Pattern namePattern = Pattern.compile("[@](?<name>[A-Za-z]+)[|]");
        Pattern agePattern = Pattern.compile("[#](?<age>\\d+)[*]");

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher nameMatcher = namePattern.matcher(text);
            Matcher ageMatcher = agePattern.matcher(text);
            while (nameMatcher.find() && ageMatcher.find()) {
                System.out.printf("%s is %s years old.%n",
                        nameMatcher.group("name"),
                        ageMatcher.group("age"));
            }
        }
    }
}
