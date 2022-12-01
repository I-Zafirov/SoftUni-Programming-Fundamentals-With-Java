package T33FinExamPreparation;

import java.math.BigDecimal;
import java.util.Scanner;

public class RoyalNonStop {
    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal("0");
        int customerCount = 0;

        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        line = sc.nextLine().split(" ");
        double lPrice = Double.parseDouble(line[0]);
        double rPrice = Double.parseDouble(line[1]);

        line = sc.nextLine().split(" ");

        while (!line[0].equals("Royal")) {
            int row = Integer.parseInt(line[0]);
            int col = Integer.parseInt(line[1]);
            customerCount++;

            if (row < col) {
                for (int i = row; i > 0; i--) {
                    if (i % 2 == 1) {
                        sum = sum.add(new BigDecimal(((i + 1) * (col + 1)) * rPrice));
                        //System.out.printf("R->%f%n",((i+1)*(col+1))*rPrice);
                    } else {
                        sum = sum.add(new BigDecimal(((i + 1) * (col + 1)) * lPrice));
                        //System.out.printf("L");
                    }
                }

                for (int i = col; i > 0; i--) {
                    sum = sum.add(new BigDecimal((i + 1) * lPrice));
                    //System.out.printf("L->%f%n",(i+1)*lPrice);
                }
            } else {
                for (int i = col; i > 0; i--) {
                    if (row % 2 == 1) {
                        sum = sum.add(new BigDecimal((i + 1) * (row + 1) * rPrice));
                        //System.out.printf("R->%f%n",(i+1)*(row+1)*rPrice);
                    } else {
                        sum = sum.add(new BigDecimal((i + 1) * (row + 1) * lPrice));
                        //System.out.printf("L->%f%n",(i+1)*(row+1)*lPrice);
                    }
                }

                for (int i = row; i > 0; i--) {
                    if (i % 2 == 1) {
                        sum = sum.add(new BigDecimal((i + 1) * rPrice));
                        //System.out.printf("R->%f%n",(i+1)*rPrice);
                    } else {
                        sum = sum.add(new BigDecimal((i + 1) * lPrice));
                        //System.out.printf("L->%f%n",(i+1)*lPrice);
                    }
                }
            }
            line = sc.nextLine().split(" ");
        }

        sum = sum.setScale(6, BigDecimal.ROUND_HALF_UP);
        System.out.println(sum);
        System.out.println(customerCount);
    }
}
