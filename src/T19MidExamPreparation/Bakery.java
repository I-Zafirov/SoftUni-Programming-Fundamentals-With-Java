package T19MidExamPreparation;

import java.util.Scanner;

public class Bakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bscperw = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int otherfac = Integer.parseInt(scanner.nextLine());
        double thirdday=Math.floor(bscperw*workers*0.75);
        int total=0;
        for(int i=1;i<=30;i++){
            if(i%3==0){
                total+=thirdday;
            }
            else{
                total+=bscperw*workers;
            }
        }
        System.out.printf("You have produced %d biscuits for the past month.",total);
        System.out.println();
        double diff=total-otherfac;
        if(diff>0){
            double perc=(diff/otherfac)*100;
            System.out.printf("You produce %.2f percent more biscuits.",perc);
        }
        else{
            diff=diff*(-1);
            double perc=(diff/otherfac)*100;
            System.out.printf("You produce %.2f percent less biscuits.",perc);
        }
    }
}
