package T33FinExamPreparation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnonymousCache2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> data = new HashMap<>();
        Map<String, Map<String, Integer>> cache = new HashMap<>();
        Pattern pattern = Pattern.compile("(?<dataKey>[^|\\-> ]+) -> (?<dataSize>\\d+) \\| (?<dataSet>[^|\\-> ]+)");
        Pattern valid = Pattern.compile("^[^|\\-> ]+$");
        String input;

        while (!"thetinggoesskrra".equals(input = scanner.nextLine())) {

            Matcher setCheck = valid.matcher(input);

            if (setCheck.find()) {

                String set = setCheck.group();
                data.putIfAbsent(set, new LinkedHashMap<>());

                if (cache.containsKey(set)) {

                    Map<String, Integer> subEntry = cache.get(set);
                    data.get(set).putAll(subEntry);
                    cache.remove(set);
                }
                continue;
            }
            Matcher matchInput = pattern.matcher(input);

            if (matchInput.find()) {

                String dataKey = matchInput.group("dataKey");
                String dataSet = matchInput.group("dataSet");
                int size = Integer.parseInt(matchInput.group("dataSize"));

                if (data.containsKey(dataSet)) {
                    data.get(dataSet).put(dataKey, size);
                } else {
                    cache.putIfAbsent(dataSet, new LinkedHashMap<>());
                    cache.get(dataSet).put(dataKey, size);
                }
            }
        }
        long biggestSum = -1;
        String biggestSet = "";

        if (data.size() > 0) {

            for (Map.Entry<String, Map<String, Integer>> entry : data.entrySet()) {

                if (entry.getValue().size() == 0) {
                    continue;
                }
                long currentSum = 0;

                for (Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                    currentSum += subEntry.getValue();
                }
                if (currentSum > biggestSum) {
                    biggestSum = currentSum;
                    biggestSet = entry.getKey();
                }
            }
            if (biggestSum >= 0) {
                System.out.println(String.format("Data Set: %s, Total Size: %d", biggestSet, biggestSum));
                data.get(biggestSet).forEach((key, value) -> System.out.println(String.format("$.%s", key)));
            }
        }
    }
}
