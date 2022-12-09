package T33FinExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        int[] lift = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < lift.length; i++) {

            while (lift[i] < 4) {
                if (people == 0) {
                    break;
                }
                lift[i]++;
                people--;
            }
        }
        int lastPosition = lift[lift.length - 1];

        if (people == 0 && lastPosition < 4) {
            System.out.println("The lift has empty spots!");
        }

        if (lastPosition == 4 && people > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", people);
        }

        for (int i = 0; i < lift.length; i++) {
            System.out.print(lift[i] + " ");
        }
    }
}
