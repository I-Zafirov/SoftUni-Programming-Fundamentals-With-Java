package T33FinExamPreparation;

import java.util.Scanner;

public class TinySporebat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int health = 5800;
        int glowcaps = 0;
        boolean dead = false;
        while (!input.equals("Sporeggar")) {
            for (int i = 0; i < input.length() - 1 && !dead; i++) {
                if (input.charAt(i) != 'L') {
                    health -= input.charAt(i);
                    if (health < 1) {
                        dead = true;
                    }
                } else {
                    health += 200;
                }
            }
            if (dead) {
                break;
            }
            glowcaps += input.charAt(input.length() - 1) - 48;

            input = sc.nextLine();
        }

        if (dead) {
            System.out.println("Died. Glowcaps: " + glowcaps);
        } else {
            System.out.println("Health left: " + health);
            if (glowcaps - 30 >= 0) {
                System.out.println("Bought the sporebat. Glowcaps left: " + (glowcaps - 30));
            } else {
                System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.%n", 30 - glowcaps);
            }
        }


    }
}
