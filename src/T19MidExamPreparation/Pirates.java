package T19MidExamPreparation;

import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int plunderPerDay = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());

        double totalPlunder = 0.0;
        for (int i = 1; i <= days; i++) {
            totalPlunder += plunderPerDay;
            if (i % 3 == 0){
                totalPlunder += plunderPerDay / 2.0;
            }
            if (i % 5 == 0){
                totalPlunder *= 0.7;
            }
        }

        if (totalPlunder >= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        }else{
            double percentage = totalPlunder / expectedPlunder * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percentage);
        }
    }
}
