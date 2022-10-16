package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FollowersDoesntExistLogOut {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Map<String, Integer> res = new TreeMap<>();
        String input = inp.nextLine();
        int cnt = 0;
        while (!input.equals("Log out")) {
            String[] argumet = input.split(": ");
            String command = argumet[0];
            switch (command) {
                case "New follower":
                    String name = argumet[1];
                    if (!res.containsKey(name)) {
                        res.put(name, 0);
                        cnt++;
                    }
                    break;
                case "Like":
                    name = argumet[1];
                    int num = Integer.parseInt(argumet[2]);
                    if (!res.containsKey(name)) {
                        res.put(name, num);
                        cnt++;
                    } else {
                        res.put(name, res.get(name) + num);
                    }
                    break;
                case "Comment":
                    name = argumet[1];
                    if (!res.containsKey(name)) {
                        res.put(name, 1);
                        cnt++;
                    } else {
                        res.put(name, res.get(name) + 1);
                    }
                    break;
                case "Blocked":
                    name = argumet[1];
                    if (res.containsKey(name)) {
                        res.remove(name);
                        cnt--;
                    } else {
                        System.out.printf("%s doesn't exist.%n", name);
                    }
                    break;
            }
            input = inp.nextLine();
        }
        System.out.printf("%s followers%n", cnt);
        res.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.printf("%s: %s%n",
                        entry.getKey(),
                        entry.getValue()));
    }
}
