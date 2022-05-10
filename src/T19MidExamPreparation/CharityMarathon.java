package T19MidExamPreparation;

import java.util.Scanner;

public class CharityMarathon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int days = Integer.parseInt(input.nextLine());
        long runners = Long.parseLong(input.nextLine());
        int averageNumberOfLaps = Integer.parseInt(input.nextLine());
        long lengthOfTheRunway = Long.parseLong(input.nextLine());
        int capacityOfTheRunway = Integer.parseInt(input.nextLine());
        double moneyPerKilometer = Double.parseDouble(input.nextLine());

        double totalKilometers, totalMoney;

        if(capacityOfTheRunway * days < runners){
            totalKilometers = (capacityOfTheRunway * days * averageNumberOfLaps * lengthOfTheRunway) / 1000.0;
        }
        else{
            totalKilometers = (runners * averageNumberOfLaps * lengthOfTheRunway) / 1000.0;
        }

        totalMoney = totalKilometers * moneyPerKilometer;
        System.out.printf("Money raised: %.2f", totalMoney);
    }
}

