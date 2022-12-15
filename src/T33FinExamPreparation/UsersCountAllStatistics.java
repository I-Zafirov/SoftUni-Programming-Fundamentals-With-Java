package T33FinExamPreparation;

import java.util.*;

public class UsersCountAllStatistics {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> users = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Statistics")) {
            String[] elements = input.split("=");
            String cmd = elements[0];
            switch (cmd) {
                case "Add":
                    String username = elements[1];
                    int sent = Integer.parseInt(elements[2]);
                    int received = Integer.parseInt(elements[3]);
                    if (!users.containsKey(username)) {
                        users.put(username, new ArrayList<>());
                        users.get(username).add(0, sent);
                        users.get(username).add(1, received);
                    }
                    break;
                case "Message":
                    String sender = elements[1];
                    String receiver = elements[2];
                    if (users.containsKey(sender) && users.containsKey(receiver)) {
                        int senderSent = users.get(sender).get(0);
                        int senderReceived = users.get(sender).get(1);
                        int receiverSent = users.get(receiver).get(0);
                        int receiverReceived = users.get(receiver).get(1);
                        senderSent += 1;
                        receiverReceived += 1;
                        if (senderSent + senderReceived < capacity) {
                            users.get(sender).set(0, senderSent);
                        } else {
                            users.remove(sender);
                            System.out.printf("%s reached the capacity!%n", sender);
                        }
                        if (receiverSent + receiverReceived < capacity) {
                            users.get(receiver).set(1, receiverReceived);
                        } else {
                            users.remove(receiver);
                            System.out.printf("%s reached the capacity!%n", receiver);
                        }
                    }
                    break;
                case "Empty":
                    String username1 = elements[1];
                    if (!"All".equals(username1)) {
                        users.remove(username1);
                    } else {
                        users.clear();
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Users count: %d%n", users.size());
        users.entrySet().stream()
                .sorted((h1, h2) -> h2.getValue().get(1) - h1.getValue().get(1))
                .forEach(u -> System.out.printf("%s - %d%n", u.getKey(), u.getValue().get(0) + u.getValue().get(1)));
    }
}
