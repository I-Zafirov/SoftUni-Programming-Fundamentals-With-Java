package T08DataTypesAndVariables.lab;

import java.util.Scanner;

public class x04_TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String townName = scanner.nextLine();
        String population = scanner.nextLine();
        String area = scanner.nextLine();

        System.out.printf("Town %s has population of %s and area %s square km.", townName, population, area);
    }
}
