package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    private static BufferedReader reader;
    private static final String REGEX = "^%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)[^|$%.]*\\|[^|$%.]*?(?<price>[0-9]+(?:\\.[0-9]+)?)[^|$%.]*\\$$";
    private static Pattern pattern = Pattern.compile(REGEX);
    private static double totalIncome = 0.0;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (!"end of shift".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double income = count * price;
                System.out.println(String.format("%s: %s - %.2f", name, product, income));
                totalIncome += income;
            }
        }
        System.out.println(String.format("Total income: %.2f", totalIncome));
    }
}
