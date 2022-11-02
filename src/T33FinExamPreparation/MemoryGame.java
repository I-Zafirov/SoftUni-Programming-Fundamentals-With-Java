package T33FinExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String[] command = scan.nextLine().split(" ");
        int turns = 0;

        while (!command[0].equals("end")) {
            int firstNum = Integer.parseInt(command[0]);
            int secondNum = Integer.parseInt(command[1]);

            turns++;

            if (firstNum < 0 || secondNum < 0 || firstNum >= numbers.size() || secondNum >= numbers.size() || firstNum == secondNum) {

                System.out.println("Invalid input! Adding additional elements to the board");
                numbers.add(numbers.size() / 2, -turns + "a");
                numbers.add(numbers.size() / 2, -turns + "a");

            } else if (numbers.get(firstNum).equals(numbers.get(secondNum))) {
                System.out.printf("Congrats! You have found matching elements - %s!\n", numbers.get(firstNum));

                if (firstNum > secondNum) {
                    numbers.remove(firstNum);
                    numbers.remove(secondNum);
                } else {
                    numbers.remove(secondNum);
                    numbers.remove(firstNum);
                }
                if (numbers.isEmpty()) {
                    System.out.println("You have won in " + turns + " turns!");
                    break;
                }

            } else {
                System.out.println("Try again!");
            }

            command = scan.nextLine().split(" ");
        }

        if (command[0].equals("end")) {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", numbers));
        }
    }
}
