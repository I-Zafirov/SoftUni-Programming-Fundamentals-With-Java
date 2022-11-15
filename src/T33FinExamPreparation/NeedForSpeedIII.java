package T33FinExamPreparation;

import java.util.HashMap;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, Integer> carsAndDistance = new HashMap<>();
        HashMap<String, Integer> carsAndFuel = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String nameCar = tokens[0];
            int distance = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            carsAndDistance.put(nameCar, distance);
            carsAndFuel.put(nameCar, fuel);
        }

        while (true) {
            String[] tokens = scanner.nextLine().split(" : ");
            String command = tokens[0];
            if ("Stop".equals(command)) {
                break;
            }
            String nameCar = tokens[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);
                    if (carsAndFuel.get(nameCar) - fuel >= 0) {
                        carsAndDistance.put(nameCar, carsAndDistance.get(nameCar) + distance);
                        carsAndFuel.put(nameCar, carsAndFuel.get(nameCar) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", nameCar, distance, fuel);
                        if (carsAndDistance.get(nameCar) >= 100000) {
                            carsAndDistance.remove(nameCar);
                            carsAndFuel.remove(nameCar);
                            System.out.printf("Time to sell the %s!%n", nameCar);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    fuel = Integer.parseInt(tokens[2]);
                    if (carsAndFuel.get(nameCar) + fuel > 75) {
                        fuel = 75 - carsAndFuel.get(nameCar);
                    }
                    carsAndFuel.put(nameCar, carsAndFuel.get(nameCar) + fuel);
                    System.out.printf("%s refueled with %d liters%n", nameCar, fuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    if (carsAndDistance.get(nameCar) - kilometers < 10000) {
                        carsAndDistance.put(nameCar, 10000);
                    } else {
                        carsAndDistance.put(nameCar, carsAndDistance.get(nameCar) - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", nameCar, kilometers);
                    }
                    break;
            }
        }
        carsAndDistance.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(car -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        car.getKey(), car.getValue(), carsAndFuel.get(car.getKey())));
    }
}
