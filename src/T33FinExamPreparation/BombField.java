package T33FinExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombField {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] moves = scanner.nextLine().split(",");
        String[][] field = new String[fieldSize][];

        int[] sapperPos = new int[2];

        //populate the field
        for (int i = 0; i < fieldSize; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            field[i] = line;

            List<String> lineAsList = Arrays.stream(line).collect(Collectors.toList());
            if (lineAsList.contains("s")) {
                sapperPos[0] = i;
                sapperPos[1] = lineAsList.indexOf("s");
            }
        }
        int bombsLeft = 0;
        boolean isGameGoing = false;
        for (int i = 0; i < moves.length; i++) {

            isGameGoing = moveSapper(field, sapperPos, moves[i]);
            bombsLeft = checkForBombsCount(field);
            if (!isGameGoing) {
                System.out.printf("END! %d bombs left on the field", bombsLeft);
                break;
            }
            if (bombsLeft == 0) {
                System.out.println("Congratulations! You found all bombs!");
                break;
            }
        }
        if (isGameGoing && bombsLeft > 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",
                    bombsLeft, sapperPos[0], sapperPos[1]);
        }
    }


    private static boolean moveSapper(String[][] field, int[] sapperPos, String direction) {

        boolean isGameGoing = true;
        switch (direction) {

            case "up":
                if (sapperPos[0] == 0) {
                    break;
                } else {
                    field[sapperPos[0]--][sapperPos[1]] = "+";
                    isGameGoing = saveMoveSapper(sapperPos, field);
                }
                break;

            case "down":
                if (sapperPos[0] == field[0].length - 1) {
                    break;
                } else {
                    field[sapperPos[0]++][sapperPos[1]] = "+";
                    isGameGoing = saveMoveSapper(sapperPos, field);
                }
                break;

            case "left":
                if (sapperPos[1] == 0) {
                    break;
                } else {
                    field[sapperPos[0]][sapperPos[1]--] = "+";
                    isGameGoing = saveMoveSapper(sapperPos, field);
                }
                break;

            case "right":
                if (sapperPos[1] == field[0].length - 1) {
                    break;
                } else {
                    field[sapperPos[0]][sapperPos[1]++] = "+";
                    isGameGoing = saveMoveSapper(sapperPos, field);
                    break;
                }
        }

        return isGameGoing;
    }

    private static boolean saveMoveSapper(int[] sapperPos, String[][] field) {
        checkForBomb(field[sapperPos[0]][sapperPos[1]]);
        if (field[sapperPos[0]][sapperPos[1]].equals("e")) {
            return false;
        }
        field[sapperPos[0]][sapperPos[1]] = "s";
        return true;
    }

    private static void checkForBomb(String f) {
        if (f.equals("B")) {
            System.out.println("You found a bomb!");
        }
    }

    private static int checkForBombsCount(String[][] field) {

        int bombsLeft = 0;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[0].length; col++) {
                if (field[row][col].equals("B")) {
                    bombsLeft++;
                }
            }
        }

        return bombsLeft;
    }
}
