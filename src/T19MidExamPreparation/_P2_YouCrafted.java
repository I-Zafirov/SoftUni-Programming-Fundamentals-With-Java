package T19MidExamPreparation;

import java.util.Scanner;

public class _P2_YouCrafted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String [] array = line.split("\\|");

        String input = scanner.nextLine();

        while (!input.equals("Done")){
            String [] tokens = input.split(" ");
            String command = tokens[0];
            switch (command){
                case "Move":
                    String direction = tokens[1];
                    if (direction.equals("Right")){
                        int index = Integer.parseInt(tokens[2]);
                        if (index>=0 && index<array.length-1){
                            String temp = array[index+1];
                            array[index+1] = array[index];
                            array[index]=temp;
                        }
                    }else if (direction.equals("Left")){
                        int index1 = Integer.parseInt(tokens[2]);
                        if (index1>0 && index1<array.length){
                            String temp1 = array[index1-1];
                            array[index1-1] = array[index1];
                            array[index1] = temp1;
                        }
                    }
                    break;
                case "Check":
                    String checkNum = tokens[1];
                    if (checkNum.equals("Even")){
                        for (int i = 0; i<array.length; i++) {
                            if (i%2==0){
                                System.out.print(array[i]+ " ");
                            }
                        }

                    }else if (checkNum.equals("Odd")){
                        for (int i = 0; i<array.length; i++) {
                            if (i%2!=0){
                                System.out.print(array[i]+ " ");
                            }
                        }
                    }
                    break;


            }
            input=scanner.nextLine();
        }

        //  System.out.println();
        System.out.printf("%nYou crafted ");
        for (int i = 0; i<array.length; i++){
            System.out.print(array[i]);
        }
        System.out.print("!");


    }
}
