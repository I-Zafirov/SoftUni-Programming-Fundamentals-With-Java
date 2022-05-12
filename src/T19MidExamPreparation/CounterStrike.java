package T19MidExamPreparation;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int wonBattles = 0;
        boolean hasEnergy = true;

        while (true){
            String input = scanner.nextLine();
            if ("End of battle".equals(input)){
                break;
            }
            int distance = Integer.parseInt(input);

            if (energy >= distance){
                energy -= distance;
                wonBattles++;
            }else{
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",
                        wonBattles, energy);
                hasEnergy = false;
                break;
            }

            if (wonBattles % 3 == 0){
                energy += wonBattles;
            }
        }
        if (hasEnergy){
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, energy);
        }
    }
}
