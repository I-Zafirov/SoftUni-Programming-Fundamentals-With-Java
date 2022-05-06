package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ArcheryTournament {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] numbers = Arrays
            .stream(scanner.nextLine().split("\\|"))
            .mapToInt(e -> Integer.parseInt(e))
            .toArray();

    int points = 0;
        while (true){
        String input = scanner.nextLine();
        if (input.equals("Game over")){
            break;
        }

        String[] instructions = input.split("@");

        String command = instructions[0];

        switch (command){
            case "Shoot Left":

                points = shootLeft(numbers, instructions, points);

                break;
            case "Shoot Right":

                points =  shootRight(numbers, instructions, points);

                break;
            case "Reverse":
                reverseArray(numbers);
                break;
        }
    }

        for (int i = 0; i < numbers.length; i++) {
        System.out.print(numbers[i]);
        if (i < numbers.length - 1){
            System.out.print(" - ");
        }
    }
        System.out.printf("%nIskren finished the archery tournament with %d points!", points);
}

    private static int shootRight(int[] numbers, String[] instructions, int points) {
        int startIndexRight = Integer.parseInt(instructions[1]);
        int lengthRight = Integer.parseInt(instructions[2]);
        if (startIndexRight >= 0 && startIndexRight < numbers.length) {
            startIndexRight += lengthRight;
            if (startIndexRight >= numbers.length) {
                startIndexRight %= numbers.length;
            }

            if (numbers[startIndexRight] >= 5) {
                numbers[startIndexRight] -= 5;
                points += 5;
            } else {
                points += numbers[startIndexRight];
                numbers[startIndexRight] = 0;
            }
        }
        return points;
    }

    private static int shootLeft(int[] numbers, String[] instructions, int points) {
        int startIndexLeft = Integer.parseInt(instructions[1]);
        int lengthLeft = Integer.parseInt(instructions[2]);
        if (startIndexLeft >= 0 && startIndexLeft < numbers.length){
            startIndexLeft -= lengthLeft;
            if (startIndexLeft < 0){
                startIndexLeft = numbers.length - (Math.abs(startIndexLeft) % numbers.length);
            }

            if (numbers[startIndexLeft] >= 5) {
                numbers[startIndexLeft] -= 5;
                points += 5;
            } else {
                points += numbers[startIndexLeft];
                numbers[startIndexLeft] = 0;
            }
        }
        return points;
    }


    private static void reverseArray(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int swap = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = swap;
        }
    }
}
