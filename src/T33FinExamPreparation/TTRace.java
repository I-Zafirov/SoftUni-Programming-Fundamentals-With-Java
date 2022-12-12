package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TTRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String coordinates = null;
        while (coordinates == null) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("^([#$%*&])(?<name>[A-Za-z]+)\\1=(?<length>\\d+)!!(?<geohashcode>.+)$");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("length"));
                String geohashcodeEncrypted = matcher.group("geohashcode");

                if (length == geohashcodeEncrypted.length()) {
                    coordinates = name + " -> " + encrypt(geohashcodeEncrypted, length);
                    break;
                }
            }
            System.out.println("Nothing found!");
        }
        System.out.println("Coordinates found! " + coordinates);
    }

    private static String encrypt(String s, int encryptionKey) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char encryptedCh = (char) (ch + encryptionKey);
            encrypted.append(encryptedCh);
        }
        return encrypted.toString();
    }
}
