package T19MidExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern patternString = Pattern.compile("\\@\\#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])\\@\\#+");
        Pattern patternNumbers = Pattern.compile("\\d");

        int n = Integer.parseInt(scan.nextLine());

        for(int i = 0; i<n; i++){
            String input = scan.nextLine();
            Matcher matcherString = patternString.matcher(input);
            Matcher matcherNumbers = patternNumbers.matcher(input);

            StringBuilder legitBarcodes = new StringBuilder();
            StringBuilder numbers = new StringBuilder();

            if(matcherString.find()){
                String barcode = matcherString.group("barcode");
                legitBarcodes.append(barcode);
                if(matcherNumbers.find()) {
                    for (int j = 0; j < legitBarcodes.length(); j++) {
                        char currentSymbol = legitBarcodes.charAt(j);
                        if (Character.isDigit(currentSymbol)) {
                            numbers.append(currentSymbol);
                        }
                    }
                    System.out.println("Product group: " + numbers);
                }else{
                    System.out.println("Product group: 00");
                }
            }else{
                System.out.println("Invalid barcode");
            }
        }
    }
}
