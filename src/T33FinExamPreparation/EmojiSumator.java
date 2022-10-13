package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int[] ch = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        //int sumCh= Arrays.stream(ch).sum();
        String form = "";
        for (int i : ch) {
            form += (char) i;
        }
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\s:([a-z]{4,}):(?=[ ,.!?])");
        Matcher matcher = pattern.matcher(text);
        int sum = 0;
        while (matcher.find()) {
            String found = matcher.group(1);
            list.add(found);
            int currentSum = 0;
            for (char c : found.toCharArray()) {
                currentSum += (int) c;
            }

            sum += currentSum;


        }
        if (list.contains(form)) {
            sum *= 2;
        }
        if (!list.isEmpty()) {
            System.out.print("Emojis found: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(":" + list.get(i) + ":");
                if (i != list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println("Total Emoji Power: " + sum);


    }
}
