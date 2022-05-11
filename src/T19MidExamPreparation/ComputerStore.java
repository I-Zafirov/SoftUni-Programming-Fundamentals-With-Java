package T19MidExamPreparation;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        double totalPrice = 0;
        double vatTax = 0;
        double totalPriceVAT = 0;

        while(!(input.equals("regular") || input.equals("special"))){
            double currentPrice = Double.parseDouble(input);
            if (currentPrice >= 0 ){
                totalPrice += currentPrice;
            }else{
                System.out.println("Invalid price!");
            }

            input = scanner.nextLine();
        }
        vatTax += totalPrice * 0.2;
        totalPriceVAT = totalPrice + vatTax;
        if (input.equals("special")){
            totalPriceVAT *= 0.90;
        }
        if (totalPrice > 0){
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPrice);
            System.out.printf("Taxes: %.2f$%n", vatTax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPriceVAT);
        }else{
            System.out.println("Invalid order!");
        }
    }
}
