package T33FinExamPreparation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PishiKufIDaSiHodim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Pattern patt = Pattern.compile("^([A-Za-z]+);(-?[0-9]+);(-?[0-9]+\\.?[0-9]*);([A-Za-z]+)$");

        HashMap<String, List<String>> teams = new HashMap<>();
        HashMap<String, Double> emplHours = new HashMap<>();
        HashMap<String, Double> dailyIn = new HashMap<>();

        while (!input.equals("Pishi kuf i da si hodim")) {
            Matcher matcher = patt.matcher(input);

            if (matcher.find()) {
                String emplo = matcher.group(1);
                double hours = Double.parseDouble(matcher.group(2));
                double payment = Double.parseDouble(matcher.group(3));
                String team = matcher.group(4);

                if (!teams.containsKey(team) && !emplHours.containsKey(emplo)) {
                    teams.put(team, new ArrayList<>());
                    teams.get(team).add(emplo);
                    emplHours.put(emplo, hours);
                    dailyIn.put(emplo, payment);

                } else if (!emplHours.containsKey(emplo)) {
                    teams.get(team).add(emplo);
                    emplHours.put(emplo, hours);
                    dailyIn.put(emplo, payment);
                }

            }

            input = sc.nextLine();
        }

        HashMap<String, Double> earned = new HashMap<>();

        for (Map.Entry<String, List<String>> entrys : teams.entrySet()) {
            earned.put(entrys.getKey(), 0d);
            for (String s : entrys.getValue()) {
                double formula = dailyIn.get(s) * emplHours.get(s);
                double get = earned.get(entrys.getKey());
                earned.put(entrys.getKey(), get + formula);
            }
        }

        teams.entrySet().stream().sorted((s1, s2) -> earned.get(s2.getKey()).compareTo(earned.get(s1.getKey())))
                .forEach(entry -> {
                    System.out.println("Team - " + entry.getKey());
                    entry.getValue().stream().sorted((m1, m2) -> m1.compareTo(m2)).sorted((k1, k2) -> Double.compare(emplHours.get(k2) * dailyIn.get(k2), emplHours.get(k1) * dailyIn.get(k1)))
                            .sorted((f1, f2) -> emplHours.get(f2).compareTo(emplHours.get(f1))).forEach(en -> {

                                double result = (dailyIn.get(en) * emplHours.get(en)) / 24;
                                System.out.printf("$$$%s - %.0f - %.6f%n", en, emplHours.get(en), result);
                            });
                });
    }
}
