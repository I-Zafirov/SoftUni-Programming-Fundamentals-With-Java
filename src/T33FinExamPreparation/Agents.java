package T33FinExamPreparation;

import java.util.*;

public class Agents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> register = new LinkedHashMap<>();
        Map<String, Double> missions = new LinkedHashMap<>();
        List<String> agents = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"registration".equals(input)) {
            String mision;
            double rating;
            String agent;
            if ("#".equals(input.substring(0, 1))) {
                String[] data = input.split(":");
                mision = data[0];
                rating = Double.parseDouble(data[1]);
                missions.putIfAbsent(mision, rating);
            } else {
                agent = input;
                agents.add(agent);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"operate".equals(input)) {
            String[] commandData = input.split("->");
            String agent;
            String mission;
            switch (commandData[0]) {
                case "assign":
                    assign(register, missions, commandData);
                    break;
                case "abort":
                    abort(register, commandData);
                    break;
                case "change":
                    change(register, commandData);
                    break;
            }
            input = scanner.nextLine();
        }
        register.entrySet().stream()
                .filter(agent -> !agent.getValue().isEmpty())
                .sorted((f, s) -> Double.compare(getRating(s.getValue()), getRating(f.getValue())))
                .forEach(a -> {
                    System.out.printf("Agent: %s - Total Rating: %.2f%n", a.getKey(), getRating(a.getValue()));
                    a.getValue().entrySet().stream()
                            .sorted((f, s) -> Double.compare(s.getValue(), f.getValue()))
                            .forEach(m -> {
                                System.out.printf("- %s -> %.2f%n", m.getKey(), m.getValue());
                            });
                });
    }

    private static void assign(Map<String, Map<String, Double>> register, Map<String, Double> missions, String[] commandData) {
        String agent;
        String mission;
        agent = commandData[1];
        mission = commandData[2];
        if (missions.keySet().contains(mission)) {
            for (Map.Entry<String, Double> entry : missions.entrySet()) {
                if (entry.getKey().equals(mission)) {
                    register.putIfAbsent(agent, new HashMap<>());
                    register.get(agent).put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private static void abort(Map<String, Map<String, Double>> register, String[] commandData) {
        String mission;
        mission = commandData[1];
        for (Map.Entry<String, Map<String, Double>> agentEntry : register.entrySet()) {
            for (Map.Entry<String, Double> agentMissions : agentEntry.getValue().entrySet()) {
                if (agentMissions.getKey().equals(mission)) {
                    agentEntry.getValue().remove(mission);
                    break;
                }
            }
        }
    }

    private static void change(Map<String, Map<String, Double>> register, String[] commandData) {
        String agent;
        agent = commandData[1];
        String otherAgent = commandData[2];

        Map<String, Double> agentMission = new HashMap<>(register.get(agent));
        Map<String, Double> otherAgentMission = new HashMap<>(register.get(otherAgent));

        register.replace(agent, otherAgentMission);
        register.replace(otherAgent, agentMission);
    }

    private static Double getRating(Map<String, Double> mission) {
        return mission.entrySet().stream().mapToDouble(Map.Entry::getValue).sum();
    }
}
