package T08DataTypesAndVariables.exercise;

import java.util.Scanner;

public class x03_Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine()); // int n = Double.parseDouble(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        double courses = Math.ceil(n / p); // double courses = Math.ceil((double) n / p);
        System.out.printf("%.0f", courses);
    }
}
