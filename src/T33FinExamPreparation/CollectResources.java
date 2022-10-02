package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectResources {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] resources = scanner.nextLine().split("\\s+");
        ArrayList<Integer> indexes = new ArrayList<>();
        int maxQuantity = 0;
        int numOfPaths = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numOfPaths; i++) {
            int totalQuantity = 0;
            String[] path = scanner.nextLine().split("\\s+");
            int currentIndex = Integer.parseInt(path[0]);
            int offset = Integer.parseInt(path[1]);
            indexes.clear();
            while (true) {
                if (indexes.contains(currentIndex)) {
                    break;
                }
                indexes.add(currentIndex);
                int quantity = 0;
                String[] resource = resources[currentIndex].split("_");
                if (resources[currentIndex].equals("stone")
                        || resources[currentIndex].equals("gold")
                        || resources[currentIndex].equals("wood")
                        || resources[currentIndex].equals("food")) {
                    resource[0] = resources[currentIndex];
                    quantity = 1;
                } else if (resource[0].equals("stone")
                        || resource[0].equals("gold")
                        || resource[0].equals("wood")
                        || resource[0].equals("food")) {
                    quantity = Integer.parseInt(resource[1]);
                }
                if (resource[0].equals("stone")
                        || resource[0].equals("gold")
                        || resource[0].equals("wood")
                        || resource[0].equals("food")) {
                    totalQuantity += quantity;
                }
                if (totalQuantity > maxQuantity) {
                    maxQuantity = totalQuantity;
                }
                currentIndex = (currentIndex + offset) % resources.length;
            }
        }
        System.out.println(maxQuantity);
    }
}
