package x11_Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class x06_EqualArrays2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] secondNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        boolean arraysAreEqual;
        int sum = 0;
        int differenceIndex = 0;

        if(firstNumbers.length != secondNumbers.length){
arraysAreEqual = false;
differenceIndex = Math.min(firstNumbers.length, secondNumbers.length);
        }else{
            arraysAreEqual = true;
            for (int i = 0; i < firstNumbers.length; i++){
                sum += firstNumbers[i];

                if(firstNumbers[i] != secondNumbers[i]){
                    arraysAreEqual = false;
                    differenceIndex = i;
                }
            }
        }
        if(arraysAreEqual){
            System.out.println(sum);
        }else{
            System.out.println(differenceIndex);
        }
        System.out.println(arraysAreEqual);
    }
}
