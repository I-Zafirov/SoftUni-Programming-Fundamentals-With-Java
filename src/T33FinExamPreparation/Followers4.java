package T33FinExamPreparation;

import java.util.*;

public class Followers4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> Followers = new HashMap<>();
        String input = scanner.nextLine();
        while (!"Log out".equals(input)) {
            String[] tokens = input.split(":\\s+");
            String action = tokens[0];
            String username = tokens[1];
            switch (action) {
                case "New follower":
                    if (!Followers.containsKey(username)) {
                        Followers.put(username, new ArrayList<>());
                        Followers.get(username).add(0, 0); // likes
                        Followers.get(username).add(1, 0); // comments
                    }
                    break;
                case "Like":
                    int newLikes = Integer.parseInt(tokens[2]);
                    if (!Followers.containsKey(username)) {
                        Followers.put(username, new ArrayList<>());
                        Followers.get(username).add(0, newLikes); // add the likes
                        Followers.get(username).add(1, 0); // add 0 comments
                    } else {
                        int oldLikes = Followers.get(username).get(0);  // get current likes from List
                        Followers.get(username).set(0, newLikes + oldLikes); // re-write the likes
                    }
                    break;
                case "Comment":
                    int newComments = 1;
                    if (!Followers.containsKey(username)) {
                        Followers.put(username, new ArrayList<>());
                        Followers.get(username).add(0, 0); // add 0 likes
                        Followers.get(username).add(1, newComments); // add comments
                    } else {
                        int oldComments = Followers.get(username).get(1);  // get current comments from List
                        Followers.get(username).set(1, newComments + oldComments); // re-write the comments
                    }
                    break;
                case "Blocked":
                    if (!Followers.containsKey(username)) {
                        System.out.println(String.format("%s doesn't exist.", username));
                    } else {
                        Followers.remove(username, Followers.get(username));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.format("%d followers", Followers.size()));
        Followers.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if (getLikes(e1.getValue()) == getLikes(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return Integer.compare(getLikes(e2.getValue()), getLikes(e1.getValue()));
                })
                .forEach(e -> System.out.println(String
                        .format("%s: %d", e.getKey(), sumLikesAndComments(e.getValue()))));
    }

    public static int sumLikesAndComments(List<Integer> list) {
        return list.get(0) + list.get(1);
    }

    public static int getLikes(List<Integer> list) {
        return list.get(0);
    }
}
