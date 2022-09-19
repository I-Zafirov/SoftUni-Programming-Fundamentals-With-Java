package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SugarCubes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> sequence = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Mort")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){

                case "Add":
                    int valueTobeAdded = Integer.parseInt(tokens[1]);
                    sequence.add(valueTobeAdded);
                    break;
                case "Remove":
                    int valueToBeRemoved = Integer.parseInt(tokens[1]);
                    int indexToBeRemove = sequence.indexOf(valueToBeRemoved);
                    if(sequence.contains(valueToBeRemoved)){
                        sequence.remove(indexToBeRemove);
                    }
                    break;
                case "Replace":
                    int valueToBeReplaced = Integer.parseInt(tokens[1]);
                    int replacement = Integer.parseInt(tokens[2]);
                    int replaceIndex = sequence.indexOf(valueToBeReplaced);
                    if(sequence.contains(valueToBeReplaced)){
                        sequence.set(replaceIndex, replacement);
                    }
                    break;
                case "Collapse":
                    int collapseValue = Integer.parseInt(tokens[1]);
                    sequence.removeIf(integer -> integer < collapseValue);
                    break;

            }


            input = scan.nextLine();
        }
        for (Integer integer : sequence) {
            System.out.print(integer + " ");
        }
    }
}
