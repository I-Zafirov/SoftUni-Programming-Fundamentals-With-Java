package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnduranceRally {
    private static List<String> drivers;
    private static List<Double> field;
    private static List<Integer> indexes;
    private static BufferedReader reader;

    static {
        drivers = new ArrayList<>();
        field = new ArrayList<>();
        indexes = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        parseLists();
        for (String driver : drivers) {
            double fuel = driver.charAt(0);
            boolean isFinished = true;

            for (int j = 0; j < field.size(); j++) {
                if (indexes.contains(j)) {
                    fuel += field.get(j);
                } else {
                    fuel -= field.get(j);
                }

                if (fuel <= 0) {
                    isFinished = false;
                    System.out.println(String.format("%s - reached %d", driver, j));
                    break;
                }
            }

            if (isFinished) {
                System.out.println(String.format("%s - fuel left %.2f", driver, fuel));
            }

        }

    }

    private static void parseLists() throws IOException {
        drivers = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));
        field = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayList::new));
        indexes = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
