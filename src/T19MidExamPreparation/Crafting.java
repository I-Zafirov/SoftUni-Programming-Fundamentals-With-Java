package T19MidExamPreparation;

import java.util.Scanner;

public class Crafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split("\\|");

        while (true){
            String input = scanner.nextLine();
            if ("Done".equals(input)){
                break;
            }
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Move":
                    int index = Integer.parseInt(tokens[2]);
                    if ("Left".equals(tokens[1])){
                        int leftIndex = index - 1;
                        if (leftIndex >= 0 && leftIndex < parts.length - 1){
                            String swap = parts[leftIndex];
                            parts[leftIndex] = parts[index];
                            parts[index] = swap;
                        }

                    }else if ("Right".equals(tokens[1])){
                        int rightIndex = index + 1;
                        if (rightIndex > 0 && rightIndex < parts.length){
                            String swap = parts[rightIndex];
                            parts[rightIndex] = parts[index];
                            parts[index] = swap;
                        }
                    }
                    break;
                case "Check":
                    if ("Even".equals(tokens[1])){
                        for (int i = 0; i < parts.length; i++) {
                            if (i % 2 == 0){
                                System.out.print(parts[i]);
                                if (i < parts.length - 1){
                                    System.out.print(" ");
                                }
                            }
                        }
                        System.out.println();
                    }else if ("Odd".equals(tokens[1])){
                        for (int i = 0; i < parts.length; i++) {
                            if (i % 2 != 0){
                                System.out.print(parts[i]);
                                if (i < parts.length - 1){
                                    System.out.print(" ");
                                }
                            }
                        }
                        System.out.println();
                    }
                    break;
            }
        }
        String weaponName = "";
        for (int i = 0; i < parts.length; i++) {
            weaponName += parts[i];
        }
        System.out.printf("You crafted %s!", weaponName);
    }
}
