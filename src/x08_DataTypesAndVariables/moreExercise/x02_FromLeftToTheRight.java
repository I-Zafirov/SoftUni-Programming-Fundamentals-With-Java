package x08_DataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class x02_FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            double number1 = Double.parseDouble(scanner.next());
            double number2 = Double.parseDouble(scanner.next());
            int sum = 0;

            if (number1 > number2) {
                double firstNumber = Math.abs(number1);
                while (firstNumber > 0) {
                    sum += (firstNumber % 10);
                    firstNumber /= 10;
                }
            } else {
                double secondNumber = Math.abs(number2);
                while (secondNumber > 0) {
                    //взема последното число
                    sum += (secondNumber % 10);
                    //премахва последното число
                    secondNumber /= 10;
                }
            }
            System.out.println(sum);
        }
    }
}
