package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ThePianist2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        Map<String, ClassPieces> mapPieces = new TreeMap<>();
        for (int i = 0; i < input; i++) {
            String[] inputPieces = scanner.nextLine().split("\\|");
//            {piece}|{composer}|{key}
            String piece = inputPieces[0];
            String composer = inputPieces[1];
            String key = inputPieces[2];
            ClassPieces objectPieces = new ClassPieces(composer, key);
            mapPieces.put(piece, objectPieces);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandLine = command.split("\\|");
            switch (commandLine[0]) {
                case "Add":
//                {piece}|{composer}|{key}
                    String piece = commandLine[1];
                    String composer = commandLine[2];
                    String key = commandLine[3];
                    if (!mapPieces.containsKey(piece)) {
                        ClassPieces objectAddPieces = new ClassPieces(composer, key);
                        mapPieces.put(piece, objectAddPieces);
                        System.out.printf("%s by %s in %s added to the collection!\n"
                                , piece, composer, key);
                    } else {
                        System.out.printf("%s is already in the collection!\n", piece);
                    }
                    break;
                case "Remove":
                    //{piece}
                    piece = commandLine[1];
                    if (mapPieces.containsKey(piece)) {
                        mapPieces.remove(piece);
                        System.out.printf("Successfully removed %s!\n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n"
                                , piece);
                    }
                    break;
                case "ChangeKey":
                    //{piece}|{new key}
                    piece = commandLine[1];
                    String newKey = commandLine[2];
                    if (!mapPieces.containsKey(piece)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n"
                                , piece);
                    } else {
                        mapPieces.get(piece).setKey(newKey);
                        System.out.printf("Changed the key of %s to %s!\n"
                                , piece, newKey);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        mapPieces.entrySet().stream()
                .forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s\n"
                        , e.getKey(), e.getValue().getComposer(), e.getValue().getKey()));
    }

    static class ClassPieces {
        private String composer;
        private String key;

        public ClassPieces(String composer, String key) {
            this.composer = composer;
            this.key = key;
        }

        public String getComposer() {
            return composer;
        }

        public String getKey() {
            return key;
        }

        public void setComposer(String composer) {
            this.composer = composer;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}

