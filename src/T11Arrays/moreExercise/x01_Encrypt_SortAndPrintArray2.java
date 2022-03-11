package T11Arrays.moreExercise;

import java.util.Scanner;

public class x01_Encrypt_SortAndPrintArray2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
// 65-97  69-101  73-105  79-111  85-117
        int[] arrSum = new int[input];

        for (int j = 0; j < input; j++) {
            int sumVowels = 0;
            int sumConsonants = 0;
            int sum = 0;

            String string = scanner.nextLine();
            char[] chars = new char[string.length()];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = string.charAt(i);
            }
            int[] number = new int[string.length()];
            for (int index = 0; index < number.length; index++) {
                number[index] = chars[index];
                if (number[index] == 65 || number[index] == 97 || number[index] == 69 ||
                        number[index] == 101 || number[index] == 73 || number[index] == 105 ||
                        number[index] == 79 || number[index] == 111 || number[index] == 85 ||
                        number[index] == 117) {
                    int currentValueVowels = number[index] * string.length();
                    sumVowels += currentValueVowels;
                } else {
                    int currentValueConsonants = number[index] / string.length();
                    sumConsonants += currentValueConsonants;
                }
            }
            sum = sumConsonants + sumVowels;
            arrSum[j] = sum;
        }
        int temporary = 0;
        for (int i = 0; i < input; i++) {
            for (int j = i + 1; j < input; j++) {
                if (arrSum[i] > arrSum[j]) {
                    temporary = arrSum[i];
                    arrSum[i] = arrSum[j];
                    arrSum[j] = temporary;
                }
            }
        }
        for (int i = 0; i < input; i++) {
            System.out.println(arrSum[i]);
        }
    }
}
