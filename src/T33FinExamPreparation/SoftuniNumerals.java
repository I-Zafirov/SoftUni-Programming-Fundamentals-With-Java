package T33FinExamPreparation;

import java.math.BigInteger;
import java.util.Scanner;

public class SoftuniNumerals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().replace("aba", "1")
                .replace("bcc", "2")
                .replace("aa", "0")
                .replace("cdc", "4")
                .replace("cc", "3");
        BigInteger num = new BigInteger(text, 5);
        System.out.println(num.toString(10));
    }
}
