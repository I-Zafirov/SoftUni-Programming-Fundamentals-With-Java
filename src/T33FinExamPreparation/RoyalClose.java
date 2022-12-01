package T33FinExamPreparation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class RoyalClose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        BigDecimal lPrice = sc.nextBigDecimal();
        BigDecimal rPrice = sc.nextBigDecimal();
        sc.nextLine();

        String input = sc.nextLine();

        BigDecimal earned = new BigDecimal("0");
        int count = 0;
        while (!input.equals("Royal Close")) {
            BigDecimal sum = new BigDecimal("0");
            int currRow = Integer.parseInt(input.split(" ")[0]);
            int currCol = Integer.parseInt(input.split(" ")[1]);

            if (currRow < currCol) {
                for (int i = currRow; i >= 0; i--) {
                    if (!(currCol == 0 && i == 0)) {
                        BigDecimal first = new BigDecimal(i + 1);
                        BigDecimal second = new BigDecimal(currCol + 1);
                        BigDecimal third = first.multiply(second);

                        BigDecimal price;
                        if (i % 2 == 0) {
                            price = lPrice;
                        } else {
                            price = rPrice;
                        }

                        sum = sum.add(third.multiply(price));
                    }
                }

                for (int i = currCol - 1; i > 0; i--) {
                    BigDecimal num = new BigDecimal((i + 1));
                    sum = sum.add(num.multiply(lPrice));
                }
            } else {
                for (int i = currCol; i >= 0; i--) {

                    if (!(currRow == 0 && i == 0)) {
                        BigDecimal price;
                        if (currRow % 2 == 0) {
                            price = lPrice;
                        } else {
                            price = rPrice;
                        }

                        BigDecimal first = new BigDecimal(i + 1);
                        BigDecimal second = new BigDecimal(currRow + 1);
                        BigDecimal third = first.multiply(second);

                        sum = sum.add(third.multiply(price));
                    }
                }

                for (int i = currRow - 1; i > 0; i--) {
                    BigDecimal price;
                    if (i % 2 == 0) {
                        price = lPrice;
                    } else {
                        price = rPrice;
                    }

                    sum = sum.add(new BigDecimal(i + 1).multiply(price));
                }
            }
            earned = earned.add(sum);
            count++;

            input = sc.nextLine();
        }
        System.out.println(earned.setScale(6, RoundingMode.HALF_UP));
        System.out.println(count);
    }
}
