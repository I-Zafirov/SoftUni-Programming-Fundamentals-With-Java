package T23BitwiseOperations.lab;

import java.util.Scanner;

public class L2BitAtPosition1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // get the bit at position 1 from number n
        int n = Integer.parseInt(scanner.nextLine());
        int p = 1;

        int bitAtPosition1 = (n >> p) & 1; // formula

        System.out.println(bitAtPosition1);
    }
}

