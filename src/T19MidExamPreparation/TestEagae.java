package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestEagae {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> arrayList = Arrays.stream(scanner.nextLine()
                        .split(","))
                .collect(Collectors.toList());

        String input = "";

        while (!"Retire!".equals(input = scanner.nextLine())) {

            String[] array = input.split("\\- |\\:");
            String command = array[0].trim();
            switch (command) {
                case "Start":
                    if (!arrayList.contains(array[1])) {
                        arrayList.add(array[1]);
                    }
                    break;
                case "Complete":
                    if (arrayList.contains(array[1])) {
                        arrayList.remove(array[1]);
                    }

                    break;
                case "Side Quest":
                    int indеx = arrayList.indexOf(array[1]);
                    if (arrayList.contains(array[1])){
                    }
                    if (!arrayList.contains(array[2])){
                        arrayList.add(indеx + 1, array[2]);
                    }


                    break;
                case "Renew":
                    String indexNumber = array[1];
                    if (arrayList.contains(array[1])) {
                        arrayList.remove(array[1]);
                        arrayList.add(indexNumber);

                    }
                    break;
                default:



            }
        }
        System.out.println(String.join(",", arrayList));
    }
}
