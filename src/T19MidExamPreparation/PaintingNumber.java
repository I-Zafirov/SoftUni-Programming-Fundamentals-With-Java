package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PaintingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("END")){
            if (command.split(" ")[0].equals("Change")){
                int paintingNumber = Integer.parseInt(command.split(" ")[1]);
                int changeNumber = Integer.parseInt(command.split(" ")[2]);
                if (numbers.contains(paintingNumber)){
                    int tempIndex = numbers.indexOf(paintingNumber);
                    numbers.remove(tempIndex);
                    numbers.add(tempIndex, changeNumber);
                }
            } else if (command.split(" ")[0].equals("Hide")){
                int paintingNumber = Integer.parseInt(command.split(" ")[1]);
                int tempIndex = numbers.indexOf(paintingNumber);
                if (numbers.contains(paintingNumber)){
                    numbers.remove(tempIndex);
                }
            } else if (command.split(" ")[0].equals("Switch")) {
                int paintingNumber = Integer.parseInt(command.split(" ")[1]);
                int paintingNumber2 = Integer.parseInt(command.split(" ")[2]);
                if (numbers.contains(paintingNumber) && numbers.contains(paintingNumber2)){
                    int tempIndex1 = numbers.indexOf(paintingNumber);
                    int tempIndex2 = numbers.indexOf(paintingNumber2);
                    numbers.remove(tempIndex1);
                    numbers.add(tempIndex1, paintingNumber2);

                    numbers.remove(tempIndex2);
                    numbers.add(tempIndex2, paintingNumber);
                }
            } else if (command.split( " ")[0].equals("Insert")){
                int place = Integer.parseInt(command.split(" ")[1]);
                int paintingNumber = Integer.parseInt(command.split(" ")[2]);
                if (numbers.size() >= place){
                    //int tempIndex = numbers.indexOf(paintingNumber);
                    numbers.add(place + 1, paintingNumber);
                }
            } else if (command.split(" ")[0].equals("Reverse")){
                Collections.reverse(numbers);
            }
            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
