package T19MidExamPreparation;

import java.util.Scanner;

public class BreadFactory2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = 100;
        int coins = 100;
        String[] array = (scanner.nextLine()
                .split("\\|"));
        boolean fail=true;
        for (int i = 0; i < array.length; i++) {
            String[] tokens = array[i].split("-");
            String event = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            if (event.equals("rest")) {
                if (energy + value > 100) {
                    value = 100 - energy;
                }
                energy += value;
                System.out.printf("You gained %d energy.%n", value);
                System.out.printf("Current energy: %d.%n", energy);
            } else if (event.equals("order")) {
                if (energy < 30) {
                    System.out.printf("You had to rest!%n");
                    energy = energy + 50;

                } else {
                    coins += value;
                    energy -= 30;
                    System.out.printf("You earned %d coins.%n", value);
                }
            } else {
                if (coins <= value) {
                    System.out.printf("Closed! Cannot afford %s.%n", event);
                    fail=false;
                    break;
                } else {
                    System.out.printf("You bought %s.%n", event);
                    coins -= value;
                }
            }
        }
        if(fail){
            System.out.println("Day completed!");
            System.out.println("Coins: "+coins);
            System.out.println("Energy: "+energy);
        }

    }
}
