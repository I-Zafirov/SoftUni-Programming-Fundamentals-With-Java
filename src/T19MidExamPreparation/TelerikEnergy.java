package T19MidExamPreparation;

import java.util.Scanner;

public class TelerikEnergy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String digits = scanner.nextLine();

        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < digits.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(digits.charAt(i)));
            if (digit % 2 == 0){
                evenSum += digit;
            }else{
                oddSum += digit;
            }
        }
        if (evenSum > oddSum){
            System.out.printf("%d energy drinks%n", evenSum);
        }else if(evenSum < oddSum){
            System.out.printf("%d cups of coffee%n", oddSum);
        }else{
            System.out.printf("%d of both%n", evenSum);
        }
    }
}
