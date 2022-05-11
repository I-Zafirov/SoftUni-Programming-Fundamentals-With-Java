package T19MidExamPreparation;

import java.util.Scanner;

public class Commands3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = getArrayInt(scan.nextLine());
        String manipulation = scan.nextLine();
        while ((manipulation.equals("end")) != true) {
            array = manipulations(array, manipulation);
            manipulation = scan.nextLine();
        }
        printNumbers(array, ", ");
        scan.close();

    }

    private static void printNumbers(int[] array, String delimiter) {
        String output = "";
        for (int i = 0; i < array.length; i++) {
            if (i == (array.length - 1)) {
                output += array[i];
            }else {
                output += array[i] + delimiter;
            }
        }

        System.out.println(output);

    }

    private static int[] manipulations(int[] array, String manipulation) {
        String[] command = manipulation.split(" ");
        switch (command[0]) {
            case "reverse":
                array = getReverseFromTo(array, Integer.parseInt(command[2]), Integer.parseInt(command[4]));
                break;
            case "sort":
                array = getSortFromTo(array, Integer.parseInt(command[2]), Integer.parseInt(command[4]));
                break;
            case "remove":
                array = getRemove(array, Integer.parseInt(command[1]));
                break;

        }
        return array;
    }

    private static int[] getRemove(int[] array, int parseInt) {
        // TODO Auto-generated method stub
        return null;
    }

    private static int[] getSortFromTo(int[] array, int start, int count) {

        return null;
    }

    private static int[] getReverseFromTo(int[] array, int start, int count) {
        int[] output = new int[array.length];
        for (int i = (start + count) - 1, j = 0; i >= start; i--, j++) {
            output[j] = array[i];
        }
        for (int i = start, j = 0 ; i < (start + count); i++, j++) {
            array[i] = output[j];
        }
        return array;
    }

    private static int[] getArrayInt(String nextLine) {
        String[] input = nextLine.split(" ");
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = Integer.parseInt(input[i]);
        }
        return output;
    }
}
