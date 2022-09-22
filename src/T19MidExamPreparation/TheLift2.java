package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int[]wagon = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int emptySpots = 0;
        for (int i = 0; i < wagon.length; i++) {
            emptySpots = 4 - wagon[i];
            if (people >= emptySpots && emptySpots <= 4){
                wagon[i] += emptySpots;
                people -= emptySpots;
                emptySpots = 0;
            }else{
                wagon[i] -= people;
                emptySpots -= people;
                people = 0;
            }
        }
        String[] wagonAsString = new String[wagon.length];
        for (int i = 0; i < wagon.length; i++) {
            wagonAsString[i] = String.valueOf(wagon[i]);
        }
        if (people == 0){
            if (emptySpots == 0){
                System.out.printf(String.join(" ", wagonAsString));
            }else{
                System.out.println("The lift has empty spots!");
                System.out.printf(String.join(" ", wagonAsString));
            }
        }else{
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            System.out.printf(String.join(" ", wagonAsString));
        }
    }
}
