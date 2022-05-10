package T19MidExamPreparation;

import java.util.Scanner;

public class ChristmasSpirit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int spirit = 0;

        double ornamentSetsCost = 0;
        double treeSkirtsCost = 0;
        double treeGarlandsCost = 0;
        double treeLightsCost = 0;

        for (int day = 1; day <= days; day++) {
            if (day % 11 == 0) {
                quantity += 2;
            }

            if (day % 2 == 0) {
                ornamentSetsCost += quantity * 2.00;
                spirit += 5;
            }

            if (day % 3 == 0){
                treeSkirtsCost += quantity * 5.00;
                treeGarlandsCost += quantity * 3.00;
                spirit += 13;
            }

            if (day % 5 == 0) {
                treeLightsCost += quantity * 15.00;
                if (day % 3 == 0) {
                    spirit += 47;
                } else {
                    spirit += 17;
                }
            }

            if (day % 10 == 0) {
                treeSkirtsCost += 5.00;
                treeGarlandsCost += 3.00;
                treeLightsCost += 15.00;
                spirit -= 20;

                if ((day == days)) {
                    spirit -= 30;
                }
            }


        }

        double totalCost = ornamentSetsCost + treeSkirtsCost + treeGarlandsCost + treeLightsCost;

        System.out.printf("Total cost: %.0f\n" +
                "Total spirit: %d\n",totalCost, spirit);
    }
}
