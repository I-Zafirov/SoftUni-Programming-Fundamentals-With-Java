package T33FinExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class UsersCountReachedTheCapacityStatistics2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.next());
        String input = scanner.nextLine();

        Map<String, Integer> sentMessages = new LinkedHashMap<>();
        Map<String, Integer> receivedMessages = new LinkedHashMap<>();

        while (!input.equals("Statistics")) {
            String[] commands = input.split("=");

            String commandParts = commands[0];
            switch (commandParts) {
                case "Add":
                    String user = commands[1];
                    int sent = Integer.parseInt(commands[2]);
                    int received = Integer.parseInt(commands[3]);

                    sentMessages.putIfAbsent(user, sent);
                    receivedMessages.putIfAbsent(user, received);
                    break;
                case "Message":
                    String sender = commands[1];
                    String receiver = commands[2];


                    sentMessages.replace(sender, sentMessages.get(sender) + 1);
                    receivedMessages.replace(receiver, receivedMessages.get(receiver) + 1);

                    if (sentMessages.get(sender) >= capacity || sentMessages.get(sender) + receivedMessages.get(sender) >= capacity) {
                        sentMessages.remove(sender);
                        receivedMessages.remove(sender);

                        System.out.printf("%s reached the capacity!%n", sender);
                    }
                    if (receivedMessages.get(receiver) >= capacity || receivedMessages.get(receiver) + sentMessages.get(receiver) >= capacity) {
                        sentMessages.remove(receiver);
                        receivedMessages.remove(receiver);

                        System.out.printf("%s reached the capacity!%n", receiver);
                    }
                    break;
                case "Empty":
                    if (commands[1].equals("All")) {
                        sentMessages.clear();
                        receivedMessages.clear();
                    } else if (sentMessages.containsKey(commands[1])) {
                        sentMessages.remove(commands[1]);
                        receivedMessages.remove(commands[1]);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Users count: %d%n", sentMessages.size());

        receivedMessages.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int res = Integer.compare(b.getValue(), a.getValue());
                    if (res == 0) {
                        a.getKey().compareTo(b.getKey());
                    }
                    return res;
                })
                .forEach(entry -> {
                    String userName = entry.getKey();
                    int r = entry.getValue();
                    int s = sentMessages.get(userName);

                    System.out.printf("%s - %d%n", userName, r + s);
                });
    }
}
