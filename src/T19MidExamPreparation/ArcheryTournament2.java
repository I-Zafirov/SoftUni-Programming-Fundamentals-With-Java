package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ArcheryTournament2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targetNumbers = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int sumPoints = 0;
        while (true){
            String input = scanner.nextLine();
            if (input.equals("Game over")){
                break;
            }
            String[] tokens = input.split("@");
            String command = tokens[0];

            switch (command){
                case "Shoot Left":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int leftLength = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < targetNumbers.length){
                        int targetIndex = startIndex - leftLength;
                        if (targetIndex < 0){
                            targetIndex = targetNumbers.length - (Math.abs(targetIndex) % targetNumbers.length);
                        }
//                        while (targetIndex < 0 ){
//                           targetIndex = targetNumbers.length + targetIndex;
//                        }
                        if (targetNumbers[targetIndex] >= 5){
                            targetNumbers[targetIndex] -= 5;
                            sumPoints += 5;
                        }else{
                            sumPoints += targetNumbers[targetIndex];
                            targetNumbers[targetIndex] = 0;
                        }
                    }
                    break;
                case "Shoot Right":
                    startIndex = Integer.parseInt(tokens[1]);
                    int rightLength = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < targetNumbers.length){
                        int targetIndex = startIndex + rightLength;
                        if (targetIndex >= targetNumbers.length){
                            targetIndex = targetIndex % targetNumbers.length;
                        }
//                        while (targetIndex >= targetNumbers.length){
//                            targetIndex = targetIndex - targetNumbers.length;
//                        }
                        if (targetNumbers[targetIndex] >= 5){
                            targetNumbers[targetIndex] -= 5;
                            sumPoints += 5;
                        }else{
                            sumPoints += targetNumbers[targetIndex];
                            targetNumbers[targetIndex] = 0;
                        }
                    }
                    break;
                case "Reverse":
                    for (int i = 0; i < targetNumbers.length / 2; i++) {
                        int swap = targetNumbers[i];
                        targetNumbers[i] = targetNumbers[targetNumbers.length - i - 1];
                        targetNumbers[targetNumbers.length - i - 1] = swap;
                    }
                    break;
            }
        }

        for (int i = 0; i < targetNumbers.length; i++) {
            System.out.print(targetNumbers[i]);
            if (i < targetNumbers.length -1){
                System.out.print(" - ");
            }
        }
        System.out.printf("%nIskren finished the archery tournament with %d points!", sumPoints);
    }
}
