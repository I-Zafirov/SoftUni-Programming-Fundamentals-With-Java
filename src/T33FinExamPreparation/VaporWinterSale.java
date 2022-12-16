package T33FinExamPreparation;

import java.util.*;

public class VaporWinterSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] games = scanner.nextLine().split(",\\s+");
        Map<String, Double> gamesPrice = new LinkedHashMap<>();
        Map<String, String> gamesDLC = new LinkedHashMap<>();
        List<String> noDLC = new ArrayList<>();
        for (int i = 0; i < games.length; i++) {
            if (games[i].contains("-")) {
                String game = games[i].split("-")[0];
                Double price = Double.parseDouble(games[i].split("-")[1]);
                gamesPrice.put(game, price);


            } else if (games[i].contains(":")) {
                String game = games[i].split(":")[0];
                String dnc = games[i].split(":")[1];
                if (gamesPrice.containsKey(game)) {
                    gamesDLC.put(game, dnc);
                    gamesPrice.put(game, gamesPrice.get(game) * 1.2);
                }


            }

        }
        for (Map.Entry<String, Double> entry : gamesPrice.entrySet()) {
            String game = entry.getKey();
            if (!gamesDLC.containsKey(game)) {
                noDLC.add(game);
            }
        }
        gamesDLC.entrySet().stream()
                .sorted((e1, e2) ->
                        Double.compare(gamesPrice.get(e1.getKey()), gamesPrice.get(e2.getKey()))
                )
                .forEach(e -> {
                    String priceStr = String.format("%.2f", gamesPrice.get(e.getKey()) * 0.5);
                    priceStr = priceStr.replace(",", ".");
                    System.out.printf("%s - %s - %s%n", e.getKey(), e.getValue(), priceStr);
                });
        noDLC.stream().sorted((e1, e2) ->
                        Double.compare(gamesPrice.get(e2), gamesPrice.get(e1)))
                .forEach(e -> {
                    String priceStr = String.format("%.2f", gamesPrice.get(e) * 0.8);
                    priceStr = priceStr.replace(",", ".");
                    System.out.printf("%s - %s%n", e, priceStr);
                });


    }
}
