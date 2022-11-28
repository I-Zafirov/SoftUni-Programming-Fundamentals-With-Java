package T33FinExamPreparation;

import java.util.*;

public class PovtarqshtiSeChisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.next());

        for (int i = 0; i < t; i++) {
            Map<Integer, Integer> map = new LinkedHashMap<>();
            int n = Integer.parseInt(scanner.next());
            for (int k = 0; k < n; k++) {
                int c = Integer.parseInt(scanner.next());
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
            int max = -1;
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> str : map.entrySet()) {
                if (str.getValue() > max) {
                    max = str.getValue();
                }

            }
            int min2 = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> str : map.entrySet()) {
                if (str.getValue() == max) {
                    if (str.getKey() < min2) {
                        min2 = str.getKey();
                    }
                }

            }


            System.out.println(min2);
        }
    }
}
