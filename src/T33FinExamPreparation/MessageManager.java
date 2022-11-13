package T33FinExamPreparation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MessageManager {
    static Map<String, Integer> personSend = new HashMap<>();
    static Map<String, Integer> personReceived = new HashMap<>();

    public static void Dmain(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String input;
        while (!"Statistics".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("=");
            switch (tokens[0]) {
                case "Add":
                    add(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    break;
                case "Message":
                    message(tokens[1], tokens[2], capacity);
                    break;
                case "Empty":
                    empty(tokens[1]);
                    break;
            }
        }
        List<String> names = personReceived.entrySet().stream()
                .sorted((entryA, entryB) -> {
                    int receivedA = entryA.getValue();
                    String nameA = entryA.getKey();
                    int receivedB = entryB.getValue();
                    String nameB = entryB.getKey();

                    if (receivedA != receivedB) {
                        return Integer.compare(receivedB, receivedA);
                    } else {
                        return nameA.compareTo(nameB);
                    }
                })
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.printf("Users count: %d\n", names.size());
        for (String name : names) {
            System.out.printf("%s - %d\n", name, personSend.get(name) + personReceived.get(name));
        }
    }

    private static void empty(String id) {
        if (!"All".equals(id)) {
            if (personSend.containsKey(id)) {
                personSend.remove(id);
                personReceived.remove(id);
            }
        } else {
            personReceived.clear();
            personSend.clear();
        }
    }

    private static void message(String sender, String receiver, int capacity) {
        if (personSend.containsKey(sender) && personSend.containsKey(receiver)) {
            personSend.put(sender, personSend.get(sender) + 1);
            int sendersMsgs = personSend.get(sender) + personReceived.get(sender);
            if (sendersMsgs >= capacity) {
                personSend.remove(sender);
                personReceived.remove(sender);
                System.out.printf("%s reached the capacity!\n", sender);
            }
            personReceived.put(receiver, personReceived.get(receiver) + 1);
            int receiverMsgs = personSend.get(receiver) + personReceived.get(receiver);
            if (receiverMsgs >= capacity) {
                personReceived.remove(receiver);
                personSend.remove(receiver);
                System.out.printf("%s reached the capacity!\n", receiver);
            }
        }
    }

    private static void add(String id, int sent, int received) {
        if (!personSend.containsKey(id)) {
            personSend.put(id, sent);
            personReceived.put(id, received);
        }
    }
}
