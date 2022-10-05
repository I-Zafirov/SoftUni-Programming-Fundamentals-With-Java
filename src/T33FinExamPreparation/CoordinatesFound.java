package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinatesFound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfRacer = "";
        int lengthOfCode = 0;
        String geoHashCode = "";


        while (true) {
            String line = scanner.nextLine();
            String regex = "^([#$%*&])([A-Za-z]+)\\1=(\\d+)!!(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                nameOfRacer = matcher.group(2);
                lengthOfCode = Integer.parseInt(matcher.group(3));
                geoHashCode = matcher.group(4);
                if (geoHashCode.length() == lengthOfCode) {
                    StringBuilder word = new StringBuilder();
                    word = giveMeEncryptedMessage(geoHashCode);
                    System.out.printf("Coordinates found! %s -> %s%n", nameOfRacer, word);
                    break;
                }
            }
            System.out.println("Nothing found!");
        }
    }

    private static StringBuilder giveMeEncryptedMessage(String geoHashCode) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < geoHashCode.length(); i++) {
            int symbol = (int) geoHashCode.charAt(i) + geoHashCode.length();
            char ch = (char) symbol;
            word.append(ch);
        }
        return word;
    }
}
