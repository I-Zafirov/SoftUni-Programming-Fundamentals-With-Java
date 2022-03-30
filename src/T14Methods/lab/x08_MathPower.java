package T14Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class x08_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        System.out.println(new DecimalFormat("0.####").format(mathPower(number, power)));
    }

    public static Double mathPower(double number, int power) {
        return Math.pow(number, power);
    }
}