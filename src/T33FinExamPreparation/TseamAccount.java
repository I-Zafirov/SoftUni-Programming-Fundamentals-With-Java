package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TseamAccount {
    private static BufferedReader reader;
    private static List<String> games;
    private static Map<String, Consumer<String[]>> actions;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        games = new ArrayList<>();
        actions = new HashMap<>() {{
            put("Install", array -> {
                String game = array[1];
                if (games.indexOf(game) == -1) {
                    games.add(array[1]);
                }
            });
            put("Uninstall", array -> {
                String game = array[1];
                int index = games.indexOf(game);
                if (index >= 0) {
                    games.remove(index);
                }
            });
            put("Update", array -> {
                String game = array[1];
                int index = games.indexOf(game);
                if (index >= 0) {
                    String update = games.remove(index);
                    games.add(update);
                }
            });
            put("Expansion", array -> {
                String game = array[1];
                int index = games.indexOf(game);
                if (index >= 0) {
                    String expansion = array[1] + ":" + array[2];
                    games.add(index + 1, expansion);
                }
            });
        }};
    }

    public static void main(String[] args) throws IOException {
        getGamesList();

        String input;
        while (!"Play!".equals(input = reader.readLine())) {
            String[] tokens = input.split("[\\s-]+");
            actions.get(tokens[0]).accept(tokens);
        }


        System.out.println(games.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void getGamesList() throws IOException {
        games = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
