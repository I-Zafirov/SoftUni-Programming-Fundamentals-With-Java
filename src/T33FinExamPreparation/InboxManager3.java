package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class InboxManager3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<String>> usersAndEmail = new TreeMap<>();
        String input = scanner.nextLine();
        int countUsers = 0;
        while (!input.equals("Statistics")) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            switch (command) {
                case "Add": {
                    String username = tokens[1];
                    if (usersAndEmail.containsKey(username)) {
                        System.out.printf("%s is already registered%n", username);
                    } else {
                        usersAndEmail.put(username, new ArrayList<>());
                        countUsers++;
                    }
                }
                break;
                case "Send": {
                    String username = tokens[1];
                    String email = tokens[2];
                    if (usersAndEmail.containsKey(username)) {
                        usersAndEmail.get(username).add(email);
                    }
                }
                break;
                case "Delete": {
                    String username = tokens[1];
                    if (usersAndEmail.containsKey(username)) {
                        usersAndEmail.remove(username);
                        countUsers--;
                    } else {
                        System.out.printf("%s not found!%n", username);
                    }
                }
                break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Users count: %d%n", countUsers);
        usersAndEmail.entrySet().stream().sorted((u1, u2) -> u2.getValue().size() - u1.getValue().size())
                .forEach(u -> {
                    System.out.printf("%s%n", u.getKey());
                    for (String value : u.getValue()) {
                        System.out.printf("- %s%n", value);
                    }
                });
    }
}
