package T19MidExamPreparation;

import java.util.Scanner;

public class DistanceCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int stepsMade=Integer.parseInt(scanner.nextLine());
        double theLengthOf1Step=Double.parseDouble(scanner.nextLine());
        int distanceInMeters=Integer.parseInt(scanner.nextLine());
        int distanceInSantemeters=distanceInMeters*100;

        int shorterSteps=stepsMade/5;
        double lengthOfShorterStep=theLengthOf1Step-theLengthOf1Step*0.3;
        double normalSteps=stepsMade-shorterSteps;
        double totalStepsLength=(normalSteps*theLengthOf1Step)+((shorterSteps*1.0)*lengthOfShorterStep);

        double perCent=(totalStepsLength/distanceInSantemeters)*100;

        System.out.printf("You travelled %.2f",perCent);
        System.out.print("% of the distance!");
    }
}
