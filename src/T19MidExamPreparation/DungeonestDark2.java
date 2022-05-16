package T19MidExamPreparation;

import java.util.Scanner;

public class DungeonestDark2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int coins=0;
        int health=100;
        int currentRoom=0;
        String[] strings= scanner.nextLine().split("\\|");
        Boolean isDead=false;

        for(String element : strings){
            String[] roomNumber=element.split(" ");
            currentRoom++;

            if(roomNumber[0].equals("potion")){
                int numberHealth=Integer.parseInt(roomNumber[1]);
                if(health+numberHealth>=100) {
                    System.out.printf("You healed for %d hp.%n", 100 - health);
                    health = 100;
                    System.out.printf("Current health: %d hp.%n",health);
                } else {
                    health+=numberHealth;
                    System.out.printf("You healed for %d hp.%n",numberHealth);
                    System.out.printf("Current health: %d hp.%n",health);
                }
            } else if(roomNumber[0].equals("chest")){
                int foundCoins=Integer.parseInt(roomNumber[1]);
                coins+=foundCoins;
                System.out.printf("You found %d coins.%n",foundCoins);
            } else {
                int attackOfTheMonster=Integer.parseInt(roomNumber[1]);
                health-=attackOfTheMonster;
                if(health>0){
                    System.out.printf("You slayed %s.%n",roomNumber[0]);
                } else {
                    System.out.printf("You died! Killed by %s.%n",roomNumber[0]);
                    System.out.printf("Best room: %d",currentRoom);
                    isDead=true;
                    break;
                }
            }
        }

        if(!isDead){
            System.out.printf("You've made it!%n");
            System.out.printf("Coins: %d%n",coins);
            System.out.printf("Health: %d%n",health);
        }
    }
}
