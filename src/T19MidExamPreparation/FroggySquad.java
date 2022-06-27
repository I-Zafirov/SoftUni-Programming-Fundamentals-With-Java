package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FroggySquad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
        while (true) {
            String[] command = scanner.nextLine().split("\\s+");
            if (command[0].equals("Print")) {
                if (command[1].equals("Reversed")) {
                    System.out.print("Frogs: ");
                    for (int i = list.size() - 1; i >= 0; i--) {
                        System.out.print(list.get(i) + " ");
                    }
                    System.out.println();
                    break;
                }
                if (command[1].equals("Normal")) {
                    System.out.print("Frogs: ");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print(list.get(i) + " ");
                    }
                    System.out.println();
                }
                break;
            } else if (command[0].equals("Join")) {
                list.add(command[1]);
            } else if (command[0].equals("Jump")) {
                int index = Integer.parseInt(command[2]);
                if (index >= 0 && index < list.size()) {
                    list.add(index, command[1]);
                }
            } else if (command[0].equals("Dive")) {
                int index = Integer.parseInt(command[1]);
                if (index >= 0 && index < list.size()) {
                    list.remove(index);
                }

            } else if (command[0].equals("First")) {
                int count = Integer.parseInt(command[1]);
                if (count > list.size() ) {
                    count = list.size() ;
                }
                for (int i = 0; i < count; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();

            } else if (command[0].equals("Last")) {
                int count = Integer.parseInt(command[1]);
                if (count > list.size() ) {
                    count = list.size() ;
                }

                for (int i = list.size() - count; i <= list.size() - 1; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();

            }

        }
    }

}
