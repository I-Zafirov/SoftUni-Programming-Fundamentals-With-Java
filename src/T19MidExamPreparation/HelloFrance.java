package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloFrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        double budget = Double.parseDouble(scanner.nextLine());

        String[] itemAndPrice = line.split("\\|");

        double profit = 0.00;
        List<Double> prices = new ArrayList<>();

        for (int i = 0; i < itemAndPrice.length; i++) {
            String[] tokens = itemAndPrice[i].split("->");
            String item = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            double maxPrice = 0.0;

            switch (item){
                case "Clothes":
                    maxPrice = 50.00;
                    break;
                case "Shoes":
                    maxPrice = 35.00;
                    break;
                case "Accessories":
                    maxPrice = 20.50;
                    break;
            }

            if (price <= maxPrice && price <= budget){
                budget -= price;
                profit += price * 0.4;
                prices.add(price * 1.4);
            }
        }

        for (Double price : prices) {
            budget += price;
        }

        for (Double price : prices) {
            System.out.printf("%.2f ", price);
        }
        System.out.println();

        System.out.printf("Profit: %.2f%n", profit);

        if (budget >= 150){
            System.out.println("Hello, France!");
        }else{
            System.out.println("Time to go.");
        }
    }
}
