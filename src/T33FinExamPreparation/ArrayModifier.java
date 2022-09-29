package T33FinExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arrayList = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String[] command = scan.nextLine().split(" ");

        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "swap":
                    int starterPosition = Integer.parseInt(command[1]);
                    int secondPosition = Integer.parseInt(command[2]);
                    int oldIndex = arrayList[starterPosition];

                    arrayList[starterPosition] = arrayList[secondPosition];
                    arrayList[secondPosition] = oldIndex;
                    break;
                case "multiply":
                    int starterIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);

                    arrayList[starterIndex] *= arrayList[secondIndex];
                    break;
                case "decrease":
                    for (int i = 0; i < arrayList.length; i++) {
                        arrayList[i]--;
                    }
                    break;
            }
            command = scan.nextLine().split(" ");
        }
        for (int i = 0; i < arrayList.length; i++) {
            if (i == arrayList.length - 1) {
                System.out.print(arrayList[i]);
                break;
            }
            System.out.print(arrayList[i] + ", ");
        }
    }
}
