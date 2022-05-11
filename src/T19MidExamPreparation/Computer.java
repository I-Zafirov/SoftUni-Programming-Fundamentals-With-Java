package T19MidExamPreparation;

import java.util.Scanner;

public class Computer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sumwithouttax=0;
        double sumwithtax=0;
        while(true){
            String a = scanner.nextLine();
            if(a.equals("special")){
                if(sumwithouttax==0){
                    System.out.println("Invalid order!");
                    break;
                }
                System.out.println("Congratulations you've just bought a new computer!");
                System.out.printf("Price without taxes: %.2f$",sumwithouttax);
                System.out.println();
                System.out.printf("Taxes: %.2f$",sumwithouttax*0.2);
                System.out.println();
                System.out.println("-----------");
                System.out.printf("Total price: %.2f$",sumwithtax*0.9);
                System.out.println();
                break;
            }
            if(a.equals("regular")){
                if(sumwithouttax==0){
                    System.out.println("Invalid order!");
                    break;
                }
                System.out.println("Congratulations you've just bought a new computer!");
                System.out.printf("Price without taxes: %.2f$",sumwithouttax);
                System.out.println();
                System.out.printf("Taxes: %.2f$",sumwithouttax*0.2);
                System.out.println();
                System.out.println("-----------");
                System.out.printf("Total price: %.2f$",sumwithtax);
                System.out.println();
                break;

            }
            if(Double.parseDouble(a)<0){
                System.out.println("Invalid price!");
                continue;
            }
            sumwithouttax+=Double.parseDouble(a);
            sumwithtax=sumwithouttax*1.2;

        }
    }
}
