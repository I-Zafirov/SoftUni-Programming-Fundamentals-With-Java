package T14Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class x11_MathOperations1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double secondNum = Double.parseDouble(scanner.nextLine());

        System.out.println(new DecimalFormat("0.##")
                .format(calculate(firstNum, operator, secondNum)));
        // System.out.printf("%.0f", getResult(firstNum,operator,secondNum));
    }

    private static double calculate(double firstNum, String operator, double secondNum) {
        double sum = 0;

        switch (operator) {
            case "+":
                sum = firstNum + secondNum;
                break;
            case "-":
                sum = firstNum - secondNum;
                break;
            case "*":
                sum = firstNum * secondNum;
                break;
            case "/":
                sum = firstNum / secondNum;
                break;
        }
        return sum;
    }
}
