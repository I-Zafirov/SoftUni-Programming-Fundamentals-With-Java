package T19MidExamPreparation;

import java.util.Scanner;

public class VacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        double priceOfFuelPerKilometer = Double.parseDouble(scanner.nextLine());
        double foodExpensesPerPersonPerDay = Double.parseDouble(scanner.nextLine());
        double priceForRoomPerNightPerPerson = Double.parseDouble(scanner.nextLine());

        if (numberOfPeople > 10) {
            priceForRoomPerNightPerPerson *= 0.75;
        }
        double expenses = days * numberOfPeople * (foodExpensesPerPersonPerDay + priceForRoomPerNightPerPerson);

        for (int i = 1; i <= days; i++) {
            double dailyKilometers = Double.parseDouble(scanner.nextLine());
            expenses += dailyKilometers * priceOfFuelPerKilometer;

            if (i % 3 == 0 || i % 5 == 0) {
                expenses *= 1.4;
            }
            if (i % 7 == 0) {
                expenses -= expenses / numberOfPeople;
            }
        }
        if (expenses > budget) {
            double neededMoney = expenses - budget;
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", neededMoney);
        } else if (budget > expenses){
            double moneyLeft = budget - expenses;
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", moneyLeft);
        }
    }
}
