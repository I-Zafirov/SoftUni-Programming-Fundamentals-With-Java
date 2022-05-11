package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class CookingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        int bestQuality = 0;
        int bestQualityBreadCounter = 0;


        while ("Bake it!".equals(input = scanner.nextLine())){
            int[] breadGrades = Arrays.stream(input.split("#"))
                    .mapToInt(Integer::parseInt).toArray();

            int currentQuality = 0;
            for (int i = 0; i < breadGrades.length; i++) {
                currentQuality += breadGrades[i];
            }

            /*if (currentQuality >= bestQuality) {
                bestQualityBreadCounter++;
                if (bestQualityBreadCounter <= 1) {
                    bestQuality = currentQuality;
                    int bestQualityBreadArray[] = new int[breadGrades.length];
                    for (int i = 0; i < bestQualityBreadArray.length; i++) {
                        bestQualityBreadArray[i] = breadGrades[i];
                    }
                }
            }*/

            if (input.equals("Bake it!")) {
                System.out.printf("Best Batch quality: %d",bestQuality);
                //System.out.println(bestQualityBreadArray);
            }
        }
    }
}
