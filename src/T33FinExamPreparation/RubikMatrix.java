package T33FinExamPreparation;

import java.util.Scanner;

public class RubikMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        int commands = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[rows][cols];
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = count;
                count++;
            }
        }


        for (int i = 0; i < commands; i++) {
            String[] info = sc.nextLine().split("\\s+");
            int index = Integer.parseInt(info[0]);
            String direction = info[1];
            int moves = Integer.parseInt(info[2]);

            if (direction.equals("up")) {
                int lastSave = 0;
                int currSave = 0;
                for (int move = 0; move < moves % rows; move++) {
                    lastSave = 0;
                    currSave = 0;
                    for (int j = matrix.length - 1; j >= 0; j--) {
                        if (j != matrix.length - 1) {
                            currSave = matrix[j][index];
                            matrix[j][index] = lastSave;
                            lastSave = currSave;
                        } else {
                            lastSave = matrix[j][index];
                            matrix[j][index] = matrix[0][index];
                        }
                    }
                }
            } else if (direction.equals("down")) {
                int lastSave = 0;
                int currSave = 0;
                for (int move = 0; move < moves % rows; move++) {
                    lastSave = 0;
                    currSave = 0;
                    for (int j = 0; j < matrix.length; j++) {
                        if (j != 0) {
                            currSave = matrix[j][index];
                            matrix[j][index] = lastSave;
                            lastSave = currSave;
                        } else {
                            lastSave = matrix[0][index];
                            matrix[0][index] = matrix[matrix.length - 1][index];
                        }
                    }
                }
            } else if (direction.equals("right")) {
                int lastSave = 0;
                int currSave = 0;
                for (int move = 0; move < moves % cols; move++) {
                    lastSave = 0;
                    currSave = 0;
                    for (int j = 0; j < matrix[index].length; j++) {
                        if (j != 0) {
                            currSave = matrix[index][j];
                            matrix[index][j] = lastSave;
                            lastSave = currSave;
                        } else {
                            lastSave = matrix[index][0];
                            matrix[index][0] = matrix[index][matrix.length - 1];
                        }
                    }
                }
            } else if (direction.equals("left")) {
                int lastSave = 0;
                int currSave = 0;
                for (int move = 0; move < moves % cols; move++) {
                    lastSave = 0;
                    currSave = 0;
                    for (int j = matrix[index].length - 1; j >= 0; j--) {
                        if (j != matrix[index].length - 1) {
                            currSave = matrix[index][j];
                            matrix[index][j] = lastSave;
                            lastSave = currSave;
                        } else {
                            lastSave = matrix[index][j];
                            matrix[index][j] = matrix[index][0];
                        }
                    }
                }
            }
        }
        count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int foundRow = Finding(matrix, count)[0];
                int foundCol = Finding(matrix, count)[1];
                if (row == foundRow && col == foundCol) {
                    System.out.println("No swap required");
                } else {
                    System.out.printf("Swap (%d, %d) with (%d, %d)%n", row, col, foundRow, foundCol);
                    int save = matrix[row][col];
                    matrix[row][col] = matrix[foundRow][foundCol];
                    matrix[foundRow][foundCol] = save;
                }
                count++;
            }
        }

    }

    public static int[] Finding(int[][] matrix, int num) {
        int[] found = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == num) {
                    found[0] = row;
                    found[1] = col;
                    return found;
                }
            }
        }
        return found;
    }
}
