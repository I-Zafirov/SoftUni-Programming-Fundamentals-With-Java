package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.Collections;

public class Pаерхаерх {
    public static void main(String[] args) {
        Team2 bla = new Team2("Barsa", 1, "ewfwg");
        System.out.println(bla.equals("Barsa"));
    }

    static class Team2 {
        String name;
        int wins = 0;
        ArrayList<String> opponents = new ArrayList<>();

        public Team2(String name, int wins, String opponent) {
            this.name = name;
            this.wins += wins;
            this.opponents.add(opponent);
        }

        public void addOpponent(String opponent, boolean win) {
            this.opponents.add(", " + opponent);
            if (win) {
                this.wins++;
            }
        }

        @Override
        public String toString() {
            Collections.sort(opponents);
            String opponentsString = opponents.toString().replaceAll("\\[", "").replaceAll("\\]", "");
            return String.format("%s%n- Wins: %d%n- Opponents: %s%n", this.name, this.wins, opponentsString);

        }

        @Override
        public boolean equals(Object o) {

            return true;
        }

        //@Override
        public int compareTo(Object o) {
            if (wins > ((ChampionsLeague2.Team) o).wins) {
                return -1;
            } else if (wins < ((ChampionsLeague2.Team) o).wins) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
