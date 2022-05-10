package T19MidExamPreparation;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());

        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());

        if(closestPoint(x1, y1) <= closestPoint(x2, y2)){
            System.out.printf("(%d, %d)", x1, y1);
        }else{
            System.out.printf("(%d, %d)", x2, y2);
        }
    }

    private static Double closestPoint(int x, int y) {
        double a = x * 1.0;
        double b = y + 1.0;

        return Math.sqrt(Math.abs((Math.pow(a, 2)) + (Math.pow(b, 2))));
    }
}
