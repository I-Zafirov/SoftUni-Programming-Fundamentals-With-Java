package T33FinExamPreparation;

import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, ArrayList<String>> users = new HashMap<>();
        String expression;
        String[] data;

        while (!(expression = scanner.nextLine()).equals("Statistics")) {
            data = expression.split("->");
            switch (data[0]) {
                case "Add": {
                    if (!users.containsKey(data[1])) {
                        users.put(data[1], new ArrayList<>());
                    } else {
                        System.out.printf("%s is already registered%n", data[1]);
                    }
                    break;
                }
                case "Send": {
                    users.get(data[1]).add(data[2]);
                    break;
                }
                case "Delete": {
                    if (!users.containsKey(data[1])) {
                        System.out.printf("%s not found!%n", data[1]);
                    } else {
                        users.remove(data[1]);
                    }
                    break;
                }
                default:
                    break;
            }
        }
        System.out.printf("Users count: %d%n", users.size());

        users.entrySet().stream()
                .sorted(Map.Entry.<String, ArrayList<String>>comparingByValue(Comparator.comparing(ArrayList::size))
                        .reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(user -> {
                    System.out.println(user.getKey());

                    user.getValue().stream().forEach(mail -> {
                        System.out.printf(" - %s%n", mail);
                    });
                });
    }
}
