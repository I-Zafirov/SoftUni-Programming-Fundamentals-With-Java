package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String arrayAsString = scan.nextLine();
        int[] numbers = Arrays.stream(arrayAsString.split("@"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String input = scan.nextLine();
        int santaIndex = 0;

        while(!input.equals("Merry Xmas!")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int index = Integer.parseInt(tokens[1]);
            if(command.equals("Jump")){
                if(santaIndex + index >= numbers.length){
                    santaIndex = 0;
                }else {
                    santaIndex += index;
                }

                if(numbers[santaIndex] == 0){
                    System.out.printf("House %d will have a Merry Christmas.%n",santaIndex);
                }else{
                    numbers[santaIndex] -= 2;
                }

            }
            input = scan.nextLine();
        }
        int failedHouses = 0;

        for (int number : numbers) {
            if (number != 0) {
                failedHouses++;
            }
        }
        System.out.printf("Santa's last position was %d.%n",santaIndex);
        if(failedHouses > 0){
            System.out.printf("Santa has failed %d houses.",failedHouses);
        }else {
            System.out.println("Mission was successful.");
        }
    }
}
