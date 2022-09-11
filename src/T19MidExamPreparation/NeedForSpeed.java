package T19MidExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, int[]> availableCars = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] cars = scan.nextLine().split("\\|");
            String name = cars[0];
            int miles = Integer.parseInt(cars[1]);
            int fuel = Integer.parseInt(cars[2]);

            int[] power = new int[]{miles, fuel};
            availableCars.put(name, power);
        }
        String[] commands = scan.nextLine().split(" : ");

        while (!commands[0].equals("Stop")) {
            String carName = commands[1];

            switch (commands[0]) {
                case "Drive":
                    int distance = Integer.parseInt(commands[2]);
                    int fuel = Integer.parseInt(commands[3]);

                    if (availableCars.get(carName)[1] < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        availableCars.get(carName)[0] += distance;
                        availableCars.get(carName)[1] -=fuel;

                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", carName, distance, fuel);

                        if(availableCars.get(carName)[0]>=100000){
                            availableCars.remove(carName);
                            System.out.println("Time to sell the " + carName  + "!");
                        }
                    }
                    break;
                case "Refuel":
                    int refill = Integer.parseInt(commands[2]);

                    if(availableCars.get(carName)[1] + refill >75){
                        System.out.printf("%s refueled with %d liters\n", carName, 75 - availableCars.get(carName)[1]);

                        availableCars.get(carName)[1]=75;
                    }else{
                        availableCars.get(carName)[1] +=refill;

                        System.out.printf("%s refueled with %d liters\n", carName, refill);
                    }
                    break;
                case "Revert":
                    int kilometres = Integer.parseInt(commands[2]);

                    if(availableCars.get(carName)[0] - kilometres<10000){
                        availableCars.get(carName)[0]=10000;
                    }else{
                        availableCars.get(carName)[0]-=kilometres;

                        System.out.printf("%s mileage decreased by %s kilometers\n", carName, kilometres);
                    }
                    break;
            }
            commands = scan.nextLine().split(" : ");
        }

        availableCars.entrySet()
                .stream()
                .sorted((a, b) ->{
                    if(a.getValue()[0]!=b.getValue()[0]){
                        return Integer.compare(b.getValue()[0], a.getValue()[0]);
                    }else{
                        return a.getKey().compareTo(b.getKey());
                    }
                })
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %s lt.\n", e.getKey(), e.getValue()[0], e.getValue()[1]));
    }
}
