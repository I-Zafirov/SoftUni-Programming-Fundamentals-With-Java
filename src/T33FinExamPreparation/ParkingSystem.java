package T33FinExamPreparation;

import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(dimensions[0]);
        int col = Integer.parseInt(dimensions[1]);
        boolean[][] parkingLot = new boolean[row][col];
        String[] coordinates = scanner.nextLine().split("\\s+");
        int startCol = 0;

        while (!coordinates[0].toLowerCase().equals("stop")) {
            int startRow = Integer.parseInt(coordinates[0]);
            int endRow = Integer.parseInt(coordinates[1]);
            int endCol = Integer.parseInt(coordinates[2]);
            int freeCol;

            if (!isRowAvailable(parkingLot, endRow)) {
                System.out.println("Row " + endRow + " full");
                coordinates = scanner.nextLine().split("\\s+");
                continue;
            }

            int distanceLeft = Math.abs(parkingLot[endRow].length - isLeftAvailable(parkingLot, endRow, endCol));
            int distanceRight = Math.abs(parkingLot[endRow].length - isRightAvailable(parkingLot, endRow, endCol));

            if (!parkingLot[endRow][endCol]) {
                freeCol = endCol;
            } else if (isLeft(parkingLot, endRow, endCol)
                    && !isRight(parkingLot, endRow, endCol)) {
                freeCol = isLeftAvailable(parkingLot, endRow, endCol);
            } else if (!isLeft(parkingLot, endRow, endCol)
                    && isRight(parkingLot, endRow, endCol)) {
                freeCol = isRightAvailable(parkingLot, endRow, endCol);
            } else if (distanceRight <= distanceLeft) {
                freeCol = isLeftAvailable(parkingLot, endRow, endCol);
            } else {
                freeCol = isRightAvailable(parkingLot, endRow, endCol);
            }

            parkingLot[endRow][freeCol] = true;
            int testX = Math.abs(startRow - endRow) + 1;
            int testY = Math.abs(freeCol - startCol);
            System.out.println(testX + testY);

            coordinates = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean isRowAvailable(boolean[][] parkingLot, int row) {
        boolean isEmpty = false;
        for (int col = 1; col < parkingLot[row].length; col++) {
            if (!parkingLot[row][col]) {
                isEmpty = true;
            }
        }

        return isEmpty;
    }

    private static boolean isLeft(boolean[][] parkingLot, int row, int col) {
        boolean isLeft = false;
        for (int i = col - 1; i >= 1; i--) {
            if (!parkingLot[row][i]) {
                isLeft = true;
                break;
            }
        }

        return isLeft;
    }

    private static boolean isRight(boolean[][] parkingLot, int row, int col) {
        boolean isLeft = false;
        for (int i = col + 1; i < parkingLot[row].length; i++) {
            if (!parkingLot[row][i]) {
                isLeft = true;
                break;
            }
        }

        return isLeft;
    }

    private static int isLeftAvailable(boolean[][] parkingLot, int row, int col) {
        int emptyPosition = -1;
        for (int i = col - 1; i >= 1; i--) {
            if (!parkingLot[row][i]) {
                emptyPosition = i;
                break;
            }
        }

        return emptyPosition;
    }

    private static int isRightAvailable(boolean[][] parkingLot, int row, int col) {
        int emptyPosition = -1;
        for (int i = col + 1; i < parkingLot[row].length; i++) {
            if (!parkingLot[row][i]) {
                emptyPosition = i;
                break;
            }
        }

        return emptyPosition;
    }
}
