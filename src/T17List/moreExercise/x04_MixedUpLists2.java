package T17List.moreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class x04_MixedUpLists2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> merged = new ArrayList<>();

        int startIndexInFirst = 0;
        int startIndexInSecond = secondNumbers.size() - 1;

        while (startIndexInFirst < firstNumbers.size() || startIndexInSecond >= 0){
            if (startIndexInFirst < firstNumbers.size()){
                merged.add(firstNumbers.get(startIndexInFirst));
            }
            if (startIndexInSecond >= 0){
                merged.add(secondNumbers.get(startIndexInSecond));
            }
            startIndexInFirst++;
            startIndexInSecond--;
        }
        int startExcluding = Math.min(merged.get(merged.size() - 2), merged.get(merged.size() - 1));
        int endExcluding = Math.max(merged.get(merged.size() - 2), merged.get(merged.size() - 1));

        List<Integer> result = new ArrayList<>();

        for (Integer integer : merged) {
            if (integer > startExcluding && integer < endExcluding) {
                result.add(integer);
            }
        }
        Collections.sort(result);
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
