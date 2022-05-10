package T19MidExamPreparation;

import java.util.Scanner;

public class ChristmasSpirit2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int quantity=Integer.parseInt(scanner.nextLine());
        int days=Integer.parseInt(scanner.nextLine());
        int totalCost=0;
        int totalSpirit=0;
        int ornamentPrice=2;
        int treeSkirtPrice=5;
        int treeGarlandsPrice=3;
        int treeLightsPrice=15;

        for (int day = 1; day <=days ; day++) {
            if(day%11==0){
                quantity=quantity+2;
            }
            if(day%2==0){
                int price=quantity*ornamentPrice;
                totalCost+=price;
                totalSpirit+=5;
            }
            if(day%3==0){
                int price=quantity*treeSkirtPrice;
                totalCost+=price;
                int price1=quantity*treeGarlandsPrice;
                totalCost+=price1;
                totalSpirit+=13;
            }
            if(day%5==0){
                int price=quantity*treeLightsPrice;
                totalCost+=price;
                totalSpirit+=17;
                if(day%3==0){
                    totalSpirit+=30;
                }
            }
            if(day%10==0){
                totalSpirit-=20;
                int price=treeSkirtPrice+treeGarlandsPrice+treeLightsPrice;
                totalCost+=price;
                if(day==days){
                    totalSpirit-=30;
                }
            }

        }

        System.out.printf("Total cost: %d%n",totalCost);
        System.out.printf("Total spirit: %d",totalSpirit);

    }
}
