package T33FinExamPreparation;

import java.util.Scanner;

public class ParkingSystem2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        byte[][] parkingLot = new byte[r][c];
        sc.nextLine();

        String[] line = sc.nextLine().split(" ");

        while (!line[0].equals("stop")) {
            int startRow = Integer.parseInt(line[0]);
            int row = Integer.parseInt(line[1]);
            int col = Integer.parseInt(line[2]);
            int freeSpot = 1;
            if (parkingLot[row][col] == 0) {
                parkingLot[row][col] = 1;
                System.out.println(1 + Math.abs(startRow - row) + col);
            } else {
                freeSpot = checkRow(row, col, parkingLot);

                if (freeSpot == -1) {
                    System.out.printf("Row %d full%n", row);
                } else {
                    parkingLot[row][freeSpot] = 1;
                    System.out.println(1 + Math.abs(startRow - row) + freeSpot);
                }
            }
            line = sc.nextLine().split(" ");
        }

    }

    private static int checkRow(int row, int col, byte[][] parkingLot) {
        int disanceFromCol = 1;
        while (col - disanceFromCol > 0 || col + disanceFromCol < parkingLot[row].length) {
            if (col - disanceFromCol > 0) {
                if (parkingLot[row][col - disanceFromCol] == 0) {
                    return col - disanceFromCol;
                }
            }
            if (col + disanceFromCol < parkingLot[row].length) {
                if (parkingLot[row][col + disanceFromCol] == 0) {
                    return col + disanceFromCol;
                }
            }
            disanceFromCol++;
        }
        return -1;
    }
}
