package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUnit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern
                .compile("^([A-Z][A-Za-z0-9]+)\\s+\\|\\s+([A-Z][A-Za-z0-9]+)\\s+\\|\\s+([A-Z][A-Za-z0-9]+)$");
        //      class           method          unit test
        TreeMap<String, TreeMap<String, TreeSet<String>>> dataBase = new TreeMap<>();
        while (!input.equals("It's testing time!")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String className = matcher.group(1);
                String methodName = matcher.group(2);
                String unitTestName = matcher.group(3);
                if (!dataBase.containsKey(className)) {
                    dataBase.put(className, new TreeMap<>());
                }
                if (!dataBase.get(className).containsKey(methodName)) {
                    dataBase.get(className).put(methodName, new TreeSet<>());
                }
                dataBase.get(className).get(methodName).add(unitTestName);
            }
            input = scanner.nextLine();
        }
        TreeMap<String, Integer> classTotalTests = new TreeMap<>();
        for (Map.Entry<String, TreeMap<String, TreeSet<String>>> classes : dataBase.entrySet()) {
            int totalTests = 0;
            for (Map.Entry<String, TreeSet<String>> method : classes.getValue().entrySet()) {
                totalTests += method.getValue().size();
            }
            classTotalTests.put(classes.getKey(), totalTests);
        }
        // dataBase.entrySet().stream().sorted((c1, c2) -> c1.getValue().size() - c2.getValue().size())
        dataBase.entrySet().stream()
                .sorted((c1, c2) -> Integer.compare
                        (c1.getValue().size(), c2.getValue().size()))
                .sorted((c1, c2) -> classTotalTests.get
                        (c2.getKey()).compareTo(classTotalTests.get(c1.getKey())))
                .forEach(classes -> {
                    System.out.println(classes.getKey() + ":");
                    classes.getValue().entrySet().stream()
                            .sorted((m1, m2) -> Integer.compare
                                    (m2.getValue().size(), m1.getValue().size()))
                            .forEach(methods -> {
                                System.out.println("##" + methods.getKey());
                                methods.getValue().stream()
                                        .sorted((u1, u2) -> Integer.compare(u1.length(), u2.length()))
                                        .forEach(tests -> System.out.println("####" + tests));
                            });
                });
    }
}
