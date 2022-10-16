package T33FinExamPreparation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Followers {
    static Map<String, Integer> likes = new HashMap<>();
    static Map<String, Integer> comments = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"Log out".equals(input)) {
            String[] tokens = input.split(": ");
            switch (tokens[0]) {
                case "New follower":
                    add(tokens[1]);
                    break;
                case "Like":
                    like(tokens[1], Integer.parseInt(tokens[2]));
                    break;
                case "Comment":
                    comment(tokens[1]);
                    break;
                case "Blocked":
                    blocked(tokens[1]);
                    break;
            }
        }
        List<String> names = likes.entrySet().stream()
                .sorted((entryA, entryB) -> {
                    int likesA = entryA.getValue();
                    String nameA = entryA.getKey();
                    int likesB = entryB.getValue();
                    String nameB = entryB.getKey();
                    if (likesA != likesB) {
                        return Integer.compare(likesB, likesA);
                    } else {
                        return nameA.compareTo(nameB);
                    }
                })
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.printf("%d followers\n", names.size());
        for (String name : names) {
            System.out.printf("%s: %d\n", name, likes.get(name) + comments.get(name));
        }
    }

    private static void blocked(String username) {
        if (!likes.containsKey(username)) {
            System.out.printf("%s doesn't exist.\n", username);
        } else {
            likes.remove(username);
            comments.remove(username);
        }
    }

    private static void comment(String username) {
        if (!comments.containsKey(username)) {
            comments.put(username, 1);
            likes.put(username, 0);
        } else {
            comments.put(username, comments.get(username) + 1);
        }
    }

    private static void like(String username, int count) {
        if (!likes.containsKey(username)) {
            likes.put(username, count);
            comments.put(username, 0);
        } else {
            likes.put(username, likes.get(username) + count);
        }
    }

    private static void add(String username) {
        if (!isItContained(username)) {
            likes.put(username, 0);
            comments.put(username, 0);
        }
    }

    private static boolean isItContained(String username) {
        if (likes.containsKey(username)) {
            return true;
        }
        return false;
    }
}
