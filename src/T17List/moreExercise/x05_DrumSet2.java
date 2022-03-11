package T17List.moreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class x05_DrumSet2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneySavings = Double.parseDouble(scanner.nextLine());

        List<Integer> initialSet  = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (Integer integer : initialSet) {
            result.add(integer);
        }

        while (true){
            String input = scanner.nextLine();
            if (input.equals("Hit it again, Gabsy!")){
                break;
            }

            int power = Integer.parseInt(input);

            int i = 0;
            while (i < result.size()) {
                int currentQuality = result.get(i);
                currentQuality -= power;
                if (currentQuality <= 0){
                    int price = initialSet.get(i) * 3;
                    if (price <= moneySavings){
                        currentQuality = initialSet.get(i);
                        moneySavings -= price;
                    }else{
                        result.remove(i);
                        initialSet.remove(i);
                        continue;
                    }
                }
                result.set(i, currentQuality);
                i++;
            }

        }
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", moneySavings);
    }
}
