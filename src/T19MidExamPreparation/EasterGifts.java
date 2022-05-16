package T19MidExamPreparation;

import java.util.Scanner;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] gifts = scanner.nextLine().split("\\s+");

        while (true){
            String input = scanner.nextLine();
            if (input.equals("No Money")){
                break;
            }
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String gift = tokens[1];
            switch (command){
                case "OutOfStock":
                    for (int i = 0; i < gifts.length; i++) {
                        if (gifts[i].equals(gift)){
                            gifts[i] = "None";
                        }
                    }
                    break;
                case "Required":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < gifts.length){
                        gifts[index] = gift;
                    }
                    break;
                case "JustInCase":
                    gifts[gifts.length - 1] = gift;
                    break;
            }
        }
        for (int i = 0; i < gifts.length; i++) {
            if (!gifts[i].equals("None")){
                System.out.print(gifts[i]);
                if (i < gifts.length - 1){
                    System.out.print(" ");
                }
            }
        }
    }
}
