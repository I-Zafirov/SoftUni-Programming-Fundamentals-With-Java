package T33FinExamPreparation;

import java.math.BigInteger;
import java.util.Scanner;

public class SoftUniNumerals2 {
    static String output = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        getNumerical(line);

        System.out.println(new BigInteger(output, 5));

    }

    private static void getNumerical(String line) {
        if (line.length() == 0) {
            return;
        }
        if (line.substring(0, 2).equals("aa")) {
            output += "0";
            getNumerical(line.substring(2, line.length()));
        } else if (line.substring(0, 2).equals("cc")) {
            output += "3";
            getNumerical(line.substring(2, line.length()));
        } else if (line.substring(0, 3).equals("aba")) {
            output += "1";
            getNumerical(line.substring(3, line.length()));
        } else if (line.substring(0, 3).equals("bcc")) {
            output += "2";
            getNumerical(line.substring(3, line.length()));
        } else if (line.substring(0, 3).equals("cdc")) {
            output += "4";
            getNumerical(line.substring(3, line.length()));
        }
    }
}
