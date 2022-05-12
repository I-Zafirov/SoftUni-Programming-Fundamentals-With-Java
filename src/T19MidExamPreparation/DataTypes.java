package T19MidExamPreparation;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String number = scan.nextLine();
        double resultDouble = 0;
        int resultInt = 0;
        String resultString = "";

        switch (input) {
            case "int":
                System.out.println(resultInt = numbersInt(number));
                break;
            case "real":
                System.out.printf("%.2f", resultDouble = numberDouble(number));
                break;
            case "string":
                System.out.println(resultString = numberString(number));
                break;
        }
    }

    private static String numberString(String number) {
        return number = "$" + number + "$";
    }

    private static int numbersInt(String number) {
        return Integer.parseInt(number) * 2;
    }

    private static double numberDouble(String number) {
        return Double.parseDouble(number) * 1.5;
    }
}
