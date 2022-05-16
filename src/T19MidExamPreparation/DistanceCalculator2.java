package T19MidExamPreparation;

import java.util.Scanner;

public class DistanceCalculator2 {
    public static void main(String[] args){
        Scanner cunningNonsense = new Scanner(System.in);

        int steps = Integer.parseInt(cunningNonsense.nextLine());
        double oneStepInCentimeters = Double.parseDouble(cunningNonsense.nextLine());
        int distanceInMeters = Integer.parseInt(cunningNonsense.nextLine());

        double distanceInCentimeters = distanceInMeters * 100.0;

        int current = steps / 5;

        double walkedDistance = (steps - current) * oneStepInCentimeters + current * oneStepInCentimeters * 0.7;

        double travelledDistanceInPercentage = walkedDistance / distanceInCentimeters * 100.0;

        System.out.printf("You travelled %.2f%% of the distance!", travelledDistanceInPercentage);
    }
}
