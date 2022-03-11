package T23BitwiseOperations.lab;

import java.util.Scanner;

public class L6TribitSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // inverts the 3 bits from position p to the left with their XOR opposites
        // (e.g. 111 -> 000, 101 -> 010)
        long n = Long.parseLong(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());
        // Shift the number 7 (the number 7 has the bits 111 which we use to get 3 consecutive values)
        long mask = (long) 7 << p;
        long result = n ^ mask;

        System.out.println(result);
    }
}
