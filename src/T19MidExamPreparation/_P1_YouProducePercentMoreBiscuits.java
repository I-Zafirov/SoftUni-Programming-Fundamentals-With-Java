package T19MidExamPreparation;

import java.util.Scanner;

public class _P1_YouProducePercentMoreBiscuits {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int target = Integer.parseInt(input.nextLine());
        int people = Integer.parseInt(input.nextLine());
        double competitor = Double.parseDouble(input.nextLine());

        double production = target * people * 20 + Math.floor(target * people * 0.75) * 10;
        double diff = production / competitor;

        System.out.printf("You have produced %.0f biscuits for the past month.%n", production);

        if(diff > 1){
            System.out.printf("You produce %.2f percent more biscuits.", (diff - 1) * 100);
        }
        else{
            System.out.printf("You produce %.2f percent less biscuits.", (1 - diff) * 100);
        }
    }
}
