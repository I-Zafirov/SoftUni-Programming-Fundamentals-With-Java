package T19MidExamPreparation;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        double priceOfFuelPerKilometer = Double.parseDouble(scanner.nextLine());
        double foodExpensesPerPersonPerDay = Double.parseDouble(scanner.nextLine());
        double priceForRoomPerNightPerPerson = Double.parseDouble(scanner.nextLine());

        double totalNightsExpenses = days * numberOfPeople * priceForRoomPerNightPerPerson;
        if (numberOfPeople > 10)
        {
            priceForRoomPerNightPerPerson *= 0.75;
        }
        double totalExpenses = days * numberOfPeople * (foodExpensesPerPersonPerDay + priceForRoomPerNightPerPerson);

        //double totalFoodExpenses = numberOfPeople * days * foodExpensesPerPersonPerDay;
        double dailyTransportExpenses = 0;
        //double totalExpenses = totalFoodExpenses + totalNightsExpenses;
        for (int day = 1; day <= days; day++) {
            double dailyKilometers = Double.parseDouble(scanner.nextLine());
            dailyTransportExpenses = dailyKilometers * priceOfFuelPerKilometer;
            totalExpenses += dailyTransportExpenses;
            if (day % 3 == 0 || day % 5 == 0){
                totalExpenses += totalExpenses * 0.4;
            } else if (day % 7 == 0){
                totalExpenses -= totalExpenses/numberOfPeople;
            }
        }
        if (totalExpenses > budget){
            double neededMoney = totalExpenses - budget;
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", neededMoney);
        } else if (totalExpenses <= budget){
            double moneyLeft = budget - totalExpenses;
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", moneyLeft);
        }
    }
}
