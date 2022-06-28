package T19MidExamPreparation;

import java.util.Scanner;

public class Hogswatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int presents = Integer.parseInt(scanner.nextLine());
        int firstCourse = presents;

        int counter = 0;
        int courses = 0;
        int sum = 0;

        while (counter != n) {
            counter++;
            int children = Integer.parseInt(scanner.nextLine());

            if (presents >= children) {
                presents -= children;
            } else {
                int extraPresents = (firstCourse / counter) * (n - counter) + children - presents;
                courses++;
                sum += extraPresents;
                presents = extraPresents - (children - presents);
            }

        }

        if (courses == 0) {
            System.out.println(presents);
        } else {
            System.out.println(courses);
            System.out.println(sum);
        }

    }
}
