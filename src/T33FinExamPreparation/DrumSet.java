package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DrumSet {
    private static BufferedReader reader;
    private static double savings;
    private static List<Integer> initial;
    private static List<Integer> drums;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        getInput();

        String input;
        while (!"Hit it again, Gabsy!".equals(input = reader.readLine()) && !drums.isEmpty()) {
            int power = Integer.parseInt(input);
            drums = drums.stream()
                    .map(drum -> drum - power)
                    .collect(Collectors.toCollection(ArrayList::new));
            List<Integer> indexToRemove = new ArrayList<>();

            for (int i = 0; i < drums.size(); i++) {
                int drum = drums.get(i);
                if (drum <= 0) {
                    double drumPrice = initial.get(i) * 3;
                    if (savings - drumPrice >= 0) {
                        savings -= drumPrice;
                        drums.set(i, initial.get(i));
                    } else {
                        indexToRemove.add(drum);
                    }
                }
            }

            removeBrokenDrums(indexToRemove);
        }

        System.out.println(drums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(String.format("Gabsy has %.2flv.", savings));


    }

    private static void removeBrokenDrums(List<Integer> indexToRemove) {
        for (Integer element : indexToRemove) {
            int index = drums.indexOf(element);
            initial.remove(index);
            drums.remove(index);
        }
    }

    private static void getInput() throws IOException {
        savings = Double.parseDouble(reader.readLine());
        String[] tokens = reader.readLine().split("\\s+");
        initial = new ArrayList<>();
        drums = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            initial.add(number);
            drums.add(number);
        }
    }
}
