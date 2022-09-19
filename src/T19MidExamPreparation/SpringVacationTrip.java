package T19MidExamPreparation;

import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = scanner.nextInt();
        double budget = scanner.nextDouble();
        int people = scanner.nextInt();
        double fuelPerKm = scanner.nextDouble();
        double foodExpensesPerPersonPerDay = scanner.nextDouble();
        double roomPricePerPersonPerNight = scanner.nextDouble();

        double foodExpenses = days * people * foodExpensesPerPersonPerDay;
        double hotelExpenses = days * people * roomPricePerPersonPerNight;
        if (people > 10){
            hotelExpenses *= 0.75;
        }
        double currentExpenses = foodExpenses + hotelExpenses;

        for (int i = 1; i <= days; i++) {
            double travelledDistanceKmPerDay = scanner.nextDouble();
            double consumedFuel = travelledDistanceKmPerDay * fuelPerKm;
            currentExpenses += consumedFuel;

            if (i % 3 == 0 || i % 5 == 0){
                //additional expenses, which are 40% of the currentExpenses
                currentExpenses *= 1.4;
            }

            if (i % 7 == 0){
                //expenses are reduced by dividing currentExpenses by people
                currentExpenses -= currentExpenses / people;
            }
            if (currentExpenses > budget){
                double neededMoney = currentExpenses - budget;
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", neededMoney);
                return;
            }
        }

        budget -= currentExpenses;
        System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget);
    }
}
