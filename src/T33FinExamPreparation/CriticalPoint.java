package T33FinExamPreparation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CriticalPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Long>> lines = new ArrayList<>();
        Long crit = new Long("-1");

        String[] inputLine = sc.nextLine().split(" ");

        while (!inputLine[0].equals("Break")) {
            List<Long> line = new ArrayList<>();
            for (String number : inputLine) {
                line.add(Long.parseLong(number));
            }
            //(X2 + Y2) – (X1 + Y1)
            lines.add(line);

            Long temp = (line.get(2) + line.get(3)) - (line.get(0) + line.get(1));
            if (temp < 0) {
                temp *= -1;
            }


            if (crit != -1) {
                if (temp != 0 && !temp.equals(crit)) {
                    System.out.println("Critical breakpoint does not exist.");
                    return;
                }
            } else if (temp != 0) {
                crit = temp;
            }
            inputLine = sc.nextLine().split(" ");
        }

        BigInteger critPoint = new BigInteger(crit.toString());
        critPoint = critPoint.pow(lines.size());

        String size = String.format("%d", lines.size());

        BigInteger[] result = critPoint.divideAndRemainder(new BigInteger(size));

        for (List<Long> line : lines) {
            System.out.printf("Line: %s%n", line.toString());
        }
        System.out.println("Critical Breakpoint: " + result[1]);

    }
}
