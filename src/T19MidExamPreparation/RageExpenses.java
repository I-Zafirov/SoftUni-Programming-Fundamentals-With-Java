package T19MidExamPreparation;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loses = Integer.parseInt(scanner.nextLine());
        double headset = Double.parseDouble(scanner.nextLine());
        double mouse = Double.parseDouble(scanner.nextLine());
        double keyboard = Double.parseDouble(scanner.nextLine());
        double display = Double.parseDouble(scanner.nextLine());

        double sum = 0;
        sum = (loses / 2) * headset + (loses / 3) * mouse + (loses / 6) * keyboard + (loses / 12) * display;
        System.out.printf("Rage expenses: %.2f lv.",sum);

    }
}
