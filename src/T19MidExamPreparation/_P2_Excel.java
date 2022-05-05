package T19MidExamPreparation;

import java.util.Scanner;

public class _P2_Excel {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rowsCount = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rowsCount][];
        for (int i = 0; i < rowsCount; i++) {
            matrix[i] = scanner.nextLine().split(", ");
        }

        String[] commandArguments = scanner.nextLine().split("\\s+");

        if (commandArguments[0].equals("hide")) {
            hideColumnAndPrint(matrix, commandArguments[1]);
        } else if (commandArguments[0].equals("sort")) {
            sortByColumnAndPrint(matrix, commandArguments[1]);
        } else {
            filterByColumnAndPrint(matrix, commandArguments[1], commandArguments[2]);
        }

    }

    private static void filterByColumnAndPrint(String[][] matrix, String filterColumn, String filterValue) {
        int filterColumnIndex = getColumnIndexByName(matrix[0], filterColumn);

        System.out.println(String.join(" | ", matrix[0]));
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][filterColumnIndex].equals(filterValue)) {
                System.out.println(String.join(" | ", matrix[i]));
            }
        }
    }

    private static void sortByColumnAndPrint(String[][] matrix, String sortColumnName) {
        int sortColumnIndex = getColumnIndexByName(matrix[0], sortColumnName);

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 1; i < matrix.length - 1 - j; i++) {
                if (matrix[i][sortColumnIndex].compareTo(matrix[i + 1][sortColumnIndex]) > 0) {
                    String[] temp = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = temp;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }

    }

    private static void hideColumnAndPrint(String[][] matrix, String hiddenColumn) {
        int hiddenColumnIndex = getColumnIndexByName(matrix[0], hiddenColumn);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (j == hiddenColumnIndex) {
                    continue;
                }

                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    private static int getColumnIndexByName(String[] matrix, String columnName) {
        int hiddenColumnIndex = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].equals(columnName)) {
                return hiddenColumnIndex = i;
            }
        }
        return hiddenColumnIndex;
    }
}
