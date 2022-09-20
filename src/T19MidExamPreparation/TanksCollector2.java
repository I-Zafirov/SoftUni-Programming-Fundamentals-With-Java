package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TanksCollector2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] list = scanner.nextLine().split(", ");
        List<String> tanks = new ArrayList<>(Arrays.asList(list));
        int numberOfCommand = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommand; i++) {
            String[] command = scanner.nextLine().split(", ");

            switch (command[0]) {
                case "Add": {
                    String tankName = command[1];
                    if (tanks.contains(tankName)) {
                        System.out.println("Tank is already bought");
                    } else {
                        System.out.println("Tank successfully bought");
                        tanks.add(tankName);
                    }
                }
                break;
                case "Remove": {
                    String tankName = command[1];
                    if (tanks.contains(tankName)) {
                        System.out.println("Tank successfully sold");
                        tanks.remove(tankName);
                    } else {
                        System.out.println("Tank not found");
                    }
                }
                break;
                case "Remove At": {
                    int index = Integer.parseInt(command[1]);
                    if (index >= 0 && index < tanks.size()) {
                        tanks.remove(index);
                        System.out.println("Tank successfully sold");
                    } else {
                        System.out.println("Index out of range");
//                        continue;
                    }
                }
                break;
                case "Insert": {
                    int index = Integer.parseInt(command[1]);
                    String tankName = command[2];
                    if (index >= 0 && index < tanks.size()) {
                        if (tanks.contains(tankName)) {
                            System.out.println("Tank is already bought");
                        } else {

                            tanks.add(index, tankName);
                            System.out.println("Tank successfully bought");
                        }

                    } else {
                        System.out.println("Index out of range");
                    }
                }
                break;
            }
        }
        for (int i = 0; i < tanks.size(); i++) {
            if ((i) == (tanks.size() - 1)) {
                System.out.print(tanks.get(i));
            } else {
                System.out.print(tanks.get(i)+", ");
            }
        }



    }
}
