package T33FinExamPreparation;

import java.util.LinkedList;
import java.util.Scanner;

public class RoyalismDeclinedAllHailRoyal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] allStrings = sc.nextLine().split(" ");

        LinkedList<String> royalPpl = new LinkedList<>();
        LinkedList<String> nonRoyalPpl = new LinkedList<>();

        for (int i = 0; i < allStrings.length; i++) {
            int sum = 0;
            for (int j = 0; j < allStrings[i].length(); j++) {
                int num = allStrings[i].charAt(j);
                sum += num;
                while (sum > 26) {
                    sum -= 26;
                }
            }

            if (sum == 18) {
                royalPpl.add(allStrings[i]);
            } else {
                nonRoyalPpl.add(allStrings[i]);
            }
        }

        if (royalPpl.size() >= nonRoyalPpl.size()) {
            System.out.printf("Royalists - %d%n", royalPpl.size());
            for (int i = 0; i < royalPpl.size(); i++) {
                System.out.println(royalPpl.get(i));
            }
            System.out.println("All hail Royal!");
        } else {
            for (int i = 0; i < nonRoyalPpl.size(); i++) {
                System.out.println(nonRoyalPpl.get(i));
            }
            System.out.println("Royalism, Declined!");
        }

    }
}
