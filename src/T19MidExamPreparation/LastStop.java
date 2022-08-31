package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true){
            String input = scanner.nextLine();
            if (input.equals("END")){
                break;
            }
            String[] instructions = input.split(" ");
            String command = instructions[0];

            switch (command){
                case "Change":
                    change(numbers, Integer.parseInt(instructions[1]), Integer.parseInt(instructions[2]));
                    break;
                case "Hide":
                    hide(numbers, Integer.parseInt(instructions[1]));
                    break;
                case "Switch":
                    switchTwoPaintings(numbers, Integer.parseInt(instructions[1]), Integer.parseInt(instructions[2]));
                    break;
                case "Insert":
                    insert(numbers, Integer.parseInt(instructions[1]), Integer.parseInt(instructions[2]));
                    break;
                case "Reverse":
                    Collections.reverse(numbers);
                    break;
            }
        }
        printArray(" ", numbers);
    }

    private static void insert(List<Integer> list, int place, int paintingNumber) {
        if (0 <= place && place < list.size()){
            list.add(place + 1, paintingNumber);
        }
    }

    private static void switchTwoPaintings(List<Integer> list, int paintingNumber, int paintingNumber2) {
        if (list.contains(paintingNumber) && list.contains(paintingNumber2)){
            Collections.swap(list, list.indexOf(paintingNumber), list.indexOf(paintingNumber2));

//            int oldIndexOfPaintingNumber2 = list.indexOf(paintingNumber2);
//            list.set(list.indexOf(paintingNumber), paintingNumber2);
//            list.set(oldIndexOfPaintingNumber2, paintingNumber);
        }
    }

    private static void hide(List<Integer> list, int paintingNumber) {
        if (list.contains(paintingNumber)){
            list.remove((Integer)paintingNumber);
        }
    }

    private static void change(List<Integer> list, int paintingNumber, int changedNumber) {
        if (list.contains(paintingNumber)){
            list.set(list.indexOf(paintingNumber), changedNumber);
        }
    }

    private static void printArray(String separator, List<Integer> array){
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
            if (i <array.size() - 1){
                System.out.print(separator);
            }
        }
    }
}
