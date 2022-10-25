package T33FinExamPreparation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IronGirder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> travelTime = new HashMap<>();
        Map<String, Integer> totalPassengers = new HashMap<>();
        String input;

        while (!"Slide rule".equals(input = scanner.nextLine())) {

            String[] inputCommand = input.split(":");
            String town = inputCommand[0];
            String[] data = inputCommand[1].split("->");
            int passengers = Integer.parseInt(data[1]);

            if ("ambush".equals(data[0])) {

                if (travelTime.containsKey(town)) {
                    travelTime.put(town, 0);
                    totalPassengers.put(town, totalPassengers.get(town) - passengers);
                }
                continue;
            }
            int timeTravel = Integer.parseInt(data[0]);

            travelTime.putIfAbsent(town, timeTravel);

            if (travelTime.get(town) > timeTravel || travelTime.get(town) == 0) {
                travelTime.put(town, timeTravel);
            }
            totalPassengers.putIfAbsent(town, 0);
            totalPassengers.put(town, totalPassengers.get(town) + passengers);
        }

        travelTime.entrySet().stream().filter(pair -> pair.getValue() > 0).sorted((pair1, pair2) -> {
            int sort = Integer.compare(pair1.getValue(), pair2.getValue());

            if (sort == 0) {
                sort = pair1.getKey().compareTo(pair2.getKey());
            }
            return sort;
        }).forEach(pair -> {

            if (totalPassengers.get(pair.getKey()) > 0) {
                System.out.println(String.format("%s -> Time: %d -> Passengers: %d"
                        , pair.getKey(), pair.getValue()
                        , totalPassengers.get(pair.getKey())));
            }
        });
    }
}
