package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Groceries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Go Shopping!")) {
            if (command.split(" ")[0].equals("Urgent")) {
                if (!groceries.contains(command.split(" ")[1])) {
                    groceries.add(0, (command.split(" ")[1]));
                }
            } else if (command.split(" ")[0].equals("Unnecessary")) {
                if (groceries.contains(command.split(" ")[1])) {
                    String tempWord = command.split(" ")[1];
                    groceries.remove(tempWord);
                }
            } else if (command.split(" ")[0].equals("Correct")) {
                if (groceries.contains(command.split(" ")[1])) {
                    String oldWord = command.split(" ")[1];
                    int oldIndex = groceries.indexOf(oldWord);
                    String newWord = command.split(" ")[2];
                    groceries.remove(oldIndex);
                    groceries.add(oldIndex, newWord);
                }
            } else if (command.split(" ")[0].equals("Rearrange")) {
                if (groceries.contains(command.split(" ")[1])) {
                    String tempWord = command.split(" ")[1];
                    groceries.remove(tempWord);
                    groceries.add(groceries.size(), tempWord);
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(groceries.toString().replaceAll("[\\[\\]]", ""));
    }
}
