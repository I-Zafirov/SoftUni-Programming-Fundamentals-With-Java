package T33FinExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Treasure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] split = scanner.nextLine().split("\\|");
        List<String> chest = Arrays.stream(split).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Yohoho!")) {
            String[] commandArguments = command.split(" ");
            switch (commandArguments[0]) {
                case "Loot":
                    for (int i = 1; i < commandArguments.length; i++) {
                        if (!chest.contains(commandArguments[i])) {
                            chest.add(0, commandArguments[i]);
                        }
                    }
                    break;
                case "Drop":
                    int indexOne = Integer.parseInt(commandArguments[1]);
                    if (indexOne > chest.size() - 1 || indexOne < 0) {
                        System.out.println(String.join(", ", chest));
                        chest.clear();
                        break;
                    }
                    String temp = chest.remove(indexOne);
                    chest.add(temp);
                    break;
                case "Steal":
                    int index = Integer.parseInt(commandArguments[1]);
                    if (index > chest.size() - 1) {
                        System.out.println();
                        break;
                    }
                    List<String> stolen = new ArrayList<>();
                    for (int i = 0; i < index; i++) {
                        int lastIndex = chest.size() - 1;
                        stolen.add(chest.remove(lastIndex));
                    }
                    Collections.reverse(stolen);
                    System.out.println(String.join(", ", stolen));
                    break;
            }
            command = scanner.nextLine();
        }
        if (chest.size() > 0) {
            int sum = 0;
            for (int i = 0; i < chest.size(); i++) {
                for (int j = 0; j < chest.get(i).length(); j++) {
                    sum = sum + 1;
                }
            }
            double nextSum = sum * 1.0 / chest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.",
                    nextSum);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
