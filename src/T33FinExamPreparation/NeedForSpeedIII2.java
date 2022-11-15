package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedForSpeedIII2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        {car}|{mileage}|{fuel}
        Map<String, ClassCars> mapCars = new TreeMap<>();
        int input = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < input; i++) {
            String[] inputCommand = scanner.nextLine().split("\\|");
            String car = inputCommand[0];
            int mileage = Integer.parseInt(inputCommand[1]);
            int fuel = Integer.parseInt(inputCommand[2]);
            ClassCars objectCars = new ClassCars(mileage, fuel);
            mapCars.put(car, objectCars);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandLine = command.split(" : ");
            switch (commandLine[0]) {
                case "Drive":
//{car} : {distance} : {fuel}
                    String car = commandLine[1];
                    int distance = Integer.parseInt(commandLine[2]);
                    int fuel = Integer.parseInt(commandLine[3]);
                    int currentFuel = mapCars.get(car).getFuel();
                    if (currentFuel < fuel) {
                        System.out.print("Not enough fuel to make that ride\n");
                    } else {
                        int currentDistance = mapCars.get(car).getMileage();
                        int newDistance = currentDistance + distance;
                        int newFuel = currentFuel - fuel;
                        mapCars.get(car).setMileage(newDistance);
                        mapCars.get(car).setFuel(newFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n"
                                , car, distance, fuel);
                        if (newDistance >= 100000) {
                            mapCars.remove(car);
                            System.out.printf("Time to sell the %s!\n", car);
                        }
                    }
                    break;
                case "Refuel":
//{car} : {fuel}
                    car = commandLine[1];
                    fuel = Integer.parseInt(commandLine[2]);
                    int currentCarFuel = mapCars.get(car).getFuel();
                    int newCarFuel = currentCarFuel + fuel;
                    if (newCarFuel > 75) {
                        newCarFuel = 75;
                        fuel = 75 - currentCarFuel;
                    }
                    mapCars.get(car).setFuel(newCarFuel);
                    System.out.printf("%s refueled with %d liters\n"
                            , car, fuel);
                    break;
                case "Revert":
//{car} : {kilometers}
                    car = commandLine[1];
                    int kilometers = Integer.parseInt(commandLine[2]);
                    int currentKilometers = mapCars.get(car).getMileage();
                    int newKilometers = currentKilometers - kilometers;
                    if (newKilometers < 10000) {
                        mapCars.get(car).setMileage(10000);
                    } else {
                        mapCars.get(car).setMileage(newKilometers);
                        System.out.printf("%s mileage decreased by %d kilometers\n"
                                , car, kilometers);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        mapCars.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getMileage()
                        , e1.getValue().getMileage()))
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n"
                        , e.getKey(), e.getValue().getMileage(), e.getValue().getFuel()));
    }

    static class ClassCars {
        private int mileage;
        private int fuel;

        public ClassCars(int mileage, int fuel) {
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public int getMileage() {
            return mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }
}

