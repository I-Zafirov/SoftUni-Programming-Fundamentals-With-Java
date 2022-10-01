package T33FinExamPreparation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ChampionsLeague2 {
    private static ArrayList<Team> teams = new ArrayList<>();

    private static void addTeams(String team1Name, String team2Name) {
        Team team1 = new Team(team1Name, 1, team2Name);
        Team team2 = new Team(team2Name, 0, team1Name);

        if (teams.contains(team1)) {
            teams.get(teams.indexOf(team1)).addOpponent(team2Name, true);
        } else {
            teams.add(team1);
        }
        if (teams.contains(team2)) {
            teams.get(teams.indexOf(team2)).addOpponent(team1Name, false);
        } else {
            teams.add(team2);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = "";
        do {
            try {
                line = sc.nextLine();
                String[] match = line.split("\\|");

                String team1 = match[0].substring(0, match[0].length() - 1);
                String team2 = match[1].substring(1, match[1].length() - 1);

                String[] goals1 = match[2].replaceAll(" ", "").split(":");
                String[] goals2 = match[3].replaceAll(" ", "").split(":");
                int team1Goals1 = Integer.parseInt(goals1[0]);
                int team2Goals1 = Integer.parseInt(goals1[1]);
                int team1Goals2 = Integer.parseInt(goals2[1]);
                int team2Goals2 = Integer.parseInt(goals2[0]);

                if (team1Goals1 + team1Goals2 > team2Goals1 + team2Goals2) {
                    addTeams(team1, team2);
                } else if (team1Goals1 + team1Goals2 < team2Goals1 + team2Goals2) {
                    addTeams(team2, team1);
                } else {
                    if (team1Goals2 > team2Goals1) {
                        addTeams(team1, team2);
                    } else {
                        addTeams(team2, team1);
                    }
                }
            } catch (Exception e) {
            }
        } while (!line.equals("stop"));

        Collections.sort(teams);
        for (Team team : teams) {
            System.out.print(team);
        }

    }

    static class Team implements Comparable {
        String name;
        int wins = 0;
        ArrayList<String> opponents = new ArrayList<>();

        public Team(String name, int wins, String opponent) {
            this.name = name;
            this.wins += wins;
            this.opponents.add(opponent);
        }

        public void addOpponent(String opponent, boolean win) {
            this.opponents.add(opponent);
            if (win) {
                this.wins++;
            }
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public String toString() {
            Collections.sort(opponents);
            String opponentsString = opponents.toString().replaceAll("\\]", "").replaceAll("\\[", "");
            return String.format("%s%n- Wins: %d%n- Opponents: %s%n", this.name, this.wins, opponentsString);

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Team) { // the passed instance must be a String
                String anotherString = ((Team) o).name;
                int n = name.length();
                if (n == anotherString.length()) {
                    char v1[] = name.toCharArray();
                    char v2[] = anotherString.toCharArray();
                    int i = 0;
                    while (n-- != 0) {
                        if (v1[i] != v2[i])
                            return false;
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        //@Override
        public int compareTo(Object o) {
            if (wins > ((Team) o).wins) {
                return -1;
            } else if (wins < ((Team) o).wins) {
                return 1;
            } else {
                if (this.name.compareToIgnoreCase(((Team) o).name) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}
