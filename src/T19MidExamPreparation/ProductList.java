package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> productList = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Shop!")) {
            String[] command = input.split("%");

            String commandName = command[0];
            String product = "";

            switch (commandName) {
                case "Important":
                    product = command[1];
                    productList.remove(product);
                    productList.add(0, product);
                    break;
                case "Add":
                    product = command[1];
                    if( productList.contains(product) ) {
                        System.out.println("The product is already in the list.");
                    } else {
                        productList.add(product);
                    }
                    break;
                case "Swap":
                    product = command[1];
                    String secondProduct = command[2];
                    if (!productList.contains(product)) {
                        System.out.printf("Product %s missing!%n", product);
                        break;
                    }
                    if (!productList.contains(secondProduct)) {
                        System.out.printf("Product %s missing!%n", secondProduct);
                        break;
                    }
                    int indexOfFirstProduct = productList.indexOf(product);
                    int indexOfSecondProduct = productList.indexOf(secondProduct);

                    productList.set(indexOfFirstProduct, secondProduct);
                    productList.set(indexOfSecondProduct, product);
                    break;
                case "Remove":
                    product = command[1];
                    if( productList.contains(product) ) {
                        productList.remove(product);
                    } else {
                        System.out.printf("Product %s isn't in the list.%n", product);
                    }
                    break;
                case "Reversed":
                    Collections.reverse(productList);
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < productList.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, productList.get(i));
        }
    }
}
