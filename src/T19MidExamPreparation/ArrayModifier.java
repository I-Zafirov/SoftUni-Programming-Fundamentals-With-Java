package T19MidExamPreparation;

import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] numbers = Arrays
//                .stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(e -> Integer.parseInt(e))
//                .toArray();

        String line = scanner.nextLine();
        int[] numbers = parseArray(line);

        while(true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }

            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command){
                case "swap":
                    swap(numbers, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "multiply":
                    multiply(numbers, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "decrease":
                    decrease(numbers);
                    break;
            }
        }
        printArray(", ", numbers);
        //System.out.println (Arrays.toString (numbers).replaceAll ("[\\[\\]]", ""));
    }

    private static void decrease(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]--;
        }
    }

    private static void multiply(int[] array, int indexA, int indexB) {
        array[indexA] = array[indexA] * array[indexB];
    }

    private static void swap(int[] array, int indexA, int indexB) {
        int oldA = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = oldA;
    }

    private static void printArray(String separator, int[] array){

        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + separator);
        }
        System.out.println(array[array.length - 1]);

//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]);
//            if (i <array.length - 1){
//                System.out.print(separator);
//            }
//        }
    }

    private static int[] parseArray(String numbersString){
        String[] numbersAsStrings = numbersString.split(" ");
        int[] array = new int[numbersAsStrings.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        return array;
    }
}
