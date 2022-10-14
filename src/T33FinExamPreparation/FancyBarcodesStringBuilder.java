package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodesStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                boolean defaultMatch = true;
                String current = matcher.group();
                for (int j = 0; j < current.length(); j++) {
                    char curr = current.charAt(j);
                    if (Character.isDigit(curr)) {
                        sb.append(curr);
                        defaultMatch = false;
                    }
                }
                if (defaultMatch) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + sb);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
