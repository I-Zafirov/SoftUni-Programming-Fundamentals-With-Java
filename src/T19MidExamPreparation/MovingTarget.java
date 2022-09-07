package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();
            if ("End".equals(input)) {
                break;
            }
            String[] tokens = input.split(" ");

            String command = tokens[0];
            int index = Integer.parseInt(tokens[1]);
            int number = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Shoot":
                    if (index >= 0 && index < targets.size()) {
                        int target = targets.get(index);
                        if (target <= number) {
                            targets.remove(index);
                        } else {
                            targets.set(index, target - number);
                        }
                    }
                    break;
                case "Add":
                    if (index < 0 || index >= targets.size()) {
                        System.out.println("Invalid placement!");
                        break;
                    } else {
                        targets.add(index, number);
                    }
                    break;
                case "Strike":
                    if (index >= 0 && index < targets.size()) {
                        int start = index - number;
                        int end = index + number;
                        if (start < 0 || end > targets.size()) {
                            System.out.println("Strike missed!");
                            break;
                        } else {
                            while (start <= end) {
                                targets.remove(start);
                                end--;
                            }
                        }
                    }
                    break;
            }
        }
        for (int i = 0; i < targets.size(); i++) {
            System.out.print(targets.get(i));
            if (i < targets.size() - 1) {
                System.out.print("|");
            }
        }
    }
}
