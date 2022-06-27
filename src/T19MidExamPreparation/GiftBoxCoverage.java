package T19MidExamPreparation;

import java.util.Scanner;

public class GiftBoxCoverage {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double side=Double.parseDouble(scanner.nextLine());
        double count=Double.parseDouble(scanner.nextLine());
        double area=Double.parseDouble(scanner.nextLine());
        double presentArea=side*side*6;
        double countThri=count/3;
        double allSheet=2*countThri*area + countThri*(area*0.25);


        double percentage=allSheet/presentArea*100;
        System.out.printf("You can cover %.2f%% of the box.",percentage);
    }
}
