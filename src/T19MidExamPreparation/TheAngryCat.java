package T19MidExamPreparation;

import java.util.Scanner;

public class TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String values = scanner.nextLine();
        String[] items = values.split(", ");
        int[] arr = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            arr[i] = Integer.parseInt(items[i]);
        }

        int entryPointIndex = Integer.parseInt(scanner.nextLine());
        int entryPoint = arr[entryPointIndex];
        String typeOfItems = scanner.nextLine();

        int rightExpensive = 0, leftExpensive = 0;
        int rightCheap = 0, leftCheap = 0;

        for (int i = entryPointIndex + 1; i < arr.length; i++) {
            if (arr[i] < entryPoint) {
                rightCheap += arr[i];
            } else {
                rightExpensive += arr[i];
            }
        }

        for (int i = 0; i < entryPointIndex; i++) {
            if (arr[i] < entryPoint) {
                leftCheap += arr[i];
            } else {
                leftExpensive += arr[i];
            }
        }

        if (typeOfItems.equals("cheap")) {
            if (rightCheap > leftCheap) {
                System.out.printf("Right - %d", rightCheap);
            } else {
                System.out.printf("Left - %d", leftCheap);
            }
        } else if (typeOfItems.equals("expensive")) {
            if (rightExpensive > leftExpensive) {
                System.out.printf("Right - %d", rightExpensive);
            } else {
                System.out.printf("Left - %d", leftExpensive);
            }
        }
    }
}
