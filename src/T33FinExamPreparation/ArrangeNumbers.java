package T33FinExamPreparation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrangeNumbers {
    static Map<String, Integer> numberCodes = new HashMap<>();

    public static boolean check(String number1, String number2) {
        int length;
        if (number1.length() >= number2.length()) {
            length = number2.length();
            if (number1.substring(0, length).equals(number2.substring(0, length))) {
                return false;
            }
        } else {
            length = number1.length();
            if (number1.substring(0, length).equals(number2.substring(0, length))) {
                return true;
            }
        }

        for (int i = 0; i < length; i++) {
            if (numberCodes.get(number1.substring(i, i + 1)) < numberCodes.get(number2.substring(i, i + 1))) {
                return true;
            } else if (numberCodes.get(number1.substring(i, i + 1)) > numberCodes.get(number2.substring(i, i + 1))) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(", ");
        //8, 5, 4, 9, 1, 7, 6, 3, 2, 0
        numberCodes.put("8", 0);
        numberCodes.put("5", 1);
        numberCodes.put("4", 2);
        numberCodes.put("9", 3);
        numberCodes.put("1", 4);
        numberCodes.put("7", 5);
        numberCodes.put("6", 6);
        numberCodes.put("3", 7);
        numberCodes.put("2", 8);
        numberCodes.put("0", 9);

        for (int i = 0; i < numbers.length; i++) {
            int index = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (check(numbers[j], numbers[index])) {
                    index = j;
                }
            }
            String temp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = temp;
        }
        System.out.print(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            System.out.print(", " + numbers[i]);
        }
    }
}
