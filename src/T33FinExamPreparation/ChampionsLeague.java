package T33FinExamPreparation;

import java.util.*;

public class ChampionsLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> teamWins = new HashMap<>();
        HashMap<String, TreeSet<String>> teamOpponents = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            String[] matchResultData = input.split(" \\| ");
            String teamOne = matchResultData[0];
            String teamTwo = matchResultData[1];

            if (!teamWins.containsKey(teamOne)) {
                teamWins.put(teamOne, 0);
                teamOpponents.put(teamOne, new TreeSet<>());
            }

            if (!teamWins.containsKey(teamTwo)) {
                teamWins.put(teamTwo, 0);
                teamOpponents.put(teamTwo, new TreeSet<>());
            }

            teamOpponents.get(teamOne).add(teamTwo);
            teamOpponents.get(teamTwo).add(teamOne);

            int scoreTeamOne = 0;
            int scoreTeamTwo = 0;

            String[] matchOneData = matchResultData[2].split(":");
            String[] matchTwoData = matchResultData[3].split(":");

            scoreTeamOne += Integer.parseInt(matchOneData[0]);
            scoreTeamOne += Integer.parseInt(matchTwoData[1]);

            scoreTeamTwo += Integer.parseInt(matchOneData[1]);
            scoreTeamTwo += Integer.parseInt(matchTwoData[0]);

            if (scoreTeamOne > scoreTeamTwo) {
                teamWins.put(teamOne, teamWins.get(teamOne) + 1);
            } else if (scoreTeamTwo > scoreTeamOne) {
                teamWins.put(teamTwo, teamWins.get(teamTwo) + 1);
            } else {
                if (Integer.parseInt(matchOneData[1]) > Integer.parseInt(matchTwoData[1])) {
                    teamWins.put(teamTwo, teamWins.get(teamTwo) + 1);
                } else {
                    teamWins.put(teamOne, teamWins.get(teamOne) + 1);
                }
            }

            input = scanner.nextLine();
        }

        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
        teamWins.entrySet().stream().sorted((e1, e2) -> {
            int comparison = e2.getValue().compareTo(e1.getValue());
            if (comparison == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }

            return comparison;
        }).forEach(stringIntegerEntry -> sorted.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));

        for (Map.Entry<String, Integer> stringIntegerEntity : sorted.entrySet()) {
            System.out.println(stringIntegerEntity.getKey());
            System.out.println("- Wins: " + stringIntegerEntity.getValue());
            System.out.printf("- Opponents: %s\n", String.join(", ", teamOpponents.get(stringIntegerEntity.getKey())));
        }
    }
}
