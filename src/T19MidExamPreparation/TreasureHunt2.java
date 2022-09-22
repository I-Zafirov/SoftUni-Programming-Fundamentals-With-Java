package T19MidExamPreparation;

import java.util.*;

public class TreasureHunt2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\|");
        List<String> stringList = new ArrayList<>(Arrays.asList(input));

        String command = scan.nextLine();
        while (!"Yohoho!".equals(command)) {
            String[] tokens = command.split("\\s+");
            String nameCommand = tokens[0];
            switch ((nameCommand)) {
                case "Loot":
                    String[] items = new String[tokens.length - 1];
                    int count = 0;
                    for (int i = 1; i < tokens.length; i++) {
                        items[count] = tokens[i];
                        count++;
                    }
                    for (String item : items) {
                        if (!stringList.contains(item)) {
                            stringList.add(0, item);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index <= stringList.size() - 1) {
                        stringList.add(stringList.size() - 1, stringList.remove(index));
                    }
                    break;
                case "Steal":
                    count = Integer.parseInt(tokens[1]);
                    List<String> stolen = new ArrayList<>();
                    String output = "";
                    if (count >= stringList.size()) {
                        output = String.join(", ", stringList);
                        System.out.println(output);
                        stringList.clear();
                        break;
                    }
                    for (int i = 0; i < count ; i++) {
                        int lastIndex = stringList.size() - 1;
                        stolen.add(stringList.remove(lastIndex));
                    }
                    Collections.reverse(stolen);
                    output = String.join(", ", stolen);
                    System.out.println(output);
                    break;
            }
            command = scan.nextLine();
        }
        int totalSizeofLoot = 0;
        for (String currentLoot : stringList) {
            totalSizeofLoot += currentLoot.length();
        }
        if (totalSizeofLoot == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            double average = 1.0 * totalSizeofLoot / stringList.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", average);
        }

    }
}
