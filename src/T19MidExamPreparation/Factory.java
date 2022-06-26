package T19MidExamPreparation;

import java.util.Scanner;

public class Factory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int amountOfBiscuitsPerWorkerPerDay = Integer.parseInt(scan.nextLine());
        int workersCount = Integer.parseInt(scan.nextLine());
        int amountOfBiscuitsOfCompetingFactory = Integer.parseInt(scan.nextLine());

        int productionPerDay = amountOfBiscuitsPerWorkerPerDay * workersCount;
        int totalProduction = 0;
        for (int i = 1; i <= 30; i++) {
            totalProduction += productionPerDay;
            if(i % 3 == 0){
                productionPerDay = productionPerDay / 75 * 100;
            }
        }
    }
}
