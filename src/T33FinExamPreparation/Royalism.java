package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Royalism {
    static List<String> royalists = new ArrayList<>();
    static List<String> atheists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().split(" ");

        for (String name : names) {
            int sum = 0;
            for (Character c : name.toCharArray()) {
                sum += c;
                sum %= 26;
            }
            if (sum == 18) {
                royalists.add(name);
            } else {
                atheists.add(name);
            }
        }
        if (royalists.size() >= atheists.size()) {
            System.out.printf("Royalists - %d%n", royalists.size());
            for (String name : royalists) {
                System.out.println(name);
            }
            System.out.println("All hail Royal!");
        } else {
            for (String name : atheists) {
                System.out.println(name);
            }
            System.out.println("Royalism, Declined!");
        }

    }
}
