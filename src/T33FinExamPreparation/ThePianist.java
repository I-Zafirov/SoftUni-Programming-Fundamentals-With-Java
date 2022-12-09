package T33FinExamPreparation;

import java.util.Scanner;
import java.util.TreeMap;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, String> piecesByComposer = new TreeMap<>();
        TreeMap<String, String> keys = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            piecesByComposer.put(piece, composer);
            keys.put(piece, key);
        }
        while (true){
            String[] tokens = scanner.nextLine().split("\\|");
            String command = tokens[0];
            if ("Stop".equals(command)){
                break;
            }
            String piece = tokens[1];
            switch (command){
                case "Add":
                    String composer = tokens[2];
                    String key = tokens[3];
                    if (!piecesByComposer.containsKey(piece)){
                        piecesByComposer.put(piece, composer);
                        keys.put(piece, key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    } else{
                        System.out.printf("%s is already in the collection!%n", piece);
                    }
                    break;
                case "Remove":
                    if (!piecesByComposer.containsKey(piece)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    } else{
                        piecesByComposer.remove(piece);
                        keys.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = tokens[2];
                    if (!piecesByComposer.containsKey(piece)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }else{
                        keys.put(piece, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    }
                    break;
            }
        }
        piecesByComposer.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = f.getKey().compareTo(s.getKey());
                    if (f.getKey().equals(s.getKey())){
                        result = f.getValue().compareTo(s.getValue());
                    }
                    return result;
                })
                .forEach(entry -> {
                    System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue(),
                            keys.get(entry.getKey()));

                });
    }
}
