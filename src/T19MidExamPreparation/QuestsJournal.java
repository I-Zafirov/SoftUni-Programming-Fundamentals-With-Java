package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = "";

        while(!"Retire!".equals(input = scanner.nextLine())){
            String[] data = input.split(" - |:");

            String command = data[0].trim();
            String quest = data[1].trim();

            switch (command) {
                case "Start":
                    if (!journal.contains(quest)){
                        journal.add(quest);
                    }
                    break;

                case "Complete":
                    journal.remove(quest);
                    break;

                case "Side Quest":
                    String sideQuest = data[2].trim();
                    if (journal.contains(quest) && !journal.contains(sideQuest)) {
                        journal.add(journal.indexOf(quest) + 1,sideQuest);
                    }
                    break;

                case "Renew":
                    if (journal.contains(quest)) {
                        journal.add(quest);
                        journal.remove(quest);
                    }
                    break;
            }
        }

        System.out.println(journal.toString().replaceAll("[\\[\\]]",""));
    }
}
