package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int messages = Integer.parseInt(scanner.nextLine());
        Pattern regex = Pattern.compile("!(?<command>[A-Z]{1}[a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]");
        for (int i = 0; i < messages; i++) {
            String input = scanner.nextLine();
            Matcher match = regex.matcher(input);
            if (match.find()) {
                System.out.print(match.group("command") + ": ");
                String msg = match.group("message");
                List<String> encrypt = getAscii(msg);
                System.out.println(String.join(" ", encrypt));
            } else {
                System.out.println("The message is invalid");
            }
        }
    }

    private static List<String> getAscii(String msg) {
        List<String> crack = new ArrayList<>();
        for (int i = 0; i < msg.length(); i++) {
            int ascii = msg.charAt(i);
            String strings = String.valueOf(ascii);
            crack.add(strings);
        }
        return crack;
    }
}
