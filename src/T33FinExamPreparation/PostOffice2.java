package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pattern lettersPattern = Pattern.compile("([#$%*&])(?<word>[A-Z]+)\\1");


        String[] input = scanner.nextLine().split("\\|");

        Matcher matchLetters = lettersPattern.matcher(input[0]);
        String[] words = input[2].split(" ");

        if (matchLetters.find()) {
            String letters = matchLetters.group().replaceAll("[#$%*&]", "");

            for (int i = 0; i < letters.length(); i++) {
                int asciiCurrentChar = letters.charAt(i);
                Pattern charPositions = Pattern.compile(asciiCurrentChar + ":[0-9][0-9]");
                Matcher matchPositions = charPositions.matcher(input[1]);

                if (matchPositions.find()) {

                    int length = Integer.parseInt(matchPositions.group().split(":")[1]) + 1;
                    for (String word : words) {
                        if (word.charAt(0) == letters.charAt(i) && word.length() == length) {
                            System.out.println(word);
                            break;
                        }
                    }
                }
            }
        }
    }
}
