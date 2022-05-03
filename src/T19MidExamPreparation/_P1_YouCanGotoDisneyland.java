package T19MidExamPreparation;

import java.util.Scanner;

public class _P1_YouCanGotoDisneyland {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double journeyPrice = Double.parseDouble(scan.nextLine());
        int numberMonths = Integer.parseInt(scan.nextLine());
        scan.close();
        double money = 0;

        for (int i = 1; i <= numberMonths; i++) {
            if ((i % 2) != 0 && i > 1) {
                money *= (1 - 0.16);
            }
            if ((i % 4) == 0) {
                money *= (1 + 0.25);
            }
            money += journeyPrice * 0.25;
        }

        if(money >= journeyPrice) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", (money - journeyPrice));
        }else {
            System.out.printf("Sorry. You need %.2flv. more.", (journeyPrice - money));
        }

    }
}
