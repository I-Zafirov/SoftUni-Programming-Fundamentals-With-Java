package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire2 {
    private static List<List<Integer>> fillMatrix(Integer rows, Integer cols) {
        List<List<Integer>> matrix = new ArrayList<>();

        for (Integer i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (Integer j = 1; j <= cols; j++) {
                matrix.get(i).add(i * cols + j);
            }
        }

        return matrix;
    }

    private static List<List<Integer>> destroy(List<List<Integer>> matrix) {
        for (Integer i = 0; i < matrix.size(); i++) {
            matrix.get(i).removeAll(Arrays.asList(new Integer[]{-1}));
        }

        matrix.removeAll(Arrays.asList(new ArrayList<>()));
        return matrix;
    }

    private static boolean isValid(Integer row, Integer col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer m = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> matrix = fillMatrix(n, m);

        String line = sc.nextLine();
        while (!"Nuke it from orbit".equals(line)) {
            Integer shotRow = Integer.parseInt(line.split(" ")[0]);
            Integer shotCol = Integer.parseInt(line.split(" ")[1]);
            Integer shotRadius = Integer.parseInt(line.split(" ")[2]);

            for (Integer row = shotRow - shotRadius; row <= shotRow + shotRadius; row++) {
                if (isValid(row, shotCol, matrix)) {
                    matrix.get(row).set(shotCol, -1);
                }
            }

            for (Integer col = shotCol - shotRadius; col <= shotCol + shotRadius; col++) {
                if (isValid(shotRow, col, matrix)) {
                    matrix.get(shotRow).set(col, -1);
                }
            }
            matrix = destroy(matrix);

            line = sc.nextLine();
        }

        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(matrix.get(i).toString().substring(1, matrix.get(i).toString().length() - 1).replaceAll(",", ""));
        }
    }
}
