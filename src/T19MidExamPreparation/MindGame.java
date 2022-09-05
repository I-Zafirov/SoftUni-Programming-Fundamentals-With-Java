package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MindGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> board = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        int countTurns = 0;

        while (!command.equals("end")) {
            String[] tokens = command.split("\\s+");
            int index1 = Integer.parseInt(tokens[0]);
            int index2 = Integer.parseInt(tokens[1]);

            if (index1 == index2) {
                System.out.println("Invalid input! Adding additional elements to the board");
                countTurns++;
                addElementsToTheBoard(board, countTurns);
            } else if ((index1 < 0 || index1 >= board.size()) ||
                    (index2 < 0 || index2 >= board.size())) {
                System.out.println("Invalid input! Adding additional elements to the board");
                countTurns++;
                addElementsToTheBoard(board, countTurns);
            } else {
                if (board.get(index1).equals(board.get(index2))) {
                    countTurns++;
                    System.out.printf("Congrats! You have found matching elements - %s!%n", board.get(index1));
                    String elementToRemove = board.get(index1);
                    board.remove(elementToRemove);
                    board.remove(elementToRemove);
                } else {
                    System.out.println("Try again!");
                    countTurns++;
                }
            }
            if (board.size() == 0) {
                System.out.printf("You have won in %d turns!", countTurns);
                break;
            }
            command = scanner.nextLine();
        }

        if (board.size() > 0) {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", board));
        }
    }

    private static void addElementsToTheBoard(List<String> board, int countTurns) {
        int middleIndex = board.size() / 2;
        String element = "-" + countTurns + "a";
        board.add(middleIndex, element);
        board.add(middleIndex + 1, element);
    }

}
