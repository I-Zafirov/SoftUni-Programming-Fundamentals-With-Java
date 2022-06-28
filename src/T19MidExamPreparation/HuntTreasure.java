package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HuntTreasure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> loot = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] commandArray = command.split(" ");
            String currentCommand = commandArray[0];

            switch (currentCommand) {
                case "Loot":
                    for (int i = 1; i < commandArray.length; i++) {
                        if (!loot.contains(commandArray[i])) {
                            loot.add(0, commandArray[i]);
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(commandArray[1]);
                    if (dropIndex < 0 || dropIndex >= loot.size()) {
                        break;
                    }
                    String itemToDrop = loot.remove(dropIndex);
                    loot.add(itemToDrop);
                    break;
                case "Steal":
                    int stealAmount = Integer.parseInt(commandArray[1]);

                    List<String> stolenItems = new ArrayList<>();
                    String output = "";
                    if (stealAmount >= loot.size()) {
                        output = String.join(", ", loot);
                        System.out.println(output);
                        loot.clear();
                        break;
                    } else {
                        for (int i = 0; i < stealAmount; i++) {
                            int lastIndex = loot.size() - 1;
                            stolenItems.add(0, loot.remove(lastIndex));
                        }
                    }
                    output = String.join(", ", stolenItems);
                    System.out.println(output);
                    break;
            }
            command = scanner.nextLine();
        }
        int totalSizeOfLoot = 0;
        for (String currentLoot : loot) {
            totalSizeOfLoot += currentLoot.length();
        }
        if (totalSizeOfLoot == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            double averagePrice = 1.0 * totalSizeOfLoot / loot.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averagePrice);
        }
        System.out.println();
    }
}
