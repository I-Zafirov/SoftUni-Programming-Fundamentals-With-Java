package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder productGroup = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Pattern barcodePattern = Pattern.compile("@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+");
            Pattern productGroupPattern = Pattern.compile("\\d");
            Matcher matcher = barcodePattern.matcher(text);
            if (matcher.find()) {
                matcher = productGroupPattern.matcher(text);
                while (matcher.find()) {
                    String digit = matcher.group();
                    productGroup.append(digit);
                }
                if (productGroup.toString().isEmpty()) {
                    productGroup.append("00");
                }
                System.out.printf("Product group: %s%n", productGroup);
                productGroup = new StringBuilder();
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
