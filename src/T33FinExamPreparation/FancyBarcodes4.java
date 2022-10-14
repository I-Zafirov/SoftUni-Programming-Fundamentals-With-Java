package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("^@[#]+([A-Z][A-Za-z\\d]{4,}[A-Z])@[#]+$");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                StringBuilder product = new StringBuilder();
                for (int j = 0; j < matcher.group(1).length(); j++) {
                    if (Character.isDigit(matcher.group(1).charAt(j))) {
                        product.append(matcher.group(1).charAt(j));
                    }
                }
                if (product.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + product);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
