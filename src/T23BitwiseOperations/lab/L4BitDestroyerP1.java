package T23BitwiseOperations.lab;

import java.util.Scanner;

public class L4BitDestroyerP1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // sets (clear) the bit at position p to 1
        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        int mask = 1 << p; // ones // formula

        int newNumber = n | mask;

        System.out.println(newNumber);
    }
}

