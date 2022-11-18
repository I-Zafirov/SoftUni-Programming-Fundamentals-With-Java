package T33FinExamPreparation;

import java.util.*;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();
        List<Integer> biggerThanAverage = new ArrayList<>();

        double average = 0;

        for(int i = 0; i<numbers.length; i++){
            average +=numbers[i];
        }
        average/=numbers.length;

        for(int i = 0; i<numbers.length; i++){
            if(numbers[i]>average){
                biggerThanAverage.add(numbers[i]);
            }
        }
        if(biggerThanAverage.isEmpty()){
            System.out.print("No");
        }
        biggerThanAverage.sort(Collections.reverseOrder());

        for(int i = 0; i<biggerThanAverage.size(); i++){
            if(i>4){
                break;
            }
            System.out.print(biggerThanAverage.get(i) + " ");
        }
    }
}
