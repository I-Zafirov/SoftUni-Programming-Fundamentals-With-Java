package T33FinExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class InboxManager2 {
    static Map<String, List<String>> people = new TreeMap<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            switch (tokens[0]) {
                case "Add":
                    add(tokens[1]);
                    break;
                case "Send":
                    send(tokens[1], tokens[2]);
                    break;
                case "Delete":
                    delete(tokens[1]);
                    break;
            }
        }
        System.out.println("Users count: " + people.size());

        List<String> names = people.entrySet().stream().sorted((a, b) ->
                        b.getValue().size() - a.getValue().size())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        for (String name : names) {
            System.out.println(name);
            for (int i = 0; i < people.get(name).size(); i++) {
                System.out.println("- " + people.get(name).get(i));
            }
        }
    }

    private static void delete(String username) {
        if (people.containsKey(username)) {
            people.remove(username);
        } else {
            System.out.printf("%s not found!\n", username);
        }
    }

    private static void send(String username, String email) {
        list = people.get(username);
        list.add(email);
        people.put(username, list);
    }

    private static void add(String username) {
        if (!people.containsKey(username)) {
            list = new ArrayList<>();
            people.put(username, list);
        } else {
            System.out.printf("%s is already registered\n", username);
        }
    }
}
