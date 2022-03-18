package T27TextProcessing.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E1ValidUsernames3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(", "))
                .filter(username -> username.length() >= 3 && username.length() <= 16)
                .filter(username -> username.matches("[a-zA-Z_\\-\\d]+"))
                .forEach(System.out::println);
    }
}
