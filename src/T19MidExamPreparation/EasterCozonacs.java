package T19MidExamPreparation;

import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double flourPerKg = Double.parseDouble(scanner.nextLine());

        double packEggs = flourPerKg * 0.75;
        double milkForCozonac = (flourPerKg * 1.25) / 4;

        double priceOfCozonacs = packEggs + flourPerKg + milkForCozonac;
        int cozonacs = 0;
        int coloredEggs = 0;

        while (budget >= priceOfCozonacs){
            cozonacs++;
            coloredEggs += 3;
            if (cozonacs % 3 == 0){
                coloredEggs -= cozonacs - 2;
            }
            budget -= priceOfCozonacs;
        }

        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.",
                cozonacs, coloredEggs, budget);
    }
}
