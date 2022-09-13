package T19MidExamPreparation;

import java.util.Scanner;

public class PartyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int partySize = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int coins = 0;

        double coinsPerCompanion = 0.00;

        for (int i = 1; i <= days; i++) {
            if (i % 10 == 0) {
                partySize = partySize - 2;
            }

            if (i % 15 == 0) {
                partySize = partySize + 5;
            }

            coins = coins + 50 - (partySize * 2);

            if (i % 3 == 0) {
                coins = coins - partySize * 3;
            }

            if (i % 5 == 0) {
                if (i % 3 == 0){
                    coins = coins + partySize * 18;
                } else {
                    coins = coins + partySize * 20;
                }
            }

        }

        coinsPerCompanion = Math.floor((double)coins / partySize);

        System.out.printf("%d companions received %.0f coins each.",partySize,coinsPerCompanion);
    }
}
