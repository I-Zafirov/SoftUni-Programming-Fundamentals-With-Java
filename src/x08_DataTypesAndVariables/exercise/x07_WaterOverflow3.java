package x08_DataTypesAndVariables.exercise;

import java.util.Scanner;

public class x07_WaterOverflow3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nLines = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int sumQuantityOfWater = 0;

        for (int i = 1; i < nLines; i++) {
            int quantityOfWater = Integer.parseInt(scanner.nextLine());
            sumQuantityOfWater += quantityOfWater;

            if (sumQuantityOfWater + capacity <= 255) {
                System.out.println("Insufficient capacity!");
                sumQuantityOfWater -= quantityOfWater;
            }
        }
        System.out.println(sumQuantityOfWater);
    }
}
