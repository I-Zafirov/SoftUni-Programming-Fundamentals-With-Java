package T17List.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class x07_AppendArrays1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //"1 2 3 |4 5 6 |  7  8"
        List<String> listNumbers = Arrays
                .stream(input.split("\\|")).collect(Collectors.toList());
        Collections.reverse(listNumbers);
        //list.toString() ->
        // "[  7  8, 4 5 6 , 1 2 3 ]"
        // replace [ -> "  7  8, 4 5 6 , 1 2 3 ]"
        // replace ] -> "  7  8, 4 5 6 , 1 2 3 "
        // replace , -> "  7  8 4 5 6  1 2 3 "
        //trim() -> "7  8 4 5 6  1 2 3"
        //replace more than one interval -> "7 8 4 5 6 1 2 3"
        System.out.println(listNumbers.toString().replace("[", "")
                .replace("]", "")
                .replaceAll(",", "")
                .trim()
                .replaceAll("\\s+", " "));
    }
}
