package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> users = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Statistics")) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String username = tokens[1];
            switch (command) {
                case "Add":
                    if (users.containsKey(username)) {
                        System.out.println(username + " is already  registered");
                    } else {
                        users.put(username, new ArrayList<>());
                    }
                    break;
                case "Send":
                    String email = tokens[2];
                    ArrayList<String> emails = users.get(username);
                    emails.add(email);
                    break;
                case "Delete":
                    if (users.containsKey(username)) {
                        users.remove(username);
                    } else {
                        System.out.println(username + " not found!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Users count: " + users.size());
        users.entrySet().stream().sorted((u1, u2) -> {
                    int result = u2.getValue().size() - u1.getValue().size();
                    if (result == 0) {
                        result = u1.getKey().compareTo(u2.getKey());
                    }
                    return result;
                })
                .forEach((entry) -> {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(e -> System.out.printf("- %s%n", e));
                });
    }
}
