package T19MidExamPreparation;

import java.util.Scanner;

public class FriendList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friendList = scanner.nextLine().split(", ");

        int countBlacklisted = 0;
        int countLost = 0;

        String input = scanner.nextLine();

        while (!input.equals("Report")) {

            String[] command = input.split("\\s+");

            String commandName = command[0];

            switch (commandName) {
                case "Blacklist":
                    String nameToBlacklist = command[1];
                    boolean isNameFound = false;
                    for (int i = 0; i < friendList.length; i++) {
                        if (friendList[i].equals(nameToBlacklist)) {
                            countBlacklisted++;
                            friendList[i] = "Blacklisted";
                            System.out.printf("%s was blacklisted.%n", nameToBlacklist);
                            isNameFound = true;
                            break;
                        }
                    }
                    if (!isNameFound) {
                        System.out.printf("%s was not found.%n", nameToBlacklist);
                    }
                    break;
                case "Error":
                    int errorIndex = Integer.parseInt(command[1]);
                    if (errorIndex >= 0 && errorIndex < friendList.length) {
                        if (!friendList[errorIndex].equals("Blacklisted")
                                && !friendList[errorIndex].equals("Lost")) {
                            countLost++;
                            System.out.printf("%s was lost due to an error.%n", friendList[errorIndex]);
                            friendList[errorIndex] = "Lost";
                        }
                    }
                    break;
                case "Change":
                    int changeIndex = Integer.parseInt(command[1]);
                    String newName = command[2];
                    if (changeIndex >= 0 && changeIndex < friendList.length) {
                        if (!friendList[changeIndex].equals("Blacklisted")
                                && !friendList[changeIndex].equals("Lost")) {
                            System.out.printf("%s changed his username to %s.%n", friendList[changeIndex], newName);
                            friendList[changeIndex] = newName;
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n" +
                "Lost names: %d%n", countBlacklisted, countLost);

        for (String friend:friendList) {
            System.out.printf("%s ", friend);
        }
    }
}
