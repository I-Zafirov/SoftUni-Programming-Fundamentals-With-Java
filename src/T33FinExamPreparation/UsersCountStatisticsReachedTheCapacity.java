package T33FinExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class UsersCountStatisticsReachedTheCapacity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        Map<String, Integer> usersSentMessages = new LinkedHashMap<>();
        Map<String, Integer> usersReceivedMessages = new LinkedHashMap<>();
        while (!input.equals("Statistics")) {
            String[] tokens = input.split("=");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String username = tokens[1];
                    int sent = Integer.parseInt(tokens[2]);
                    int received = Integer.parseInt(tokens[3]);
                    if (!usersSentMessages.containsKey(username)) {
                        usersSentMessages.put(username, sent);
                        usersReceivedMessages.put(username, received);
                    }
                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];
                    if (usersSentMessages.containsKey(sender) && usersSentMessages.containsKey(receiver)) {
                        usersSentMessages.put(sender, usersSentMessages.get(sender) + 1);
                        usersReceivedMessages.put(receiver, usersReceivedMessages.get(receiver) + 1);
                    }
                    //check sender
                    if (usersSentMessages.get(sender) + usersReceivedMessages.get(sender) >= capacity) {
                        System.out.printf("%s reached the capacity!%n", sender);
                        usersSentMessages.remove(sender);
                        usersReceivedMessages.remove(sender);
                    }
                    //check receiver
                    if (usersSentMessages.containsKey(receiver) &&
                            usersSentMessages.get(receiver) + usersReceivedMessages.get(receiver) >= capacity) {
                        System.out.printf("%s reached the capacity!%n", receiver);
                        usersSentMessages.remove(receiver);
                        usersReceivedMessages.remove(receiver);
                    }
                    break;
                case "Empty":
                    String usernameToRemove = tokens[1];
                    if (usernameToRemove.equals("All")) {
                        usersSentMessages.clear();
                        usersReceivedMessages.clear();
                        input = scanner.nextLine();
                        continue;
                    }
                    if (usersSentMessages.containsKey(usernameToRemove)) {
                        usersSentMessages.remove(usernameToRemove);
                        usersReceivedMessages.remove(usernameToRemove);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Users count: " + usersSentMessages.size());
        usersReceivedMessages.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.printf("%s - %d%n",
                        entry.getKey(), entry.getValue() + usersSentMessages.get(entry.getKey())));
    }
}
