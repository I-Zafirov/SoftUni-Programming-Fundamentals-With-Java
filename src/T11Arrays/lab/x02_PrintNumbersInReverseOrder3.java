package T11Arrays.lab;

import java.util.Scanner;

public class x02_PrintNumbersInReverseOrder3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        String value = scanner.nextLine();
        String[] items = value.split(" ");
        //int[] arr = new int[items.length];

        for (int i = 0; i < items.length - 1; i--) {
            arr[i] = Integer.parseInt(items[i]);
        }
    }
}
