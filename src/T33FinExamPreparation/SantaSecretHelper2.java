package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        List<String> goodChildren = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            StringBuilder decryptedMessageSB = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                char encryptedSymbol = (char) (symbol - key);
                decryptedMessageSB.append(encryptedSymbol);
            }
            String decryptedMessage = decryptedMessageSB.toString();
            String regex = "@(?<name>[A-Za-z]+)[^@!:>-]*!(?<behavior>[GN])!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);
            while (matcher.find()) {
                if (matcher.group("behavior").equals("G")) {
                    goodChildren.add(matcher.group("name"));
                }
            }
            input = scanner.nextLine();
        }
        goodChildren.forEach(child -> System.out.println(child));
    }
}
