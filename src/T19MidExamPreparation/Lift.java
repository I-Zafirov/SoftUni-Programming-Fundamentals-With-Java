package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleOnQueue = Integer.parseInt(scanner.nextLine());
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int totalSpaceInWagons = 0;
        int countTotalWagons = 0;
        int sumWagonUtilisation = 0;
        for (int wagon : wagons) {
            sumWagonUtilisation += wagon;
            countTotalWagons++;
        }
        totalSpaceInWagons = countTotalWagons * 4;
        int totalPeople = peopleOnQueue + sumWagonUtilisation;
        List<Integer> wagonsAfterUtilisation = new ArrayList<>();

        int countFullWagons = 0;
        int countEmptyWagons = countTotalWagons;
        int peopleLeftOnTheQueue = totalPeople - totalSpaceInWagons;
        if (totalSpaceInWagons > totalPeople){
            while (countEmptyWagons >= countFullWagons){
                if (totalPeople < 4){
                    int peopleLeft = totalPeople % 4;
                    wagonsAfterUtilisation.add(peopleLeft);
                    break;
                }
                wagonsAfterUtilisation.add(4);
                countFullWagons++;
                totalPeople -= 4;
            }
            System.out.println("The lift has empty spots!");
            System.out.println(Arrays.toString(new List[]{wagonsAfterUtilisation}).replaceAll("[\\[\\],]", ""));
        } else if (totalSpaceInWagons < totalPeople){
            while (countEmptyWagons > countFullWagons){
                if (totalPeople < 4){
                    int peopleLeft = totalPeople % 4;
                    wagonsAfterUtilisation.add(peopleLeft);
                    break;
                }
                wagonsAfterUtilisation.add(4);
                countFullWagons++;
                totalPeople -= 4;
            }
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleLeftOnTheQueue);
            System.out.println(Arrays.toString(new List[]{wagonsAfterUtilisation}).replaceAll("[\\[\\],]", ""));
        } else if (totalPeople == totalSpaceInWagons){
            while (countEmptyWagons > countFullWagons){
                wagonsAfterUtilisation.add(4);
                countFullWagons++;
                totalPeople -= 4;
            }
            System.out.println(Arrays.toString(new List[]{wagonsAfterUtilisation}).replaceAll("[\\[\\],]", ""));
        }
    }
}
