package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Followers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, int[]> usernameLikesCommentsMap = new TreeMap<>();
        String command;
        while (!"Log out".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "New":
                    String username = tokens[2];
                    usernameLikesCommentsMap.putIfAbsent(username, new int[2]);
                    break;
                case "Like:":
                    String usernameLike = tokens[1];
                    usernameLike = usernameLike.replace(":", "");
                    int count = Integer.parseInt(tokens[2]);
                    if (!usernameLikesCommentsMap.containsKey(usernameLike)) {
                        usernameLikesCommentsMap.put(usernameLike, new int[2]);
                        usernameLikesCommentsMap.get(usernameLike)[0] = count;
                    } else {
                        int currentCount = usernameLikesCommentsMap.get(usernameLike)[0];
                        usernameLikesCommentsMap.get(usernameLike)[0] = currentCount + count;
                    }
                    break;
                case "Comment:":
                    String usernameComment = tokens[1];
                    if (!usernameLikesCommentsMap.containsKey(usernameComment)) {
                        usernameLikesCommentsMap.put(usernameComment, new int[2]);
                        usernameLikesCommentsMap.get(usernameComment)[1] = 1;
                    } else {
                        int currentComments = usernameLikesCommentsMap.get(usernameComment)[1];
                        usernameLikesCommentsMap.get(usernameComment)[1] = currentComments + 1;
                    }
                    break;
                case "Blocked:":
                    String blockedUsername = tokens[1];
                    if (usernameLikesCommentsMap.containsKey(blockedUsername)) {
                        usernameLikesCommentsMap.remove(blockedUsername);
                    } else {
                        System.out.printf("%s doesn't exist.%n", blockedUsername);
                    }
                    break;
            }
        }
        System.out.printf("%d followers%n", usernameLikesCommentsMap.size());
        usernameLikesCommentsMap
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue()[0] - a.getValue()[0])
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()[0] + entry.getValue()[1]);
                });
    }
}
