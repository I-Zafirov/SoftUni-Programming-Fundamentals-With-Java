package T19MidExamPreparation;

import java.util.Scanner;

public class PartyProfit2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int companions=Integer.parseInt(scanner.nextLine());
        int days=Integer.parseInt(scanner.nextLine());

        int coins=days*50;

        for (int day = 1; day <=days ; day++) {
            if(day%10==0){
                companions-=2;
            }
            if(day%15==0){
                companions+=5;
            }
            if(day%3==0){
                coins-=companions*3;
            }
            if(day%5==0){
                int earnedCoins=20;
                coins+=(earnedCoins*companions);
                if(day%3==0) {
                    coins-=companions*2;
                }
            }
            coins-=(2*companions);
        }

        double allSpendForEach=coins/companions;
        System.out.printf("%d companions received %.0f coins each.",companions,allSpendForEach);
    }
}
