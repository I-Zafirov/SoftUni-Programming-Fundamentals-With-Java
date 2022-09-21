package T19MidExamPreparation;

import java.util.Scanner;

public class TelerikAlphaCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String output = "";
        int count = 5;
        while(count != 0){
            int number = scanner.nextInt();

            int sum = 1;
            while (number != 0){
                int lastDigit = number % 10;
                sum *= lastDigit;
                number /= 10;
            }

            int last = sum % 10;
            output += last;
            count--;
        }
        System.out.println(output);
    }
}
