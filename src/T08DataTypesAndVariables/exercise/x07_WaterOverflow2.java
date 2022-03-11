package T08DataTypesAndVariables.exercise;

import java.util.Scanner;

public class x07_WaterOverflow2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int tank = 0;

        for (int i = 0; i < n; i++) {
            int load = Integer.parseInt(scanner.nextLine());
            if (tank + load <= 255) {
                tank += load;
            }else{
                System.out.println("Insufficient capacity!");
                 }
        }
        System.out.println(tank);
    }
}
