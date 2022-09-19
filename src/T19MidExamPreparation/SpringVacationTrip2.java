package T19MidExamPreparation;

import java.util.Scanner;

public class SpringVacationTrip2 {
    static boolean overBudget(double money,double budget){
        if(money>budget){
            return true;
        }
        return  false;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int days=Integer.parseInt(scanner.nextLine());
        double budget=Double.parseDouble(scanner.nextLine());
        int countOfPeople=Integer.parseInt(scanner.nextLine());
        double priceFuelPerKilometer=Double.parseDouble(scanner.nextLine());
        double foodExpensePerPerson=Double.parseDouble(scanner.nextLine());
        double priceRoomPerPerson=Double.parseDouble(scanner.nextLine());

        double totalPriceForRooms=priceRoomPerPerson*days*countOfPeople;
        double totalFood=foodExpensePerPerson*days*countOfPeople;
        if(countOfPeople>10){
            totalPriceForRooms=totalPriceForRooms-totalPriceForRooms*0.25;
        }
        double currentExpense=totalPriceForRooms+totalFood;


        for(int day=1; day<=days;day++){
            double travelledDistance=Double.parseDouble(scanner.nextLine());
            double currentFuel=travelledDistance*priceFuelPerKilometer;
            currentExpense+=currentFuel;
            if(overBudget(currentExpense,budget)){
                break;
            }
            if(day%3==0 || day%5==0){
                currentExpense=currentExpense+currentExpense*0.4;
                if(overBudget(currentExpense,budget)){
                    break;
                }
            }
            if(day%7==0){
                currentExpense=currentExpense-currentExpense/countOfPeople;
                if(overBudget(currentExpense,budget)){
                    break;
                }
            }

        }

        if(currentExpense>budget){
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.",currentExpense-budget);
        } else {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.",budget-currentExpense);
        }


    }
}
