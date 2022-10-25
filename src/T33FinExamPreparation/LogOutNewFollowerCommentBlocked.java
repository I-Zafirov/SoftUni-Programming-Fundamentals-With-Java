package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogOutNewFollowerCommentBlocked {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> followerLikes = new TreeMap<>();
        Map<String, Integer> followerComments = new TreeMap<>();
        while (!input.equals("Log out")) {
            String[] inputSpilt = input.split(": ");
            String command = inputSpilt[0];
            String username = inputSpilt[1];
            switch (command) {
                case "New follower":
                    followerLikes.putIfAbsent(username, 0);
                    followerComments.putIfAbsent(username, 0);
                    break;
                case "Like":
                    int count = Integer.parseInt(inputSpilt[2]);
                    if (followerLikes.containsKey(username)) {
                        int currentLikes = followerLikes.get(username);
                        followerLikes.put(username, currentLikes + count);
                    } else {
                        followerLikes.put(username, count);
                        followerComments.put(username, 0);
                    }
                    break;
                case "Comment":
                    if (followerComments.containsKey(username)) {
                        int currentComments = followerComments.get(username);
                        followerComments.put(username, currentComments + 1);
                    } else {
                        followerComments.put(username, 1);
                        followerLikes.put(username, 0);
                    }
                    break;
                case "Blocked":
                    if (followerLikes.containsKey(username) || followerComments.containsKey(username)) {
                        followerLikes.remove(username);
                        followerComments.remove(username);
                    } else {
                        System.out.printf("%s doesn't exist.%n", username);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        followerComments.forEach((k, v) -> followerLikes.merge(k, v, Integer::sum));

        System.out.printf("%d followers%n", followerLikes.size());
        followerLikes.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}
