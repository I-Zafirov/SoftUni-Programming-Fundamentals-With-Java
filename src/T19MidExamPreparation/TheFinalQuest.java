package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        while (true){
            String input = scanner.nextLine();
            if (input.equals("Stop")){
                break;
            }

            String[] instructions = input.split("\\s+");
            String command = instructions[0];

            switch (command){
                case "Delete":
                    delete(words, Integer.parseInt(instructions[1]));
                    break;
                case "Swap":
                    swap(words, instructions[1], instructions[2]);
                    break;
                case "Put":
                    put(words, instructions[1], Integer.parseInt(instructions[2]));
                    break;
                case "Sort":
                    Collections.sort(words);
                    Collections.reverse(words);
                    break;
                case "Replace":
                    replace(words, instructions[1], instructions[2]);
                    break;
            }
        }
        System.out.println(String.join(" ", words));
    }

    private static void replace(List<String> list, String word1, String word2) {
        if (list.contains(word2)){
            list.set(list.indexOf(word2), word1);
        }
    }

    private static void put(List<String> list, String word, int index) {
        int previousIndex = index - 1;
        if (previousIndex >= 0 && previousIndex < list.size()){
            list.add(previousIndex, word);
        } else if (previousIndex == list.size()){
            list.add(word);
        }
    }

    private static void swap(List<String> list, String word1, String word2) {
        if (list.contains(word1) && list.contains(word2)){
            Collections.swap(list, list.indexOf(word1), list.indexOf(word2));
        }
    }

    private static void delete(List<String> list, int index) {
        int indexAfterTheGivenIndex = index + 1;
        if (indexAfterTheGivenIndex >= 0 && indexAfterTheGivenIndex < list.size()){
            list.remove(indexAfterTheGivenIndex);
        }
    }
}
