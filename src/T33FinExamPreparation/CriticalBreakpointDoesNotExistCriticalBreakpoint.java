package T33FinExamPreparation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CriticalBreakpointDoesNotExistCriticalBreakpoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();


        List<Long> ratios = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        int count = 0;
        while (!input.equals("Break it.")) {
            String[] data = input.split(" ");

            long x1 = Long.parseLong(data[0]);
            long y1 = Long.parseLong(data[1]);
            long x2 = Long.parseLong(data[2]);
            long y2 = Long.parseLong(data[3]);

            lines.add(String.format("Line: [%d, %d, %d, %d]", x1, y1, x2, y2));

            long critRatio = Math.abs((x2 + y2) - (x1 + y1));

            if (critRatio != 0) {
                ratios.add(critRatio);
            }

            count++;
            input = sc.nextLine();
        }

        boolean check = false;
        for (int i = 0; i < ratios.size() - 1; i++) {
            long last = ratios.get(i);
            if (last == ratios.get(i + 1)) {
                check = true;
            }
        }

        if (check || ratios.size() <= 1) {
            BigDecimal breakPoint = new BigDecimal(ratios.get(0)).pow(count).remainder(new BigDecimal(count));
            for (String line : lines) {
                System.out.println(line);
            }
            System.out.println("Critical Breakpoint: " + breakPoint);
        } else {
            System.out.println("Critical breakpoint does not exist.");
        }

    }
}
