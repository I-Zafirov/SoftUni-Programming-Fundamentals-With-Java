package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRow = scanner.nextInt();
        int matrixCol = scanner.nextInt();
        scanner.nextLine();
        ArrayList<ArrayList<Integer>> field = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < matrixRow; i++) {
            field.add(new ArrayList<>());
            for (int j = 0; j < matrixCol; j++) {
                field.get(i).add(count);
                count++;
            }
        }
        String[] bombStats = scanner.nextLine().split(" ");
        while (!bombStats[0].toLowerCase().equals("nuke")) {
            int givenRow = Integer.parseInt(bombStats[0]);
            int givenCol = Integer.parseInt(bombStats[1]);
            int radius = Integer.parseInt(bombStats[2]);
            if (givenRow < field.size() && givenRow >= 0) {
                if (givenCol < field.get(givenRow).size() && givenCol >= 0) {
                    field.get(givenRow).set(givenCol, 0);
                }
            }
            for (int i = 0; i < radius; i++) {
                // clears down
                int cellDown = givenRow + radius - i;
                if (cellDown < field.size() && cellDown >= 0) {
                    if (givenCol >= 0 && givenCol < field.get(cellDown).size()) {
                        field.get(cellDown).set(givenCol, 0);
                    }
                }
                //clears up
                int cellUp = givenRow - radius + i;
                if (cellUp < field.size() && cellUp >= 0) {
                    if (givenCol >= 0 && givenCol < field.get(cellUp).size()) {
                        field.get(cellUp).set(givenCol, 0);
                    }
                }
                //clears left
                int cellLeft = givenCol - radius + i;
                if (givenRow >= 0 && givenRow < field.size()) {
                    if (cellLeft >= 0 && cellLeft < field.get(givenRow).size()) {
                        field.get(givenRow).set(cellLeft, 0);
                    }
                }
                //clears right
                int cellRight = givenCol + radius - i;
                if (givenRow >= 0 && givenRow < field.size()) {
                    if (cellRight >= 0 && cellRight < field.get(givenRow).size()) {
                        field.get(givenRow).set(cellRight, 0);
                    }
                }
            }
            for (int row = 0; row < field.size(); row++) {
                field.get(row).removeAll(Arrays.asList(0));
                if (field.get(row).size() <= 0) {
                    field.remove(row);
                }
            }
            bombStats = scanner.nextLine().split(" ");
        }
        printMatrix(field);
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> fieldRow : matrix) {
            String currentLine = "";
            for (Integer fieldCol : fieldRow) {
                currentLine += fieldCol + " ";
            }
            System.out.println(currentLine.trim());
        }
    }
}
