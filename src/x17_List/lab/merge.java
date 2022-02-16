package x17_List.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class merge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sortedA = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> sortedB = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int indexA = 0;
        int indexB = 0;
        List<Integer> merged = new ArrayList<>();

        while (indexA < sortedA.size() || indexB < sortedB.size()){
            if(indexA < sortedA.size() && sortedA.get(indexA) > sortedB.get(indexB)){
                merged.add(sortedA.get(indexA));
                indexA++;
            }else{
                merged.add(sortedB.get(indexB));
                indexB++;
            }
        }
        for(int number : merged){
            System.out.print(number + " ");
        }
    }
}
