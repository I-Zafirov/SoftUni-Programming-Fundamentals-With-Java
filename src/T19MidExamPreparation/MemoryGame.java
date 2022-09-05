package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int moves = 0;
        while (true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }
            String[] tokens = input.split(" ");
            int index1 = Integer.parseInt(tokens[0]);
            int index2 = Integer.parseInt(tokens[1]);
            moves++;

            if (index1 == index2 || index1 < 0 || index2 < 0 || index1 >= items.size() || index2 >= items.size()){
                items.add(items.size() / 2, String.format("-%da", moves));
                items.add(items.size() / 2, String.format("-%da", moves));
                System.out.println("Invalid input! Adding additional elements to the board");
                continue;
            }

            if (items.get(index1).equals(items.get(index2))){
                System.out.printf("Congrats! You have found matching elements - %s!%n", items.get(index2));
                items.remove(Math.max(index1, index2));
                items.remove(Math.min(index1, index2));
            }else{
                System.out.println("Try again!");
            }

            if (items.isEmpty()){
                System.out.printf("You have won in %d turns!%n", moves);
                return;
            }
        }
        if (!items.isEmpty()){
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", items));
        }
    }
}
