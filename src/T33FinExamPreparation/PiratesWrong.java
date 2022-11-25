package T33FinExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PiratesWrong {
    static class Cities {
        String townName;
        int people;
        int gold;

        public Cities(String townName, int people, int gold) {
            this.townName = townName;
            this.people = 0;
            this.gold = 0;
        }


        public void setPeople(int people) {
            this.people = people;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public void setTownName(String townName) {
            this.townName = townName;
        }

        public String getTownName() {
            return townName;
        }

        public int getPeople() {
            return people;
        }

        public int getGold() {
            return gold;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Cities> townsByName = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"Sail".equals(input)) {
            String[] tokens = input.split("\\|\\|");
            String cityName = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            /* Cities c = new Cities(cityName, population,gold);
            c.setPeople(c.getPeople()+population);
            c.setGold(c.getGold()+gold);
            townsByName.putIfAbsent(c.getTownName(), c);*/

            input = scanner.nextLine();

        }

        input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] commands = input.split("=>");
            switch (commands[0]) {
                case "Plunder":
                    String cityName = commands[1];
                    int population = Integer.parseInt(commands[2]);
                    int gold = Integer.parseInt(commands[3]);

                    break;
                case "Prosper":
                    String cityName1 = commands[1];
                    int gold1 = Integer.parseInt(commands[2]);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
