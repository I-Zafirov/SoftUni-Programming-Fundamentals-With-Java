package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumbersStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        double average = numbers
                .stream()
                .mapToInt(n -> n)
                .average()
                .getAsDouble();


        List<Integer> output = numbers
                .stream()
                .filter( n -> n > average)
                .limit(5)
                .collect(Collectors.toList());

        if (output.isEmpty()){
            System.out.println("No");
        }else{
            for (int i = 0; i < output.size(); i++) {
                System.out.print(output.get(i));
                if (i < output.size() - 1){
                    System.out.print(" ");
                }
            }
        }
    }
}
