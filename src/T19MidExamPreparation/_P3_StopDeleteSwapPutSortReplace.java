package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _P3_StopDeleteSwapPutSortReplace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = new ArrayList<String>();
        words = getInput(scan);
        String manipulation = scan.nextLine();
        while (!manipulation.equals("Stop")) {
            String[] command = manipulation.split(" ");
            switch (command[0]) {
                case "Delete":
                    words = removeFromList(words, Integer.parseInt(command[1]));
                    break;
                case "Swap":
                    words = swapWords(words, command[1], command[2]);
                    break;
                case "Put":
                    words = addToList(words, command[1], Integer.parseInt(command[2]));
                    break;
                case "Sort":
                    words = sortList(words);
                    break;
                case "Replace":
                    words = replaceWord(words, command[1], command[2]);
                    break;
            }
            manipulation = scan.nextLine();
        }
        printDeck(words, " ");

    }

    private static void printDeck(List<String> words, String delimiter) {
        String output = "";
        for (String index : words) {
            output += (index + delimiter);
        }
        System.out.println(output);

    }

    private static List<String> replaceWord(List<String> words, String first, String second) {
        if (words.contains(second)) {
            int index = words.indexOf(second);
            words.set(index, first);
        }
        return words;
    }

    private static List<String> sortList(List<String> words) {
        Collections.sort(words);
        Collections.reverse(words);
        return words;
    }

    private static List<String> addToList(List<String> words, String word, int index) {
        index--;
        if ((0 <= index) && (index < words.size())) {
            words.add(index, word);
        }
        if (words.size() == index) {
            words.add(word);
        }
        return words;
    }

    private static List<String> swapWords(List<String> words, String first, String second) {
        if (words.contains(first) && words.contains(second)) {
            int indexFirst = words.indexOf(first);
            int indexSecond = words.indexOf(second);
            words.set(indexFirst, second);
            words.set(indexSecond, first);
        }
        return words;
    }

    private static List<String> removeFromList(List<String> words, int index) {
        index++;
        if ((0 <= index) && (index < words.size())) {
            words.remove(index);
        }
        return words;
    }

    private static List<String> getInput(Scanner scan) {
        List<String> output = new ArrayList<String>();
        String[] input = scan.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            output.add(input[i]);
        }
        return output;
    }
}
