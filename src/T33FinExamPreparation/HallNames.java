package T33FinExamPreparation;

import java.util.*;

public class HallNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        List<Integer> reservationStack = new ArrayList<>();
        ArrayDeque<Map<String, List<Integer>>> hallStack = new ArrayDeque<>();
        ArrayDeque<String> hallNames = new ArrayDeque<>();

        String[] data = scanner.nextLine().split("\\s+");

        for (int i = data.length - 1; i >= 0; i--) {
            if (hallStack.isEmpty() && data[i].matches("[0-9]+")) {
                continue;
            }
            try {
                int reservation = Integer.parseInt(data[i]);
                reservationStack.add(reservation);

            } catch (Exception e) {

                Map<String, List<Integer>> hall = new HashMap<>();
                List<Integer> values = new ArrayList<>();

                hall.put(data[i], values);

                hallStack.offer(hall);
                hallNames.offer(data[i]);
            }
        }
        while (!reservationStack.isEmpty() && !hallStack.isEmpty()) {

            int reservation = reservationStack.remove(0);

            Map<String, List<Integer>> currHall = hallStack.pop();
            String hallName = hallNames.pop();
            List<Integer> values = currHall.get(hallName);
            int sum = values.stream().mapToInt(Integer::intValue).sum();

            if (sum + reservation <= capacity) {
                values.add(reservation);
                int initsum = values.stream().mapToInt(Integer::intValue).sum();
                if (initsum == capacity) {
                    print(hallName, values);
                } else {
                    currHall.put(hallName, values);
                    hallStack.push(currHall);
                    hallNames.push(hallName);
                }
            } else if (sum + reservation > capacity) {
                print(hallName, values);
                reservationStack.add(0, reservation);
            }
        }
    }

    private static void print(String hallName, List<Integer> values) {
        System.out.print(String.format("%s -> ", hallName));
        StringBuilder sb = new StringBuilder();
        for (Integer value : values) {
            sb.append(value);
            sb.append(", ");
        }
        sb.replace(sb.lastIndexOf(", "), sb.length(), "");
        System.out.print(String.format("%s%n", sb));
    }
}
