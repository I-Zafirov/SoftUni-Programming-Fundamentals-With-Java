package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    private static final String winningSymbols = "@$#^";
    private static char symbol;
    private static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tickets = Arrays.stream(reader.readLine().split("[ ,]"))
                .filter(e -> !e.equals(""))
                .toArray(String[]::new);

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            if (isJackpot(ticket)) {
                System.out.println(String.format("ticket \"%s\" - %d%c Jackpot!", ticket, length, symbol));
            } else if (isWinningTicket(ticket)) {
                System.out.println(String.format("ticket \"%s\" - %d%c", ticket, length, symbol));
            } else {
                System.out.println(String.format("ticket \"%s\" - no match", ticket));
            }

        }

    }

    private static boolean isWinningTicket(String ticket) {
        String left = ticket.substring(0, 10);
        String right = ticket.substring(10);
        for (int i = 0; i < winningSymbols.length(); i++) {
            String regex = String.format("\\%c{6,9}", winningSymbols.charAt(i));
            Pattern pattern = Pattern.compile(regex);
            Matcher leftMatch = pattern.matcher(left);
            Matcher rightMatch = pattern.matcher(right);

            if (leftMatch.find() && rightMatch.find()) {
                length = Math.min(leftMatch.group().length(), rightMatch.group().length());
                symbol = leftMatch.group().charAt(0);
                return true;
            }
        }
        return false;
    }

    private static boolean isJackpot(String ticket) {
        for (int i = 0; i < winningSymbols.length(); i++) {
            String regex = String.format("\\%c{20}", winningSymbols.charAt(i));
            if (ticket.matches(regex)) {
                symbol = winningSymbols.charAt(i);
                length = 10;
                return true;
            }
        }
        return false;
    }
}
