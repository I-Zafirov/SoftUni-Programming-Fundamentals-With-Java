package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastStop2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> paintList = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String input;

        while (!"END".equals(input = scan.nextLine())) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Change":
                    if (paintList.contains(command[1])) {
                        paintList.set(paintList.indexOf(command[1]), command[2]);
                    }
                    break;
                case "Hide":
                    paintList.remove(command[1]);
                    break;
                case "Switch":
                    if (paintList.contains(command[1]) && paintList.contains(command[2])) {
                        Collections.swap(paintList, paintList.indexOf(command[1]), paintList.indexOf(command[2]));
                    }
                    break;
                case "Insert":
                    if (Integer.parseInt(command[1]) >= 0 && Integer.parseInt(command[1]) < paintList.size()) {
                        paintList.add(Integer.parseInt(command[1]) + 1, command[2]);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(paintList);
                    break;
            }
        }
        System.out.println(String.join(" ", paintList));
    }
}
