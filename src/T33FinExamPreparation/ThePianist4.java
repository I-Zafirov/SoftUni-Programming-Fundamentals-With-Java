package T33FinExamPreparation;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class ThePianist4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String[]> pieceInfo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            pieceInfo.put(input[0], new String[]{input[1], input[2]});
        }
        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {
            String[] command = input.split("\\|");
            switch (command[0]) {
                case "Add":
                    if (pieceInfo.containsKey(command[1])) {
                        System.out.printf("%s is already in the collection!%n", command[1]);
                    } else {
                        pieceInfo.put(command[1], new String[]{command[2], command[3]});
                        System.out.printf("%s by %s in %s added to the collection!%n", command[1], command[2], command[3]);
                    }
                    break;
                case "Remove":
                    if (pieceInfo.containsKey(command[1])) {
                        pieceInfo.remove(command[1]);
                        System.out.printf("Successfully removed %s!%n", command[1]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", command[1]);
                    }
                    break;
                case "ChangeKey":
                    if (pieceInfo.containsKey(command[1])) {
                        pieceInfo.get(command[1])[1] = command[2];
                        System.out.printf("Changed the key of %s to %s!%n", command[1], command[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", command[1]);
                    }
                    break;
            }
        }
        pieceInfo.entrySet().stream()
                .sorted(Comparator.comparing((Function<Map.Entry<String, String[]>, String>) Map.Entry::getKey)
                        .thenComparing(a -> a.getValue()[0])).forEach(entry ->
                        System.out.printf("%s -> Composer: %s, Key: %s%n",
                                entry.getKey(), entry.getValue()[0], entry.getValue()[1]));
    }
}
