package T19MidExamPreparation;

import java.util.Scanner;

public class Bakery2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int workerBiscuits = scan.nextInt();
        int workers = scan.nextInt();
        int productionCompetingFactory = scan.nextInt();
        scan.close();

        int productionFactory = 0;
        int dayBiscuits = workerBiscuits * workers;
        int day = 1;
        while (day < 31) {
            if ((day % 3) == 0) {
                productionFactory +=  Math.floor(dayBiscuits * 0.75);
            }else {
                productionFactory += dayBiscuits;
            }
            day++;
        }
        System.out.printf("You have produced %d biscuits for the past month.\n", productionFactory);

        double productionDifference = productionFactory - productionCompetingFactory;
        if (productionDifference > 0) {
            System.out.printf("You produce %.2f percent more biscuits.", (Math.abs(productionDifference) / productionCompetingFactory) * 100);
        }else {
            System.out.printf("You produce %.2f percent less biscuits.", (Math.abs(productionDifference) / productionCompetingFactory) * 100);
        }
    }
}
