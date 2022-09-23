package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WeaponSmith {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> data = Arrays.stream(input.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String expression;
        String[] command;

        while(!(expression = input.nextLine()).equals("Done")){
            command = expression.split("\\s+");

            switch (command[0]){
                case "Move": movesElement(data, command[1], Integer.parseInt(command[2])); break;
                case "Check": printsElements(data, command[1]); break;
                default: break;
            }
        }

        StringBuilder weapon = new StringBuilder();

        for (int c = 0; c < data.size(); c++) {
            weapon.append(data.get(c));
        }

        System.out.printf("You crafted %s!", weapon);
    }


    public static void movesElement(List<String> data, String direction, int index){
        if(direction.equals("Left") && index > 0 && index < data.size()){
            String current = data.get(index);
            data.remove(index);
            data.add(index - 1, current);
        }
        else if(direction.equals("Right") && index >= 0 && index < data.size() - 1){
            String current = data.get(index);
            data.remove(index);
            data.add(index + 1, current);
        }
    }


    public static void printsElements(List<String> data, String evenOrOdd){
        if(evenOrOdd.equals("Even")){
            for (int a = 0; a < data.size(); a++) {
                if(a % 2 == 0){
                    System.out.print(data.get(a) + " ");
                }
            }
        }
        else{
            for (int b = 0; b < data.size(); b++) {
                if(b % 2 != 0){
                    System.out.print(data.get(b) + " ");
                }
            }
        }
        System.out.println();
    }
}
