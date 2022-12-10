package T33FinExamPreparation;

import java.util.*;

public class ThePianist3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> piecesCollection = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String piecesInput = scanner.nextLine();
            String[] tokens = piecesInput.split("\\|");

            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            piecesCollection.put(piece, Arrays.asList(composer, key));
        }
        String inputCommands = scanner.nextLine();
        while (!inputCommands.equals("Stop")) {
            String[] commandTokens = inputCommands.split("\\|");
            String command = commandTokens[0];
            String piece = commandTokens[1];
            switch (command) {
                case "Add":
                    String composer = commandTokens[2];
                    String key = commandTokens[3];
                    if (piecesCollection.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        piecesCollection.put(piece, Arrays.asList(composer, key));
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (piecesCollection.containsKey(piece)) {
                        System.out.printf("Successfully removed %s!%n", piece);
                        piecesCollection.remove(piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commandTokens[2];
                    if (piecesCollection.containsKey(piece)) {
                        piecesCollection.get(piece).set(1, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }

            inputCommands = scanner.nextLine();
        }
        piecesCollection.entrySet().stream()
                .sorted((left, right) -> {
                    int result = left.getKey().compareTo(right.getKey());
                    if (result == 0) {
                        result = left.getValue().get(0).compareTo(right.getValue().get(0));
                    }
                    return result;
                }).forEach(piece -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        piece.getKey(), piece.getValue().get(0), piece.getValue().get(1)));
    }
}
