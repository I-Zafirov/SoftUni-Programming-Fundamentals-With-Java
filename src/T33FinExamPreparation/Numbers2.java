package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> filtered = new ArrayList<>();

        numbers.stream()
                .filter(e -> e > numbers.stream().mapToDouble(Integer::doubleValue).average().getAsDouble())
                .sorted((e1, e2) -> e2.compareTo(e1))
                .limit(5)
                .map(filtered::add).collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No");
        } else {
            filtered.forEach(e -> System.out.print(e + " "));
        }


    }
}
