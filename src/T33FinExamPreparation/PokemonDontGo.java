package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        int removedElement = 0;
        int sumOfRemovedElements = 0;
        while (numbers.size() > 0) {
            int index = Integer.parseInt(reader.readLine());

            if (index < 0) {
                removedElement = numbers.get(0);
                sumOfRemovedElements += removedElement;
                numbers.set(0, numbers.get(numbers.size() - 1));
            } else if (index > numbers.size() - 1) {
                removedElement = numbers.get(numbers.size() - 1);
                sumOfRemovedElements += removedElement;
                numbers.set((numbers.size() - 1), numbers.get(0));
            } else {
                removedElement = numbers.remove(index);
                sumOfRemovedElements += removedElement;
            }

            if (numbers.size() > 0) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) <= removedElement) {
                        int newValue = numbers.get(i) + removedElement;
                        numbers.set(i, newValue);
                    } else {
                        int newValue = numbers.get(i) - removedElement;
                        numbers.set(i, newValue);
                    }
                }
            }
        }

        System.out.println(sumOfRemovedElements);
    }
}
