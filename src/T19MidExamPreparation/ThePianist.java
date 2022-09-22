package T19MidExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, String[]> collection = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\|");

            String piece = input[0];
            String name = input[1];
            String key = input[2];

            String[] info = new String[]{name, key};
            collection.put(piece, info);
        }

        String[] commands = scan.nextLine().split("\\|");

        while (!commands[0].equals("Stop")) {
            String piece = commands[1];

            switch (commands[0]) {
                case "Add":
                    String name = commands[2];
                    String key = commands[3];

                    if (collection.containsKey(piece)) {
                        System.out.println(piece + " is already in the collection!");
                    } else {
                        String[] info = new String[]{name, key};
                        collection.put(piece, info);

                        System.out.printf("%s by %s in %s added to the collection!\n", piece, name, key);
                    }
                    break;
                case "Remove":
                    if (collection.containsKey(piece)) {
                        collection.remove(piece);

                        System.out.println("Successfully removed " + piece + "!");
                    } else {
                        System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    String newKey = commands[2];

                    if (collection.containsKey(piece)) {
                        String oldName = collection.get(piece)[0];
                        String[] override = new String[]{oldName, newKey};

                        collection.put(piece, override);
                        System.out.printf("Changed the key of %s to %s!\n", piece, newKey);
                    }else{
                        System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
                    }
                    break;
            }
            commands = scan.nextLine().split("\\|");
        }

        collection.entrySet()
                .stream()
                .forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s\n", e.getKey(), e.getValue()[0], e.getValue()[1]));
    }
}
