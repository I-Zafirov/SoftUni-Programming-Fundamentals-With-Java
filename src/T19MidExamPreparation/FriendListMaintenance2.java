package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FriendListMaintenance2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] friends = scanner.nextLine().split(", ");
        List<String> friendsList = new ArrayList<>(Arrays.asList(friends));
        int countOfBlacklisted = 0;
        int lostNames = 0;
        String command = scanner.nextLine();
        while (!command.equals("Report")) {
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "Blacklist": {
                    String name = parts[1];
                    if (friendsList.contains(name)) {
                        int indexName = friendsList.indexOf(name);
                        friendsList.set(indexName, "Blacklisted");
                        System.out.println(String.format("%s was blacklisted.", name));
                        countOfBlacklisted++;
                    } else {
                        System.out.println(String.format("%s was not found.", name));
                    }
                    break;
                }
                case "Error": {
                    int index = Integer.parseInt(parts[1]);
                    if (index >= 0 && index < friendsList.size()) {
                        String userName = friendsList.get(index);
                        String black = "Blacklisted";
                        String lost = "Lost";
                        if (userName.equals(black) || userName.equals(lost)) {
                            break;
                        }
                        if (friendsList.contains(userName)) {
                            friendsList.remove(userName);
                            friendsList.add(index, lost);
                            System.out.printf("%s was lost due to an error.%n", userName);
                            lostNames++;
                            break;
                        }
                    }
                }

                break;
                case "Change": {
                    int index = Integer.parseInt(parts[1]);
                    String newName = parts[2];
                    if (index >= 0 && index < friendsList.size()) {
                        String user = friendsList.get(index);
                        friendsList.remove(user);
                        friendsList.add(index, newName);
                        System.out.printf("%s changed his username to %s.%n", user, newName);
                    }
                }
                break;
            }


            command = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", countOfBlacklisted);
        System.out.printf("Lost names: %d%n", lostNames);
        for (String s : friendsList) {
            System.out.print(s + " ");
        }


    }
}

