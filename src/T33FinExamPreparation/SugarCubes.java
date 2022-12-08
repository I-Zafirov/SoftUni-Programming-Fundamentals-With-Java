package T33FinExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SugarCubes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());
        String[] command = scan.nextLine().split(" ");

        while (!command[0].equals("Mort")) {

            switch (command[0]) {
                case "Add":
                    list.add(command[1]);
                    break;
                case "Remove":
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).equals(command[1])) {
                            list.remove(command[1]);
                            break;
                        }
                    }
                    break;
                case "Replace":
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).equals(command[1])) {
                            list.set(i, command[2]);
                            break;
                        }
                    }
                    break;
                case "Collapse":
                    int value = Integer.parseInt(command[1]);
                    for (int i = list.size() - 1; i >= 0; i--) {
                        int currentNumber = Integer.parseInt(list.get(i));
                        if (currentNumber < value) {
                            list.remove(list.get(i));
                        }
                    }
                    break;
            }
            command = scan.nextLine().split(" ");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
