package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _P2_ReportBlacklistedNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        int countBlacklisted = 0;
        int countLost = 0;

        while (!command.equals("Report")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];
            switch (action) {
                case "Blacklist":
                    String name = tokens[1];
                    if (names.contains(name)) {
                        System.out.printf("%s was blacklisted.%n", name);
                        countBlacklisted++;
                        int index = names.indexOf(name);
                        names.set(index, "Blacklisted");
                    }else{
                        System.out.printf("%s was not found.", name);
                    }
                    break;
                case "Error":
                    int position = Integer.parseInt(tokens[1]);
                    String listedName = names.get(position);
                    if (listedName.equals("Blacklisted") || listedName.equals("Lost")) {
                        break;
                    }
                    System.out.printf("%s was lost due to an error.%n", listedName);
                    names.set(position, "Lost");
                    countLost++;
                    break;
                case "Change":
                    int changeIndex = Integer.parseInt(tokens[1]);
                    String changeName = tokens[2];
                    String oldName = names.get(changeIndex);
                    names.set(changeIndex, changeName);
                    System.out.printf("%s changed his username to %s.%n",oldName, changeName);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", countBlacklisted);
        System.out.printf("Lost names: %d%n", countLost);
        System.out.println(names.toString().replaceAll("[\\[\\],]", ""));
    }
}
