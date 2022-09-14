package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PresentDelivery2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> houses = Arrays.stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int currentLocation = 0;

        String input = "";

        while (!"Merry Xmas!".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            int jumpLenght = Integer.parseInt(data[1]);

            currentLocation += jumpLenght;

            while (currentLocation >= houses.size()) {
                currentLocation -= houses.size();
            }

            if (houses.get(currentLocation) - 2 < 0) {
                houses.set(currentLocation,0);
                System.out.printf("House %d will have a Merry Christmas.%n",currentLocation);
            } else {
                houses.set(currentLocation,houses.get(currentLocation) - 2);
            }

        }

        boolean missionSuccessful = true;
        int housesFailed = 0;
        for (int i = 0; i < houses.size(); i++) {
            if (!(houses.get(i) == 0)) {
                missionSuccessful = false;
                housesFailed++;
            }
        }

        System.out.printf("Santa's last position was %d.%n",currentLocation);
        if (missionSuccessful) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Santa has failed %d houses.",housesFailed);
        }
    }
}
