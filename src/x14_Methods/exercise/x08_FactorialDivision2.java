package x14_Methods.exercise;

import java.util.Scanner;
import java.util.stream.IntStream;

public class x08_FactorialDivision2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", (double) factorial(firstNum) / factorial(secondNum));
    }

    static long factorial(int numbers) {
        return IntStream.iterate(numbers, i -> i > 1, i -> i - 1)
                .asLongStream()
                .reduce(1, (a, b) -> a * b);
    }
}
