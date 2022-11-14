package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([@]|[#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> listStrings = new ArrayList<>();
        boolean isMatch = false;
        boolean isMirror = false;
        int counter = 0;
        while (matcher.find()) {
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            String reversedSecondWord = "";
            for (int i = secondWord.length() - 1; i >= 0; i--) {
                reversedSecondWord += secondWord.charAt(i);
            }
            if (firstWord.equals(reversedSecondWord)) {
                String newString = matcher.group("firstWord") + " <=> "
                        + matcher.group("secondWord");
                listStrings.add(newString);
                isMirror = true;
                counter++;
            } else {
                isMatch = true;
                counter++;
            }
        }
        if (isMirror) {
            System.out.printf("%d word pairs found!\n", counter);
            System.out.println("The mirror words are:");
            String list = listStrings.toString().replace("[", "")
                    .replace("]", "");
            System.out.print(list);
        } else if (isMatch) {
            System.out.printf("%d word pairs found!\n", counter);
            System.out.println("No mirror words!");
        } else {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        }
    }
}
