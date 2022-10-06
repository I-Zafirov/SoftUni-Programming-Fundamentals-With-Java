package T33FinExamPreparation;

import java.util.*;

public class DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split("-");

        Map<String, List<String>> likedDishes = new TreeMap<>();
        int count = 0;

        while (!command[0].equals("Stop")) {
            if (command[0].equals("Like")) {
                likedDishes.putIfAbsent(command[1], new ArrayList<>());

                if (!likedDishes.get(command[1]).contains(command[2])) {
                    likedDishes.get(command[1]).add(command[2]);
                }
            } else if (command[0].equals("Dislike")) {
                if (!likedDishes.containsKey(command[1])) {
                    System.out.printf("%s is not at the party.\n", command[1]);
                } else {
                    if (!likedDishes.get(command[1]).contains(command[2])) {
                        System.out.printf("%s doesn't have the %s in his/her collection.\n", command[1], command[2]);
                    } else {
                        likedDishes.get(command[1]).remove(command[2]);
                        System.out.printf("%s doesn't like the %s.\n", command[1], command[2]);
                        count++;
                    }
                }
            }

            command = scanner.nextLine().split("-");
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, List<String>> entry : likedDishes.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
            }
        }

        int counter = 0;
        while (counter < likedDishes.size()) {
            for (Map.Entry<String, List<String>> entry : likedDishes.entrySet()) {
                if (entry.getValue().size() == max) {
                    List<String> list = entry.getValue();
                    System.out.printf("%s: ", entry.getKey());

                    for (int i = 0; i < list.size(); i++) {
                        if (i != list.size() - 1) {
                            System.out.print(list.get(i) + ", ");
                        } else {
                            System.out.print(list.get(i));
                        }
                    }

                    System.out.println();
                    counter++;
                }
            }

            max--;
        }

        System.out.printf("Unliked meals: %d\n", count);
    }
}
