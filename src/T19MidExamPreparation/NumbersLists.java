package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumbersLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        String[] input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        int sum = 0;
        for (int elements: list) {
            sum += elements;
        }

        int top5Numbers = 0;
        double average = sum * 1.0 / list.size();
        List<Integer> greater = new ArrayList<>();
        for (int n: list) {
            if (n > average) {
                greater.add(n);
            }
        }
        greater.sort(Collections.reverseOrder());
        if (greater.size() < 1) {
            System.out.println("No");
            return;
        }
        for (int i = 0; i < greater.size(); i++) {
            if (i >= 5) {
                break;
            }
            System.out.printf("%d ", greater.get(i));
        }
    }
}
