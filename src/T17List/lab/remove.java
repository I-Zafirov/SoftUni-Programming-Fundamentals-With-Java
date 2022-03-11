package T17List.lab;

import java.util.ArrayList;
import java.util.List;

public class remove {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(0);

        int x = 0;//премахва елемента на позция 0
        numbers.remove(x);

        for (int n : numbers) {
            System.out.println(n);
        } //изход 1 0
/*
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(0);

        Integer x = 0;//премахва елемента със стойност 0
        numbers.remove(x);

        for (int n : numbers) {
            System.out.println(n);
        } //изход 2 0
 */
    }
}
