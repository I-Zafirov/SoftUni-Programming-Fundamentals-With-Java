package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _P3_ShopProductList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String listAsString = scan.nextLine();

        List<String> products = Arrays.stream(listAsString.split("\\|"))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Shop!")) {
            String[] tokens = input.split("\\%");
            String command = tokens[0];

            switch (command) {
                case "Important":
                    String productToBeMoved = tokens[1];
                    if (products.contains(productToBeMoved)) {
                        products.remove(productToBeMoved);
                        products.add(0, productToBeMoved);
                    } else {
                        products.add(0, productToBeMoved);
                    }
                    break;
                case "Add":
                    String productToBeAdded = tokens[1];
                    if (!products.contains(productToBeAdded)) {
                        products.add(productToBeAdded);
                    } else {
                        System.out.println("The product is already in the list.");
                    }
                    break;
                case "Swap":
                    String firstProduct = tokens[1];
                    String secondProduct = tokens[2];
                    int firstIndex = products.indexOf(firstProduct);
                    int secondIndex = products.indexOf(secondProduct);
                    if (products.contains(firstProduct) && products.contains(secondProduct)) {
                        Collections.swap(products, firstIndex, secondIndex);
                    }
                    if (!products.contains(firstProduct) && products.contains(secondProduct)) {
                        System.out.printf("Product %s missing!%n", firstProduct);
                    }
                    if (!products.contains(secondProduct) && products.contains(firstProduct)) {
                        System.out.printf("Product %s missing!%n", secondProduct);
                    }
                    break;
                case "Remove":
                    String productToBeRemoved = tokens[1];
                    if (products.contains(productToBeRemoved)) {
                        products.remove(productToBeRemoved);
                    } else {
                        System.out.printf("Product %s isn't in the list.%n", productToBeRemoved);
                    }
                    break;

            }
            input = scan.nextLine();
        }
        for (int i = 1; i <= products.size(); i++) {
            System.out.printf("%d. %s%n", i, products.get(i - 1));
        }
    }
}
