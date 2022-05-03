package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _P2_AndReverseSortRemoveNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while(!input.equals("end")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "reverse":
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endCount = Integer.parseInt(tokens[4]);
                    Collections.reverse(numbers.subList(startIndex, startIndex + endCount));
                    break;
                case "sort":
                    startIndex = Integer.parseInt(tokens[2]);
                    endCount = Integer.parseInt(tokens[4]);
                    Collections.sort(numbers.subList(startIndex, startIndex + endCount));
                    break;
                case "remove":
                    int removeCount = Integer.parseInt(tokens[1]);
                    while (removeCount > 0){
                        numbers.remove(0);
                        removeCount--;
                    }
                    break;

            }

            input = scan.nextLine();
        }
        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if(i == numbers.size() - 1){
                System.out.print(numbers.get(i));
            }else {
                System.out.print(numbers.get(i) + " ");
            }
        }
    }

    private static boolean isValid(int startIndex, int count, int size) {
        return startIndex >= 0 && count <= size - 1;
    }
}
