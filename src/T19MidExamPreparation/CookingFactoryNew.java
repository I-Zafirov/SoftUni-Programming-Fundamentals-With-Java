package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CookingFactoryNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> batches = new ArrayList<>();

        String input = "";

        while (!"Bake It!".equals(input = scanner.nextLine())){

            List<String> breadGrades = Arrays.stream(input.split("#")).collect(Collectors.toList());

            int batchQuality = 0;
            for (int i = 0; i < breadGrades.size(); i++) {
                batchQuality += Integer.parseInt(breadGrades.get(i));
            }

            double batchAverageQuality = (double)batchQuality / breadGrades.size();

            breadGrades.add(0,Integer.toString(batchQuality));
            breadGrades.add(1,Double.toString(batchAverageQuality));
            breadGrades.add(2,Integer.toString(breadGrades.size()));

            batches.add(breadGrades.toString().replaceAll("[\\[\\]]",""));

        }

        int bestQuality = Integer.MIN_VALUE;
        double bestAverageQuality = Double.MAX_VALUE * -1;
        int bestMinimumLenght = Integer.MAX_VALUE;
        String bestQualityBread = "";

        for (int i = 0; i < batches.size(); i++) {
            String breadGrades = batches.get(i);

            List <String> breadGradesList = Arrays.stream(breadGrades.split(",")).collect(Collectors.toList());

            // index 0 - batch quality
            // index 1 - batch average quality
            // index 2 - batch length

            String breadGradesString = "";
            for (int j = 3; j < breadGradesList.size(); j++) {
                breadGradesString += breadGradesList.get(j);
            }

            int currentQuality = Integer.parseInt(breadGradesList.get(0).trim());
            double currentAverageQuality = Double.parseDouble(breadGradesList.get(1).trim());
            int currentMinimumLength = Integer.parseInt(breadGradesList.get(2).trim());

            if (currentQuality > bestQuality) {
                bestQuality = currentQuality;
                bestAverageQuality = currentAverageQuality;
                bestMinimumLenght = currentMinimumLength;
                bestQualityBread = breadGradesString;
            } else if (currentQuality == bestQuality) {
                if (currentAverageQuality > bestAverageQuality) {
                    bestAverageQuality = currentAverageQuality;
                    bestMinimumLenght = currentMinimumLength;
                    bestQualityBread = breadGradesString;
                } else if (currentAverageQuality == bestAverageQuality) {
                    if (currentMinimumLength < bestMinimumLenght){
                        bestMinimumLenght = currentMinimumLength;
                        bestQualityBread = breadGradesString;
                    }
                }
            }
        }

        System.out.printf("Best Batch quality: %d%n%s",bestQuality, bestQualityBread.trim());
    }
}
