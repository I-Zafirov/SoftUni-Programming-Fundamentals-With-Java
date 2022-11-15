package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MOBAChallenger {
    private static BufferedReader reader;
    private static Map<String, Player> players;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        players = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "Season end".equals(input = reader.readLine())) {
            if (input.matches("[^\\s]+\\s+vs\\s+[^\\s]+")) {
                performDuel(input);
            } else {
                processPlayerStats(input);
            }
        }

        players.values()
                .stream()
                .sorted()
                .forEach(System.out::print);
    }

    private static void processPlayerStats(String input) {
        String[] tokens = input.split(" -> ");
        String player = tokens[0];
        String position = tokens[1];
        int skill = Integer.parseInt(tokens[2]);
        players.putIfAbsent(player, new Player(player));
        players.get(player).add(position, skill);
    }

    private static void performDuel(String input) {
        String[] tokens = input.split(" vs ");
        String firstPlayer = tokens[0];
        String secondPlayer = tokens[1];
        if (players.containsKey(firstPlayer) && players.containsKey(secondPlayer)) {
            if (players.get(firstPlayer).matchPosition(players.get(secondPlayer))) {
                Player playerOne = players.get(firstPlayer);
                Player playerTwo = players.get(secondPlayer);

                if (playerOne.getTotalSkills() > playerTwo.getTotalSkills()) {
                    players.remove(secondPlayer);
                } else if (playerOne.getTotalSkills() < playerTwo.getTotalSkills()) {
                    players.remove(firstPlayer);
                }

            }
        }
    }

    static class Player implements Comparable<Player> {
        private String name;
        private Map<String, Position> positions;

        Player(String name) {
            this.name = name;
            this.positions = new LinkedHashMap<>();
        }

        private String getName() {
            return this.name;
        }

        int getTotalSkills() {
            return this.positions.values()
                    .stream()
                    .map(Position::getSkill)
                    .reduce(0, (a, b) -> a + b);
        }

        void add(String positionName, int skill) {
            positions.putIfAbsent(positionName, new Position(positionName));
            positions.get(positionName).setSkill(skill);
        }

        boolean matchPosition(Player opponent) {
            List<String> opponentPositions = opponent.getPositions();
            for (Position position : positions.values()) {
                if (opponentPositions.contains(position.getName())) {
                    return true;
                }
            }
            return false;
        }

        private List<String> getPositions() {
            return this.positions.values()
                    .stream()
                    .map(Position::getName)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        @Override
        public int compareTo(Player other) {
            int index = Integer.compare(other.getTotalSkills(), this.getTotalSkills());
            return index != 0 ? index : this.getName().compareTo(other.getName());
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            output.append(String.format("%s: %d skill", this.getName(), this.getTotalSkills()))
                    .append(System.lineSeparator());
            this.positions.values()
                    .stream()
                    .sorted()
                    .forEach(position -> output.append(position).append(System.lineSeparator()));
            return output.toString();
        }
    }

    static class Position implements Comparable<Position> {
        private String name;
        private int skill;

        Position(String name) {
            this.name = name;
            this.skill = 0;
        }

        int getSkill() {
            return this.skill;
        }

        String getName() {
            return this.name;
        }

        void setSkill(int skill) {
            if (this.skill < skill) {
                this.skill = skill;
            }
        }

        @Override
        public int compareTo(Position other) {
            int index = Integer.compare(other.getSkill(), this.getSkill());
            return index != 0 ? index : this.getName().compareTo(other.getName());
        }

        @Override
        public String toString() {
            return String.format("- %s <::> %d", this.getName(), this.getSkill());
        }
    }
}


