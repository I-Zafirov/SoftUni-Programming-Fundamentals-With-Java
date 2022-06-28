package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] houses = Arrays
                .stream(scanner.nextLine().split("@"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int houseIndex = 0;
        while (true){
            String input = scanner.nextLine();
            if ("Love!".equals(input)){
                break;
            }
            String[]tokens = input.split(" ");

            int length = Integer.parseInt(tokens[1]);
            if (houseIndex + length > houses.length - 1){
                houseIndex = 0;
            }else{
                houseIndex += length;
            }

            if (houses[houseIndex] == 0){
                System.out.printf("Place %d already had Valentine's day.%n", houseIndex);
            }else{
                houses[houseIndex] -= 2;
                if (houses[houseIndex] == 0){
                    System.out.printf("Place %d has Valentine's day.%n", houseIndex);
                }
            }
        }

        System.out.printf("Cupid's last position was %d.%n", houseIndex);
        int count = 0;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == 0){
                count++;
            }
        }

        if (houses.length - count == 0){
            System.out.println("Mission was successful.");
        }else{
            System.out.printf("Cupid has failed %d places.%n", houses.length - count);
        }
    }
}
