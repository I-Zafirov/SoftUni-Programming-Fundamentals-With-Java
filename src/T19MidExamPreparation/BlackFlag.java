package T19MidExamPreparation;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int plunderDays = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());
        double plunderGained = 0;


        for (int currentDay = 1; currentDay <= plunderDays; currentDay++) {
            plunderGained += dailyPlunder;
            if(currentDay % 3 == 0){
                plunderGained += dailyPlunder * 0.50;
            }
            if(currentDay % 5 == 0){
                plunderGained = plunderGained * 0.70;
            }
        }
        if(plunderGained >= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.",plunderGained);
        }else {
            System.out.printf("Collected only %.2f%% of the plunder.",(plunderGained / expectedPlunder) * 100 );
        }
    }
}
