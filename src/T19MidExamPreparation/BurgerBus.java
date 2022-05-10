package T19MidExamPreparation;

import java.util.Scanner;

public class BurgerBus {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int citycount = Integer.parseInt(inp.nextLine());
        String[] city = new String[citycount];
        Double[] earnings = new Double[citycount];
        Double[] expences = new Double[citycount];
        Double[] profit = new Double[citycount];

        for( int i =0 ; i<citycount; i++){
            city[i] = inp.nextLine();
            earnings[i] = Double.parseDouble(inp.nextLine());
            expences[i] = Double.parseDouble(inp.nextLine());
            if( (i+1)%5==0) {
                earnings[i]=earnings[i]*0.9;
                profit[i] = earnings[i] - expences[i];
            }else if((i+1)%3==0){
                expences[i]=expences[i]*1.5;
                profit[i] = earnings[i] - expences[i];
            } else {
                profit[i] = earnings[i] - expences[i];
            }
        }
        double Allprofit =0;
        for( int i =0 ; i<citycount; i++){
            System.out.printf("In %s Burger Bus earned %.2f leva.%n", city[i], profit[i]);
            Allprofit += profit[i];
        }
        System.out.printf("Burger Bus total profit: %.2f leva.",Allprofit);
    }
}
