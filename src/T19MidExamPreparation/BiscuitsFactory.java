package T19MidExamPreparation;

import java.util.Scanner;

public class BiscuitsFactory {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int norm = Integer.parseInt(input.nextLine());
        int workers = Integer.parseInt(input.nextLine());
        double competitor = Double.parseDouble(input.nextLine());

        double productionPerMonth = norm * workers * 20.0 + Math.floor(norm * workers * 0.75) * 10.0;
        double difference = productionPerMonth / competitor;

        System.out.printf("You have produced %.0f biscuits for the past month.%n", productionPerMonth);

        if(difference > 1){
            System.out.printf("You produce %.2f percent more biscuits.", (difference - 1) * 100.0);
        }
        else{
            System.out.printf("You produce %.2f percent less biscuits.", (1 - difference) * 100.0);
        }
    }
}

