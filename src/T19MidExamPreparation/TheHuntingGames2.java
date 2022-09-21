package T19MidExamPreparation;

import java.util.Scanner;

public class TheHuntingGames2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int days=Integer.parseInt(scanner.nextLine());
        int numOfPLayers=Integer.parseInt(scanner.nextLine());
        double energy=Double.parseDouble(scanner.nextLine());
        double waterPerPerson=Double.parseDouble(scanner.nextLine());
        double foodPerPerson=Double.parseDouble(scanner.nextLine());
        double totalFood=foodPerPerson*numOfPLayers*days;
        double totalWater=waterPerPerson*numOfPLayers*days;
        boolean isEnough=true;


        for(int day=1;day<=days;day++){
            double energyLoss=Double.parseDouble(scanner.nextLine());
            energy=energy-energyLoss;
            if(energy<=0){
                isEnough=false;
                break;
            }

            if(day%2==0){
                energy=energy + energy*0.05;
                totalWater-=totalWater*0.3;
            }
            if(day%3==0){
                energy=energy+energy*0.1;
                totalFood-=(totalFood/(double)numOfPLayers);
            }


        }

        if(isEnough){
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!",energy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",totalFood,totalWater);
        }
    }
}
