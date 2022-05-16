package T19MidExamPreparation;

import java.util.Scanner;

public class EasterCozonacs2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        double flourPricePerKg = Double.parseDouble(scan.nextLine());

        double priceForPackOfEggs = flourPricePerKg * 0.75;
        double milk = (flourPricePerKg + flourPricePerKg * 0.25) / 4;

        double cozonac = priceForPackOfEggs + flourPricePerKg + milk;

        int cozonacCount = 0;
        int eggsCount = 0;

        while (budget >= cozonac) {
            budget -= cozonac;

            cozonacCount++;
            eggsCount += 3;
            if (cozonacCount % 3 == 0) {
                eggsCount -= cozonacCount - 2;

            }
        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.",
                cozonacCount, eggsCount, budget);
    }
}
