package T19MidExamPreparation;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

    }

    private static Double closestPoint(int x, int y) {
        double a = x * 1.0;
        double b = y + 1.0;

        return Math.sqrt(Math.abs((Math.pow(a, 2)) + (Math.pow(b, 2))));
    }
}
