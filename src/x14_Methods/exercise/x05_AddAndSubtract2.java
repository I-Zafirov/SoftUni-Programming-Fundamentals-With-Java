package x14_Methods.exercise;

import java.util.Scanner;

public class x05_AddAndSubtract2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());
        int thirdNum = Integer.parseInt(scan.nextLine());

        System.out.println(subtract(sum(firstNum, secondNum), thirdNum));
    }

    static int sum(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    static int subtract(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }
}
