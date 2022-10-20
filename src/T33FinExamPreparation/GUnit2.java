package T33FinExamPreparation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUnit2 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+)$");

        Map<String, Map<String, List<String>>> classes = new LinkedHashMap<>();

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        while (!line.equals("It's testing time!")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String className = matcher.group(1);
                String methodName = matcher.group(2);
                String testName = matcher.group(3);

                if (classes.containsKey(className)) {
                    if (classes.get(className).containsKey(methodName)) {
                        if (!classes.get(className).get(methodName).contains(testName)) {
                            classes.get(className).get(methodName).add(testName);
                        }
                    } else {
                        List<String> tempTests = new ArrayList<>();
                        tempTests.add(testName);
                        classes.get(className).put(methodName, tempTests);
                    }
                } else {
                    List<String> tempTests = new ArrayList<>();
                    tempTests.add(testName);

                    Map<String, List<String>> tempMethods = new TreeMap<>();
                    tempMethods.put(methodName, tempTests);

                    classes.put(className, tempMethods);
                }
            }
            line = sc.nextLine();
        }


        List<Map.Entry<String, Map<String, List<String>>>> classList = new LinkedList<>(classes.entrySet());

        Collections.sort(classList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                Map.Entry<String, Map<String, List<String>>> entry1 = (Map.Entry<String, Map<String, List<String>>>) o1;
                Map.Entry<String, Map<String, List<String>>> entry2 = (Map.Entry<String, Map<String, List<String>>>) o2;

                int sizeO1 = 0;
                for (List<String> method : entry1.getValue().values()) {
                    sizeO1 += method.size();
                }

                int sizeO2 = 0;
                for (List<String> method : entry2.getValue().values()) {
                    sizeO2 += method.size();
                }

                if (sizeO1 > sizeO2) {
                    return -1;
                } else if (sizeO1 < sizeO2) {
                    return 1;
                } else {
                    if (entry1.getValue().size() > entry2.getValue().size()) {
                        return 1;
                    } else if (entry1.getValue().size() < entry2.getValue().size()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

            }
        });

        for (Map.Entry className : classList) {
            System.out.println(className.getKey() + ":");
            List<Map.Entry<String, List<String>>> methodList = new LinkedList<>(classes.get(className.getKey()).entrySet());

            Collections.sort(methodList, new Comparator<Map.Entry<String, List<String>>>() {
                @Override
                public int compare(Map.Entry<String, List<String>> o1, Map.Entry<String, List<String>> o2) {
                    if (o1.getValue().size() > o2.getValue().size()) {
                        return -1;
                    } else if (o1.getValue().size() < o2.getValue().size()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            for (Map.Entry methodName : methodList) {
                System.out.println("##" + methodName.getKey());
                Collections.sort(classes.get(className.getKey()).get(methodName.getKey()));
                Collections.sort(classes.get(className.getKey()).get(methodName.getKey()), (o1, o2) -> {
                    if (o1.length() > o2.length()) {
                        return 1;
                    } else if (o1.length() < o2.length()) {
                        return -1;
                    } else {
                        return 0;
                    }

                });
                for (String testName : classes.get(className.getKey()).get(methodName.getKey())) {
                    System.out.println("####" + testName);
                }
            }
        }

    }
}
