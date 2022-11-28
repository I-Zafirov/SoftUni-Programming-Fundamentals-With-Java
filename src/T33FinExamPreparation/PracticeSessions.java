package T33FinExamPreparation;

import java.util.*;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> roadsPlayer = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] line = input.split("->");
            if (line[0].equals("Close")) {
                roadsPlayer.remove(line[1]);
            } else if (line[0].equals("Add") && line.length == 3) {
                roadsPlayer.putIfAbsent(line[1], new ArrayList<>());
                roadsPlayer.get(line[1]).add(line[2]);
            } else if (line[0].equals("Move") && line.length == 4) {
                if (roadsPlayer.containsKey(line[1]) && roadsPlayer.containsKey(line[3]) && roadsPlayer.get(line[1]).contains(line[2])) {
                    roadsPlayer.get(line[1]).remove(line[2]);
                    roadsPlayer.get(line[3]).add(line[2]);
                }
            }
        }
        System.out.println("Practice sessions:");

        roadsPlayer.entrySet().stream().sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue().size(), e1.getValue().size());
            return sort;
        }).forEach(e -> {
            System.out.println(e.getKey());
            for (String racer : e.getValue()) {
                System.out.println("++" + racer);
            }
        });
    }
}
