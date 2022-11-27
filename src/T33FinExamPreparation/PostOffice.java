package T33FinExamPreparation;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] encryptedMessage = scanner.nextLine().split("\\|");

        String firstEncryptedMessage = encryptedMessage[0];
        String secondEncryptedMessage = encryptedMessage[1];
        String thirdEncryptedMessage = encryptedMessage[2];

        String firstRegex = "(?<left>[#$%*&])(?<letters>[A-Z]+)\\1";
        Pattern firstPattern = Pattern.compile(firstRegex);
        Matcher firstMatch = firstPattern.matcher(firstEncryptedMessage);

        String secondRegex = "(?<asciiCode>\\d{2}):(?<length>\\d{2})";
        Pattern secondPattern = Pattern.compile(secondRegex);
        Matcher secondMatch = secondPattern.matcher(secondEncryptedMessage);

        String letters = "";
        while (firstMatch.find()) {
            letters += firstMatch.group("letters");
        }

        LinkedHashMap<String, Integer> matches = new LinkedHashMap<>();

        for (int i = 0; i < letters.length(); i++) {
            matches.put(String.valueOf(letters.charAt(i)), 0);

        }

        if (!letters.equals("")) {
            while (secondMatch.find()) {
                String asciiCodeSymbol = String.valueOf
                        (Character.toChars(
                                Integer.parseInt(secondMatch.group("asciiCode"))));

                int length = Integer.parseInt(secondMatch.group("length"));

                if (matches.containsKey(asciiCodeSymbol)) {
                    matches.put(asciiCodeSymbol, length);
                }
            }


            matches.forEach((ascii, length) -> {
                Arrays.stream(thirdEncryptedMessage.split("\\s+"))
                        .forEach(word -> {
                            if (word.length() == length + 1 &&
                                    String.valueOf(word.charAt(0)).equals(ascii)) {
                                System.out.println(word);
                            }

                        });
            });
        }

    }
}
