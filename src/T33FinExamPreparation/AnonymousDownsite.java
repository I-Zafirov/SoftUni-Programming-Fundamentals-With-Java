package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class AnonymousDownsite {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberWebsitesDown = Integer.parseInt(reader.readLine());
        int securityKey = Integer.parseInt(reader.readLine());

        BigDecimal totalMoneyLoss = BigDecimal.ZERO;
        for (int i = 0; i < numberWebsitesDown; i++) {
            String[] data = reader.readLine().split("\\s+");

            String siteName = data[0];
            BigDecimal siteVisits = new BigDecimal(data[1]);
            BigDecimal pricePerVisit = new BigDecimal(data[2]);

            BigDecimal siteLosse = siteVisits.multiply(pricePerVisit);
            totalMoneyLoss = totalMoneyLoss.add(siteLosse);

            System.out.println(siteName);
        }

        System.out.println(String.format("Total Loss: %.20f", totalMoneyLoss));

        BigDecimal securityToken = BigDecimal.valueOf(securityKey).pow(numberWebsitesDown);
        System.out.println(String.format("Security Token: %.0f", securityToken));
    }
}
