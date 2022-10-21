package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class HornetArmada {
    private static BufferedReader reader;
    private static Map<String, Legion> legions;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        legions = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        processData();

        String[] tokens = reader.readLine().split("\\\\");

        if (tokens.length == 1) {
            String soldierType = tokens[0];
            printLegionsWithSoldierType(soldierType);
        } else {
            long activity = Long.parseLong(tokens[0]);
            String soldierType = tokens[1];
            printSoldierTypesAndCount(activity, soldierType);
        }

    }

    private static void printSoldierTypesAndCount(long activity, String soldierType) {
        legions.values()
                .stream()
                .filter(legion -> legion.containsSoldierType(soldierType))
                .filter(legion -> legion.getActivity() < activity)
                .sorted((a, b) -> Long.compare(b.getSoldierTypeCount(soldierType), a.getSoldierTypeCount(soldierType)))
                .map(legion -> String.format("%s -> %d", legion.getName(), legion.getSoldierTypeCount(soldierType)))
                .forEach(System.out::println);
    }

    private static void printLegionsWithSoldierType(String soldierType) {
        legions.values()
                .stream()
                .filter(legion -> legion.containsSoldierType(soldierType))
                .sorted()
                .forEach(System.out::println);
    }

    private static void processData() throws IOException {
        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split("[-=>:\\s]+");

            long activity = Long.parseLong(tokens[0]);
            String legionName = tokens[1];
            String soldierType = tokens[2];
            long soldierCount = Long.parseLong(tokens[3]);

            legions.putIfAbsent(legionName, new Legion(legionName));
            Legion legion = legions.get(legionName);
            legion.updateActivity(activity);
            legion.updateSoldiersData(soldierType, soldierCount);
        }
    }

    static class Legion implements Comparable<Legion> {
        private String name;
        private long activity;
        private Map<String, Long> soldiers;

        Legion(String name) {
            this.name = name;
            this.activity = 0;
            this.soldiers = new LinkedHashMap<>();
        }

        long getActivity() {
            return this.activity;
        }

        String getName() {
            return this.name;
        }

        void updateActivity(long activity) {
            if (activity > this.activity) {
                this.activity = activity;
            }
        }

        long getSoldierTypeCount(String soldierTye) {
            return this.soldiers.get(soldierTye);
        }

        void updateSoldiersData(String soldierType, long soldierCount) {
            this.soldiers.putIfAbsent(soldierType, 0L);
            this.soldiers.put(soldierType, this.soldiers.get(soldierType) + soldierCount);
        }

        boolean containsSoldierType(String soldierType) {
            return this.soldiers.containsKey(soldierType);
        }

        @Override
        public String toString() {
            return String.format("%d : %s", this.activity, this.name);
        }

        @Override
        public int compareTo(Legion other) {
            return Long.compare(other.getActivity(), this.getActivity());
        }
    }
}

