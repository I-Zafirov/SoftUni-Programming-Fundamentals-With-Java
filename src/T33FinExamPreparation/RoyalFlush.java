package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoyalFlush {
    static Map<Integer, String> orderOfFLushes = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder cards = new StringBuilder("");
        String spadesFlush = "10s[^s]*Js[^s]*Qs[^s]*Ks[^s]*As";

        Pattern spadesFlushPattern = Pattern.compile(spadesFlush);
        Pattern clubsFlushPattern = Pattern.compile(spadesFlush.replaceAll("s", "c"));
        Pattern diamondsFlushPattern = Pattern.compile(spadesFlush.replaceAll("s", "d"));
        Pattern heartsFlushPattern = Pattern.compile(spadesFlush.replaceAll("s", "h"));

        for (int i = 0; i < n; i++) {
            cards.append(sc.nextLine());
        }

        findFlushes("Spades", spadesFlushPattern, cards);
        findFlushes("Clubs", clubsFlushPattern, cards);
        findFlushes("Diamonds", diamondsFlushPattern, cards);
        findFlushes("Hearts", heartsFlushPattern, cards);

        for (String flushType : orderOfFLushes.values()) {
            System.out.printf("Royal Flush Found - %s%n", flushType);
        }
        System.out.printf("Royal's Royal Flushes - %d.%n", orderOfFLushes.size());
    }

    private static void findFlushes(String type, Pattern typePattern, StringBuilder cards) {
        Matcher matcher = typePattern.matcher(cards);
        int index = 0;
        while (matcher.find()) {
            String foundFlush = matcher.group();
            index += cards.substring(index).indexOf(foundFlush) + foundFlush.length();
            orderOfFLushes.put(index, type);
        }
    }
}
