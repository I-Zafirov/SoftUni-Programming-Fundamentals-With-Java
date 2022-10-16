package T33FinExamPreparation;

import java.util.Scanner;

public class GiftBoxCoverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double side = Double.parseDouble(scanner.nextLine());
        int nuberOfSheet = Integer.parseInt(scanner.nextLine());
        double areaSheet = Double.parseDouble(scanner.nextLine());
        double area = side * side * 6;
        int trirdSheet = nuberOfSheet / 3;
        int rest = nuberOfSheet % 3;
        double totalArea = (trirdSheet * 2 + rest) * areaSheet + (trirdSheet) * areaSheet * 0.25;
        double percent = totalArea / area * 100;
        System.out.printf("You can cover %.2f%% of the box.", percent);
    }
}
