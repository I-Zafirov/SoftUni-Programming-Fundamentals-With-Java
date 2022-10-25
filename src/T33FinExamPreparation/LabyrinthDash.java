package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabyrinthDash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 0;
        int col = 0;
        int lives = 3;
        int movesMade = 0;

        Integer n = Integer.parseInt(sc.nextLine());

        List<char[]> labyrinth = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            labyrinth.add(sc.nextLine().toCharArray());
        }

        char[] moves = sc.nextLine().toCharArray();

        for (char move : moves) {
            movesMade++;

            switch (move) {
                case 'v':
                    row++;
                    break;
                case '^':
                    row--;
                    break;
                case '<':
                    col--;
                    break;
                case '>':
                    col++;
                    break;
            }


            if (!validCoordinates(row, col, labyrinth) || labyrinth.get(row)[col] == ' ') {
                System.out.println("Fell off a cliff! Game Over!");
                break;
            } else if (labyrinth.get(row)[col] == '|' || labyrinth.get(row)[col] == '_') {
                System.out.println("Bumped a wall.");
                switch (move) {
                    case 'v':
                        row--;
                        break;
                    case '^':
                        row++;
                        break;
                    case '<':
                        col++;
                        break;
                    case '>':
                        col--;
                        break;
                }
                movesMade--;
            } else if (labyrinth.get(row)[col] == '*' || labyrinth.get(row)[col] == '#' || labyrinth.get(row)[col] == '@') {
                lives--;
                System.out.printf("Ouch! That hurt! Lives left: %d%n", lives);

                if (lives == 0) {
                    System.out.println("No lives left! Game Over!");
                    break;
                }
            } else if (labyrinth.get(row)[col] == '$') {
                lives++;
                System.out.printf("Awesome! Lives left: %d%n", lives);
                labyrinth.get(row)[col] = '.';
            } else if (labyrinth.get(row)[col] == '.') {
                System.out.println("Made a move!");
            }
        }
        System.out.printf("Total moves made: %d", movesMade);
    }

    private static boolean validCoordinates(int row, int col, List<char[]> labyrinth) {
        return row >= 0 && row < labyrinth.size() && col >= 0 && col < labyrinth.get(row).length;
    }
}
