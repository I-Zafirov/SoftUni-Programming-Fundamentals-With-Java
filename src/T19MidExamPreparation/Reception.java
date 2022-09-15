package T19MidExamPreparation;

import java.util.Scanner;

public class Reception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        int sumOfAll = num1 + num2 + num3;

        int workToDo =Integer.parseInt(scan.nextLine());
        int hours = 0;
        while(workToDo>0){
            hours++;
            if(hours%4==0){
                hours++;
            }
            workToDo-=sumOfAll;
        }
        System.out.println("Time needed: " + hours + "h.");
    }
}
