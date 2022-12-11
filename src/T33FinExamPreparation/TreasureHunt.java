package T33FinExamPreparation;

import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] split = scanner.nextLine().split("\\|");
        List<String> chest = new ArrayList<>(Arrays.asList(split));
        String command = scanner.nextLine();
        while (!"Yohoho!".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        if (!chest.contains(tokens[i])) {
                            chest.add(0, tokens[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < chest.size()) {
                        String elemet = chest.remove(index);
                        chest.add(elemet);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    count = Math.min(count, chest.size());
                    List<String> stolen = new ArrayList<String>();
                    for (int i = 0; i < count; i++) {
                        int lastIndex = chest.size() - 1;
                        stolen.add(chest.remove(lastIndex));
                    }
                    Collections.reverse(stolen);
                    System.out.println(String.join(" ", stolen));
                    break;
            }

            command = scanner.nextLine();
        }
        if (chest.size() > 0) {
            double lengthSum = 0;
            for (String s : chest) {
                lengthSum += s.length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", lengthSum / chest.size());
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
