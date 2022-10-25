package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Pattern patt = Pattern.compile("(?:\\[\")([\001-\177]*?)(?:\"\\])");
        TreeMap<String, List<String>> critErrors = new TreeMap<>();
        TreeMap<String, List<String>> warnErrors = new TreeMap<>();
        while (!input.equals("END")) {
            Matcher matcher = patt.matcher(input);
            matcher.find();
            String projectName = matcher.group(1);
            matcher.find();
            String type = matcher.group(1);
            matcher.find();
            String msg = matcher.group(1);


            if (!critErrors.containsKey(projectName)) {
                critErrors.put(projectName, new ArrayList<>());
                warnErrors.put(projectName, new ArrayList<>());
            }

            if (type.equals("Critical")) {
                critErrors.get(projectName).add(msg);
            } else {
                warnErrors.get(projectName).add(msg);
            }

            input = sc.nextLine();
        }


        critErrors.entrySet().stream().sorted((n2, n1) ->
                Integer.compare(n1.getValue().size() + warnErrors.get(n1.getKey()).size(), n2.getValue().size() + warnErrors.get(n2.getKey()).size())).forEach(entrys -> {
            System.out.println(entrys.getKey() + ":");
            int totalErrs = entrys.getValue().size() + warnErrors.get(entrys.getKey()).size();
            System.out.println("Total Errors: " + totalErrs);
            System.out.println("Critical: " + entrys.getValue().size());
            System.out.println("Warnings: " + warnErrors.get(entrys.getKey()).size());
            System.out.println("Critical Messages:");
            if (entrys.getValue().size() > 0) {
                entrys.getValue().stream().sorted((s1, s2) -> s1.compareTo(s2)).sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).forEach(entry -> {
                    System.out.println("--->" + entry);
                });
            } else {
                System.out.println("--->None");
            }
            System.out.println("Warning Messages:");
            if (warnErrors.get(entrys.getKey()).size() > 0) {
                warnErrors.get(entrys.getKey()).stream().sorted((s1, s2) -> s1.compareTo(s2)).sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).forEach(entry -> {
                    System.out.println("--->" + entry);
                });
            } else {
                System.out.println("--->None");
            }
            System.out.println();
        });
    }
}
