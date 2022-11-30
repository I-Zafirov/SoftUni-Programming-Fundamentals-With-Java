package T33FinExamPreparation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoyalAccounitng {
    static Map<String, Map<String, Payment>> teams = new LinkedHashMap<>();
    static List<String> employees = new ArrayList<>();

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^([a-zA-Z]+);(-*[0-9]+);(-*[0-9]+(\\.*[0-9]+)*);([a-zA-Z]+)$");

        Scanner sc = new Scanner(System.in);

        String line = "";

        while (!line.equals("Pishi kuf i da si hodim")) {
            line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String employee = matcher.group(1);
                int hoursPerDay = Integer.parseInt(matcher.group(2));
                BigDecimal payment = new BigDecimal(matcher.group(3));
                String team = matcher.group(5);
                if (!employees.contains(employee)) {
                    if (!teams.containsKey(team)) {
                        teams.put(team, new HashMap<>());
                    }
                    teams.get(team).put(employee, new Payment(hoursPerDay, payment));
                    employees.add(employee);
                }
            }
        }
        List<Map.Entry<String, Map<String, Payment>>> teamsList = new LinkedList<>(teams.entrySet());

        Collections.sort(teamsList, (o1, o2) -> {
            BigDecimal o1Overall = new BigDecimal("0");
            BigDecimal o2Overall = new BigDecimal("0");

            for (Payment payment : o1.getValue().values()) {
                o1Overall = o1Overall.add(payment.getMonthlyIncome());
            }

            for (Payment payment : o2.getValue().values()) {
                o2Overall = o2Overall.add(payment.getMonthlyIncome());
            }
            return o2Overall.compareTo(o1Overall);
        });


        for (Map.Entry<String, Map<String, Payment>> team : teamsList) {
            System.out.printf("Team - %s%n", team.getKey());

            List<Map.Entry<String, Payment>> employeesList = new LinkedList<>(team.getValue().entrySet());
            Collections.sort(employeesList, (o1, o2) -> {
                if (o1.getValue().getHours() > o2.getValue().getHours()) {
                    return -1;
                } else if (o1.getValue().getHours() < o2.getValue().getHours()) {
                    return 1;
                } else {
                    if (o1.getValue().getDailyIncome().compareTo(o2.getValue().getDailyIncome()) == -1) {
                        return 1;
                    } else if (o1.getValue().getDailyIncome().compareTo(o2.getValue().getDailyIncome()) == 1) {
                        return -1;
                    } else {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                }
            });

            for (Map.Entry<String, Payment> employee : employeesList) {
                System.out.printf("$$$%s - %d - %s%n", employee.getKey(), employee.getValue().getHours(), employee.getValue().getDailyIncome().setScale(6, RoundingMode.HALF_UP));
            }
        }
    }

    static class Payment {
        int hours;
        BigDecimal dailyIncome;
        BigDecimal monthlyIncome;

        public Payment(int hours, BigDecimal dailyPayment) {
            this.hours = hours;
            BigDecimal paymentPerHour = dailyPayment.divide(BigDecimal.valueOf((double) 24), 1000, RoundingMode.HALF_UP);
            this.dailyIncome = paymentPerHour.multiply(BigDecimal.valueOf(hours));
            this.monthlyIncome = dailyPayment.multiply(BigDecimal.valueOf(hours)); //unnecessary to calculate for whole month.
        }

        public int getHours() {
            return this.hours;
        }

        public BigDecimal getMonthlyIncome() {
            return this.monthlyIncome;
        }

        public BigDecimal getDailyIncome() {
            return this.dailyIncome;
        }
    }
}

