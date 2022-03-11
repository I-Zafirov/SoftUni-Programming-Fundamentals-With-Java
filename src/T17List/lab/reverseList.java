package T17List.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class reverseList {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        while (!word.equals(".")) {
            words.add(word);
            word = scanner.nextLine();
        }
        for (int i = words.size() - 1; i >= 0; i--) {
            System.out.println(words.get(i));
        }
    }
}
