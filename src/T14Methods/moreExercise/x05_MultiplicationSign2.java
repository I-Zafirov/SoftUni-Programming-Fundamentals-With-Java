package T14Methods.moreExercise;

import java.util.Scanner;

public class x05_MultiplicationSign2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        getSigh(firstNum, secondNum, thirdNum);
    }

    private static void getSigh(int firstNum, int secondNum, int thirdNum) {
        boolean isPositive = true;

        if (firstNum == 0 || secondNum == 0 || thirdNum == 0) {
            isPositive = false;
            System.out.print("zero");
        }
        if (firstNum < 0 && secondNum < 0 && thirdNum < 0) {
            isPositive = false;
            System.out.print("negative");
        } else if (firstNum < 0 || secondNum < 0 || thirdNum < 0) {
            if (firstNum < 0 && secondNum < 0 && thirdNum > 0) {

            } else if (firstNum < 0 && thirdNum < 0 && secondNum > 0) {

            } else if (secondNum < 0 && thirdNum < 0 && firstNum > 0) {

            } else {
                isPositive = false;
                System.out.print("negative");
            }
        }
        if (isPositive) {
            System.out.print("positive");
        }
    }
}
