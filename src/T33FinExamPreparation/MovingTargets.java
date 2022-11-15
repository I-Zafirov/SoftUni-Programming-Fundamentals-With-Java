package T33FinExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTargets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets =
                Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        String command = scan.nextLine();

        while (!command.equals("End")) {
            String[] commandArray = command.split(" ");
            int index = Integer.parseInt(commandArray[1]);
            int power = Integer.parseInt(commandArray[2]);
            switch (commandArray[0]) {
                case "Shoot":
                    if (index >= targets.size() || index < 0) {
                        break;
                    } else {
                        int currentIndex = targets.get(index);
                        currentIndex -= power;
                        targets.set(index, currentIndex);
                        if (currentIndex <= 0) {
                            targets.remove(index);
                        }
                    }
                    break;
                case "Strike":
                    if (index + power >= targets.size() || index - power < 0) {
                        System.out.println("Strike missed!");
                        break;
                    } else {
                        int startingPower = power;
                        while (power > 0) {
                            targets.remove(index + 1);
                            power--;
                        }
                        while (startingPower >= 0) {
                            targets.remove(index - 1);
                            startingPower--;
                        }
                    }
                    break;
                case "Add":
                    if (index >= targets.size() || index < 0) {
                        System.out.println("Invalid placement!");
                        break;
                    } else {
                        targets.add(index, power);
                    }
                    break;
            }
            command = scan.nextLine();
        }

        for (int i = 0; i < targets.size(); i++) {
            if (i == targets.size() - 1) {
                System.out.print(targets.get(i));
                break;
            }
            System.out.print(targets.get(i) + "|");
        }
    }
}
