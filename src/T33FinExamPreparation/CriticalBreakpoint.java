package T33FinExamPreparation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CriticalBreakpoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] coordinates = scanner.nextLine().split("\\s+");
        ArrayList<String[]> lines = new ArrayList<>();
        boolean critFound = false;
        Long critPoint = 0l;
        boolean cant = false;
        while (!coordinates[0].equals("Break")) {
            long x1 = Long.parseLong(coordinates[0]);
            long y1 = Long.parseLong(coordinates[1]);
            long x2 = Long.parseLong(coordinates[2]);
            long y2 = Long.parseLong(coordinates[3]);
            long calc = Math.abs((x2 + y2) - (x1 + y1));
            if (calc != 0 && !critFound) {
                critPoint = calc;
                critFound = true;
            }
            if (calc == 0 || calc == critPoint) {
                lines.add(coordinates);
            } else {
                cant = true;
            }
            coordinates = scanner.nextLine().split("\\s+");
        }
        if (cant) {
            System.out.println("Critical breakpoint does not exist.");
        } else {
            for (String[] line : lines) {
                System.out.println("Line: " + Arrays.toString(line));
            }
            int countLines = lines.size();
            BigInteger test = new BigInteger(critPoint.toString());
            test = test.pow(countLines);
            BigInteger divisor = new BigInteger(Integer.valueOf(lines.size()).toString());
            BigInteger criticalBreakpoint = test.remainder(divisor);
            System.out.println("Critical Breakpoint: " + criticalBreakpoint);
        }
    }
}
