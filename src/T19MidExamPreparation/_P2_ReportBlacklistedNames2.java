package T19MidExamPreparation;

import java.util.Scanner;

public class _P2_ReportBlacklistedNames2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] list = scanner.nextLine().split(", ");
        String command = scanner.nextLine();
        int countBlacklisted = 0;
        int countLost = 0;
        boolean flag = true;

        while (!command.equals("Report")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];
            switch (action) {
                case "Blacklist":
                    String card = tokens[1];
                    for (int i = 0; i < list.length; i++) {
                        String name = list[i];
                        if (card.equals(name)) {
                            list[i] = "Blacklisted";
                            System.out.printf("%s was blacklisted.%n", card);
                            countBlacklisted++;
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.printf("%s was not found.%n", card);
                    }
                    break;
                case "Error":
                    int position = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < list.length; i++) {
                        String errorName = list[position];
                        if (errorName.equals("Blacklisted") || errorName.equals("Lost")) {
                            break;
                        } else {
                            System.out.printf("%s was lost due to an error.%n", errorName);
                            countLost++;
                            list[position] = "Lost";
                        }
                    }
                    break;
                case "Change":
                    int changeIndex = Integer.parseInt(tokens[1]);
                    String changeName = tokens[2];
                    if (changeIndex < 0 || changeIndex >= list.length) {
                        break;
                    } else {
                        String oldName = list[changeIndex];
                        list[changeIndex] = changeName;
                        System.out.printf("%s changed his username to %s.%n", oldName, changeName);
                    }


                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", countBlacklisted);
        System.out.printf("Lost names: %d%n", countLost);
        System.out.println(String.join(" ", list));
    }
}
