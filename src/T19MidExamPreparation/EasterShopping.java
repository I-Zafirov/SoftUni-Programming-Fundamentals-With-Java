package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shops = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]){
                case "Include":
                    String shop = tokens[1];
                    shops.add(shop);
                    break;
                case "Visit":
                    String fromFirstOrLast = tokens[1];
                    int shopsToDelete = Integer.parseInt(tokens[2]);
                    if (shopsToDelete <= shops.size()){
                        if (fromFirstOrLast.equals("first")){
                            shops = shops.subList(shopsToDelete, shops.size());
                        }
                        if(fromFirstOrLast.equals("last")){
                            shops = shops.subList(0, shops.size() - shopsToDelete);
                        }
                    }
                    break;
                case "Prefer":
                    int shopIndex1 = Integer.parseInt(tokens[1]);
                    int shopIndex2 = Integer.parseInt(tokens[2]);
                    if (shopIndex1 >= 0 && shopIndex1 < shops.size() &&
                            shopIndex2 >= 0 && shopIndex2 < shops.size()){
                        Collections.swap(shops, shopIndex1, shopIndex2);
                    }
                    break;
                case "Place":
                    shop = tokens[1];
                    int shopIndex = Integer.parseInt(tokens[2]) + 1;
                    if (shopIndex >= 0 && shopIndex < shops.size()){
                        shops.add(shopIndex, shop);
                    }
                    break;
            }
        }
        System.out.println("Shops left:");
        System.out.println(String.join(" ", shops));
    }
}
