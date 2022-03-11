package T17List.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class collections {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 6, 3, 2, 1));

        Collections.sort(numbers); //quicksort, mergesort
        for(int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
