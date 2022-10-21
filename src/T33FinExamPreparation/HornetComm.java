package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetComm {
    private static final String PM_REGEX;
    private static final String BC_REGEX;
    private static Pattern pmPattern;
    private static Pattern bcPattern;
    private static BufferedReader reader;
    private static List<String> broadcasts;
    private static List<String> messages;

    static {
        PM_REGEX = "^(?<recipient>[0-9]+) <-> (?<message>[0-9A-Za-z]+)$";
        BC_REGEX = "^(?<message>[^0-9]+) <-> (?<frequency>[0-9A-Za-z]+)$";
        pmPattern = Pattern.compile(PM_REGEX);
        bcPattern = Pattern.compile(BC_REGEX);
        reader = new BufferedReader(new InputStreamReader(System.in));
        broadcasts = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (!"Hornet is Green".equals(input = reader.readLine())) {
            Matcher pmMatcher = pmPattern.matcher(input);
            Matcher bcMatcher = bcPattern.matcher(input);

            if (pmMatcher.find()) {
                processPersonalMessage(pmMatcher);
            } else if (bcMatcher.find()) {
                processBroadcastMessage(bcMatcher);
            }
        }

        System.out.println("Broadcasts:");
        if (broadcasts.isEmpty()) {
            System.out.println("None");
        } else {
            broadcasts.forEach(System.out::println);
        }
        System.out.println("Messages:");
        if (messages.isEmpty()) {
            System.out.println("None");
        } else {
            messages.forEach(System.out::println);
        }

    }

    private static void processBroadcastMessage(Matcher bcMatcher) {
        String message = bcMatcher.group("message");
        String frequency = mapFrequency(bcMatcher.group("frequency"));
        broadcasts.add(String.format("%s -> %s", frequency, message));
    }

    private static String mapFrequency(String frequency) {
        StringBuilder mapped = new StringBuilder();
        for (int i = 0; i < frequency.length(); i++) {
            char ch = frequency.charAt(i);
            if (Character.isUpperCase(ch)) {
                mapped.append(String.valueOf(ch).toLowerCase());
            } else if (Character.isLowerCase(ch)) {
                mapped.append(String.valueOf(ch).toUpperCase());
            } else {
                mapped.append(ch);
            }
        }
        return mapped.toString();
    }

    private static void processPersonalMessage(Matcher pmMatcher) {
        String recipient = new StringBuilder(pmMatcher.group("recipient")).reverse().toString();
        String message = pmMatcher.group("message");
        messages.add(String.format("%s -> %s", recipient, message));
    }
}
