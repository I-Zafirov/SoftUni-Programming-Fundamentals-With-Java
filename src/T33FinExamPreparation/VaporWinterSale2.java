package T33FinExamPreparation;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VaporWinterSale2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] games = input.split("\\,\\s");

        LinkedHashMap<String, Double> gamesWithPrice = new LinkedHashMap<>();
        LinkedHashMap<String, Double> gamesWithDLC = new LinkedHashMap<>();

        for (int i = 0; i < games.length; i++) {
            String game = "";
            double price = 0.0;
            String dlc = "";
            if (games[i].contains(":")) {
                String[] gameAndDLC = games[i].split("\\:");
                game = gameAndDLC[0];
                dlc = gameAndDLC[1];
            } else {
                String[] gameAndPrice = games[i].split("\\-");
                game = gameAndPrice[0];
                price = Double.parseDouble(gameAndPrice[1]);
            }


            if (!gamesWithPrice.containsKey(game)) {
                //double lower = price * 0.20;
                //price -= lower;
                gamesWithPrice.put(game, price);
            } else {
                double priceFromMap = gamesWithPrice.get(game);
                priceFromMap += priceFromMap * 0.2;
                priceFromMap = priceFromMap * 0.5;
                //double original = priceFromMap * 0.25;
                //priceFromMap += original;
                //double dlcin = priceFromMap * 0.2;
                //priceFromMap += dlcin;
                //double discount = priceFromMap * 0.5;
                //priceFromMap -= discount;
                gamesWithPrice.remove(game);
                game = game + " - " + dlc;
                gamesWithDLC.put(game, priceFromMap);
            }
        }

        gamesWithDLC.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(game -> {
                    System.out.printf("%s - %.2f%n",
                            game.getKey(), game.getValue());
                });

        gamesWithPrice.entrySet()
                .stream()
                .sorted((game1, game2) -> game2.getValue().compareTo(game1.getValue()))
                .forEach(game -> {
                    System.out.printf("%s - %.2f%n",
                            game.getKey(), game.getValue() - (game.getValue() / 5));
                });
    }
}
