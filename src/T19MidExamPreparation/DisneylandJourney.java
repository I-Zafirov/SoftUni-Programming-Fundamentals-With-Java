package T19MidExamPreparation;

import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double costsOfTheJourney = scanner.nextDouble();
        int months = scanner.nextInt();

        double savings = 0.0;

        for (int i = 1; i <= months; i++) {
            if (i % 2 != 0 && i != 1){
                savings *= 0.84;
            }
            if (i % 4 == 0){
                savings *= 1.25;
            }
            savings += costsOfTheJourney * 0.25;
        }
        if (savings >= costsOfTheJourney){
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.",
                    savings - costsOfTheJourney);
        }else{
            System.out.printf("Sorry. You need %.2flv. more.", costsOfTheJourney - savings);
        }
    }
}
