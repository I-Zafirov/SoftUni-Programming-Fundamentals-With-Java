package T33FinExamPreparation;

import java.util.Scanner;

public class NukeItFromOrbit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[row][col];

        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = count;
                count++;
            }
        }

        String input = sc.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] data = input.split(" ");

            int attRow = Integer.parseInt(data[0]);
            int attCol = Integer.parseInt(data[1]);
            int attRad = Integer.parseInt(data[2]);

            if (IsInMatrix(matrix, attRow, attCol)) {
                matrix[attRow][attCol] = 0;
            }

            for (int i = 1; i <= attRad; i++) {
                if (IsInMatrix(matrix, attRow + i, attCol)) {
                    matrix[attRow + i][attCol] = 0;
                }
                if (IsInMatrix(matrix, attRow - i, attCol)) {
                    matrix[attRow - i][attCol] = 0;
                }
                if (IsInMatrix(matrix, attRow, attCol + i)) {
                    matrix[attRow][attCol + i] = 0;
                }
                if (IsInMatrix(matrix, attRow, attCol - i)) {
                    matrix[attRow][attCol - i] = 0;
                }
            }

            int rowCount = 0;
            for (int i = 0; i < matrix.length; i++) {
                int colCount = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        int num = matrix[i][j];
                        matrix[i][j] = 0;
                        matrix[rowCount][colCount] = num;
                        colCount++;
                    }
                }
                if (colCount > 0) {
                    rowCount++;
                }
            }

            input = sc.nextLine();
        }

        for (int i = 0; i < matrix.length; i++) {
            boolean check = false;
            String line = "";
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    line += matrix[i][j] + " ";
                    check = true;
                }
            }
            if (check) {
                System.out.println(line.trim());
            }
        }
    }


    public static boolean IsInMatrix(int[][] matrix, int row, int col) {
        if ((matrix.length > row && row >= 0) && (matrix[row].length > col && col >= 0)) {
            return true;
        } else {
            return false;
        }
    }
}
