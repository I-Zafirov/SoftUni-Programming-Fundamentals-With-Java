package T17List.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class filterNegative {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(-8, 2, -2, 4, 8, -16));
        List<Integer> filtered = filterNegative(numbers);

        for (int number : filtered){
            System.out.print(numbers + " ");
        }
    }
    private static List<Integer> filterNegative(List<Integer>numbers){
        List<Integer>nonNegative = new ArrayList<>();
        for (int number : numbers){
            if (number >= 0){
                nonNegative.add(number);
            }
        }
        return nonNegative;
    }
}
