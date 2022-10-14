package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        String regex = "@#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < input; i++) {
            String barcodeString = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcodeString);
            String digit = "";
            if (matcher.find()) {
                String validBarcode = matcher.group("barcode");
                for (int j = 0; j < validBarcode.length(); j++) {
                    char currentChar = validBarcode.charAt(j);
                    if (Character.isDigit(currentChar)) {
                        digit += currentChar;
                    }
                }
                if (digit.length() == 0) {
                    System.out.print("Product group: 00\n");
                } else {
                    System.out.printf("Product group: %s\n", digit);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
