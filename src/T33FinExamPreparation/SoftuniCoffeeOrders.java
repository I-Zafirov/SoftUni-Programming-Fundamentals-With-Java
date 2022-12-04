package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class SoftuniCoffeeOrders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int orders = Integer.parseInt(reader.readLine());

        BigDecimal totalOrder = BigDecimal.ZERO;
        for (int i = 0; i < orders; i++) {
            double pr = Double.parseDouble(reader.readLine());
            BigDecimal price = new BigDecimal(pr);

            String date = reader.readLine();
            int daysInMonth = GetNumberOfDaysInMonth(date);
            BigDecimal days = BigDecimal.valueOf(daysInMonth);

            int cap = Integer.parseInt(reader.readLine());
            BigDecimal capsules = new BigDecimal(cap);

            BigDecimal priceForCoffee = days.multiply(capsules).multiply(price);
            System.out.println(String.format("The price for the coffee is: $%.2f", priceForCoffee));

            totalOrder = totalOrder.add(priceForCoffee);
        }

        System.out.println(String.format("Total: $%.2f", totalOrder));
    }

    private static int GetNumberOfDaysInMonth(String date) {
        String[] dateArr = date.split("/");
        int year = Integer.parseInt(dateArr[2]);
        int month = Integer.parseInt(dateArr[1]);

        int number_Of_DaysInMonth = 0;
        String MonthOfName = "Unknown";
        switch (month) {
            case 1:
                MonthOfName = "January";
                number_Of_DaysInMonth = 31;
                break;
            case 2:
                MonthOfName = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    number_Of_DaysInMonth = 29;
                } else {
                    number_Of_DaysInMonth = 28;
                }
                break;
            case 3:
                MonthOfName = "March";
                number_Of_DaysInMonth = 31;
                break;
            case 4:
                MonthOfName = "April";
                number_Of_DaysInMonth = 30;
                break;
            case 5:
                MonthOfName = "May";
                number_Of_DaysInMonth = 31;
                break;
            case 6:
                MonthOfName = "June";
                number_Of_DaysInMonth = 30;
                break;
            case 7:
                MonthOfName = "July";
                number_Of_DaysInMonth = 31;
                break;
            case 8:
                MonthOfName = "August";
                number_Of_DaysInMonth = 31;
                break;
            case 9:
                MonthOfName = "September";
                number_Of_DaysInMonth = 30;
                break;
            case 10:
                MonthOfName = "October";
                number_Of_DaysInMonth = 31;
                break;
            case 11:
                MonthOfName = "November";
                number_Of_DaysInMonth = 30;
                break;
            case 12:
                MonthOfName = "December";
                number_Of_DaysInMonth = 31;
        }

        return number_Of_DaysInMonth;
    }
}
