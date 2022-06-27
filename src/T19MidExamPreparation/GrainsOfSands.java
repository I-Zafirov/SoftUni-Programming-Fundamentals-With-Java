package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrainsOfSands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (true) {
            String line = scanner.nextLine().toLowerCase();

            if (line.equals("mort")) {
                break;
            }

            String[] tokens = line.split("\\s+");
            int n = Integer.parseInt(tokens[1]);

            switch (tokens[0]) {
                case "add":
                    numbers.add(n);
                    break;
                case "remove":

                    if (numbers.contains(n)) {
                        numbers.remove(Integer.valueOf(n));
                    } else if (Math.abs(n) >= 0 && Math.abs(n) < numbers.size()) {
                        numbers.remove(n);
                    }

                    break;
                case "replace":
                    int replacement = Integer.parseInt(tokens[2]);

                    if (numbers.contains(n)) {
                        numbers.set(numbers.indexOf(n), replacement);
                    }

                    break;
                case "increase":
                    int increaseWith = 0;
                    label:

                    for (int i = 0; i < numbers.size(); i++) {

                        if (n <= numbers.get(i)) {
                            increaseWith = numbers.get(i);
                            break label;
                        } else if (i == numbers.size() - 1) {
                            increaseWith = numbers.get(numbers.size() - 1);
                            break label;
                        }

                    }

                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, numbers.get(i) + increaseWith);
                    }

                    break;
                case "collapse":

                    for (int i = 0; i < numbers.size(); i++) {

                        if (n > numbers.get(i)) {
                            numbers.remove(Integer.valueOf(numbers.get(i)));
                            i = -1;
                        }

                    }

                    break;
                default:
                    break;
            }
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }
}
