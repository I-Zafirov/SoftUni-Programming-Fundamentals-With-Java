package x11_Arrays.lab;

import java.util.Scanner;

public class x05_EvenAndOddSubtraction2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] numbersAsStrings = line.split("\\s+");

        int sums[] = new int[2];
        for (String s : numbersAsStrings) {

            int number = Integer.parseInt(s);
            sums[number % 2] += number;
        }
        System.out.println(sums[0] - sums[1]);
    }
}

