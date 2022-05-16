package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int coins = 0;

        List<String> input = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        for (int i = 0; i < input.size(); i++) {
            String[] data = input.get(i).split("\\s+");

            String command = data[0];
            int value = Integer.parseInt(data[1]);

            switch (command) {
                case "potion":
                    int potion = value;
                    if (health + potion > 100) {
                        System.out.printf("You healed for %d hp.%n",Math.abs(health - 100));
                        health = 100;
                        System.out.printf("Current health: %d hp.%n",health);
                    } else {
                        health += potion;
                        System.out.printf("You healed for %d hp.%n", potion);
                        System.out.printf("Current health: %d hp.%n",health);
                    }
                    break;
                case "chest":
                    int coinsToAdd = value;
                    coins += coinsToAdd;
                    System.out.printf("You found %d coins.%n",coinsToAdd);
                    break;
                default:
                    String monster = command;
                    int attackDamage = value;

                    health -= attackDamage;

                    if (!(health <= 0)) {
                        System.out.printf("You slayed %s.%n",monster);
                    } else {
                        System.out.printf("You died! Killed by %s.%nBest room: %d",monster, i+1);
                        return;
                    }
                    break;
            }
        }

        System.out.printf("You've made it!\nCoins: %d\nHealth: %d",coins,health);
    }
}
