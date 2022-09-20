package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> vehicles = Arrays.stream(scanner.nextLine().split(">>"))
                .collect(Collectors.toList());
        double totalTax = 0;

        for (int i = 0; i < vehicles.size(); i++) {
            List<String> input = Arrays.stream(vehicles.get(i).split(" "))
                    .collect(Collectors.toList());

            String carType = input.get(0);

            if (carType.equals("family")) {
                int age = Integer.parseInt(input.get(1));
                int kilometers = Integer.parseInt(input.get(2));
                int tax = 50;
                int countTax = tax - (age * 5);
                double priceKm = Math.floor(kilometers * 1.0 / 3000) * 12;
                double taxes = countTax + priceKm;
                totalTax += taxes;
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, taxes);

            } else if (carType.equals("heavyDuty")) {
                int age = Integer.parseInt(input.get(1));
                int kilometers = Integer.parseInt(input.get(2));
                int tax = 80;
                int countTax = tax - (age * 8);
                double priceKm = Math.floor(kilometers * 1.0 / 9000) * 14;
                double taxes = countTax + priceKm;
                totalTax += taxes;
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, taxes);

            } else if (carType.equals("sports")) {
                int age = Integer.parseInt(input.get(1));
                int kilometers = Integer.parseInt(input.get(2));
                int tax = 100;
                int countTax = tax - (age * 9);
                double priceKm = Math.floor(kilometers * 1.0 / 2000) * 18;
                double taxes = countTax + priceKm;
                totalTax += taxes;
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, taxes);

            } else {
                System.out.println("Invalid car type.");
            }
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.%n", totalTax);
    }
}

