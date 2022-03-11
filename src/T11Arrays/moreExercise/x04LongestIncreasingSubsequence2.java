package T11Arrays.moreExercise;

import java.util.Scanner;

public class x04LongestIncreasingSubsequence2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[] {3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1};

        int[] lisLengths = new int[numbers.length];
        int[] lisPrev = new int[numbers.length];
        for (int i = 0; i < lisLengths.length; i++) {
            lisLengths[i] = 1;
            lisPrev[i] = -1;
        }
        for (int currentIndex = 1; currentIndex < numbers.length; currentIndex++) {
            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {
                if(numbers[prevIndex] < numbers[currentIndex]){
                    int candidateLength = lisLengths[prevIndex] + 1;
                    if(candidateLength > lisLengths[currentIndex]){
                        lisLengths[currentIndex] = candidateLength;
                        lisPrev[currentIndex] = prevIndex;
                    }
                }
            }
        }
        for(int lisLength : lisLengths){
            System.out.print(lisLength + " ");
        }
        System.out.println();

        int maxLength = 0;
        int maxLengthIndex = -1;

        for(int i = 0; i < lisLengths.length; i++){
            if(lisLengths[i] > maxLength){
                maxLength = lisLengths[i];
                maxLengthIndex = i;
            }
        }
        System.out.println(maxLength);

       int index = maxLengthIndex;
       int[] lis = new int[maxLength]; //ArrayList<Integer> lis = new ArrayList<Integer>();
       int pos = 0;                    //

       while (index != -1){
           lis[pos] = numbers[index]; //Lis.add(numbers[index]);
           pos++;                     //
           System.out.println(numbers[index]);
           index = lisPrev[index];
       }
    }

}
