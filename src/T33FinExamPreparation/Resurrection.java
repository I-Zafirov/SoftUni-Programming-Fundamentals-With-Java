package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Resurrection {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("###############################################0.#####################################################");

        int phoenixes = Integer.parseInt(reader.readLine());

        for (int i = 0; i < phoenixes; i++) {
            long totalBodyLength = Long.parseLong(reader.readLine());
            double totalBodyWidth = Double.parseDouble(reader.readLine());
            long wingLength = Long.parseLong(reader.readLine());

            BigDecimal totalYears = BigDecimal.valueOf(Math.pow(totalBodyLength, 2)).multiply((BigDecimal.valueOf(totalBodyWidth).add(BigDecimal.valueOf(wingLength * 2))));

//            double totalYears = Math.pow(totalBodyLength, 2) * (totalBodyWidth + 2 * wingLength);

            System.out.println(df.format(totalYears));
        }
    }
}
