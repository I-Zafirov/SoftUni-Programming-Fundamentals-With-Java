package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> chestContent = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Yohoho!")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Loot":
                    for (int i = 1; i <= tokens.length - 1 ; i++) {
                        String currentItem = tokens[i];
                        if(!chestContent.contains(currentItem)){
                            chestContent.add(0, currentItem);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if(isValid(index, chestContent.size())){
                        String item = chestContent.get(index);
                        chestContent.remove(index);
                        chestContent.add(item);
                    }else {
                        break;
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    List<String> stolenItems = new ArrayList<>();
                    if(count >= chestContent.size()){
                        System.out.println(String.join(", ", chestContent));
                        chestContent.clear();
                        break;
                    }else{
                        for (int i = 0; i < count; i++) {
                            int lastIndex = chestContent.size() - 1;
                            stolenItems.add(0,chestContent.remove(lastIndex));
                        }
                        System.out.println(String.join(", ",stolenItems));
                    }

                    break;

            }

            input = scan.nextLine();
        }

        int sumOfAllElements = 0;
        for (String chestElement : chestContent) {
            sumOfAllElements += chestElement.length();
        }
        if(sumOfAllElements == 0){
            System.out.println("Failed treasure hunt.");
        }else {
            double average = 1.0 * sumOfAllElements / chestContent.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.",average);
        }


    }

    private static boolean isValid(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
