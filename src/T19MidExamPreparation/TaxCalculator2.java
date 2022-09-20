package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaxCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> vehicles = Arrays.stream(scanner.nextLine().split(">>"))
                .collect(Collectors.toList());
        double totalTax = 0.0;

        for (int i = 0; i < vehicles.size(); i++) {
            List<String> input = Arrays.stream(vehicles.get(i).split(" "))
                    .collect(Collectors.toList());

            String carType = input.get(0);

            switch (carType) {

                case "family":
                    int taxedYears = Integer.parseInt(input.get(1));
                    int traveledKilometers = Integer.parseInt(input.get(2));
                    int initialTax = 50;
                    int taxCounter = initialTax - (taxedYears * 5);
                    double priceKm = Math.floor(traveledKilometers * 1.0 / 3000) * 12;
                    double taxes = taxCounter + priceKm;
                    totalTax += taxes;
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, taxes);
                    break;

                case "heavyDuty":
                    taxedYears = Integer.parseInt(input.get(1));
                    traveledKilometers = Integer.parseInt(input.get(2));
                    initialTax = 80;
                    taxCounter = initialTax - (taxedYears * 8);
                    priceKm = Math.floor(traveledKilometers * 1.0 / 9000) * 14;
                    taxes = taxCounter + priceKm;
                    totalTax += taxes;
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, taxes);
                    break;

                case "sports":
                    taxedYears = Integer.parseInt(input.get(1));
                    traveledKilometers = Integer.parseInt(input.get(2));
                    initialTax = 100;
                    taxCounter = initialTax - (taxedYears * 9);
                    priceKm = Math.floor(traveledKilometers * 1.0 / 2000) * 18;
                    taxes = taxCounter + priceKm;
                    totalTax += taxes;
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, taxes);
                    break;

                default:
                    System.out.println("Invalid car type.");
                    break;
            }
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.%n", totalTax);
    }
}






