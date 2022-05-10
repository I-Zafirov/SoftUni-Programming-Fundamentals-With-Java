package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BreadFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = 100;
        int coins = 100;

        List<String> events = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());


        for (int i = 0; i < events.size(); i++) {
            String[] eventArray = events.get(i).split("-");
            String event = eventArray[0].trim();

            switch (event) {
                case "rest":
                    int energyGain = Integer.parseInt(eventArray[1].trim());

                    if (energy + energyGain >= 100) {
                        energy = 100;
                        System.out.printf("You gained 0 energy.%n");
                    } else {
                        energy = energy + energyGain;
                        System.out.printf("You gained %d energy.%n",energyGain);
                    }

                    System.out.printf("Current energy: %d.%n",energy);

                    break;
                case "order":
                    int coinsGain = Integer.parseInt(eventArray[1].trim());

                    if (energy - 30 >= 0) {
                        energy = energy - 30;
                        coins = coins + coinsGain;
                        System.out.printf("You earned %d coins.%n",coinsGain);
                    } else {
                        energy = energy + 50;
                        System.out.printf("You had to rest!%n");
                    }

                    break;
                default:
                    String ingredient = eventArray[0];
                    int ingredientCost = Integer.parseInt(eventArray[1].trim());

                    if (coins - ingredientCost  > 0) {
                        coins = coins - ingredientCost;
                        System.out.printf("You bought %s.%n",ingredient);
                    } else {
                        coins = 0;
                        System.out.printf("Closed! Cannot afford %s.",ingredient);
                        return;
                    }

                    break;
            }
        }

        System.out.printf("Day completed!%nCoins: %d%nEnergy: %d",coins,energy);
    }
}
