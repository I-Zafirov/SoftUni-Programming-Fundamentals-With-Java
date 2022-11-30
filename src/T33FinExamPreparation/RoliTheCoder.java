package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RoliTheCoder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^(?<id>\\d+)\\s*#(?<eventName>\\w+)\\s*(?<participants>(?:@[a-zA-Z\\d'-]+\\s*)*)$";
        Pattern pattern = Pattern.compile(regex);
        LinkedHashMap<String, LinkedHashSet<String>> eventData = new LinkedHashMap<>();
        LinkedHashMap<String, String> idData = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"Time for Code".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String id = matcher.group("id");
                String eventName = matcher.group("eventName");
                LinkedHashSet<String> people = Arrays.stream(matcher.group("participants").trim().split("\\s+"))
                        .filter(e -> !e.equals(""))
                        .collect(Collectors.toCollection(LinkedHashSet::new));

                if (idData.containsKey(id) && !idData.get(id).equals(eventName)) {
                    input = reader.readLine();
                    continue;
                } else {
                    idData.put(id, eventName);
                }

                eventData.putIfAbsent(eventName, new LinkedHashSet<>());
                eventData.get(eventName).addAll(people);
            }
            input = reader.readLine();
        }

        Comparator<String> lowerBeforeUpperCaseSort = new Comparator<String>() {
            Collator myCollator = Collator.getInstance();

            @Override
            public int compare(String o1, String o2) {
                return myCollator.compare(o1, o2);
            }
        };


        eventData.entrySet().stream()
                .sorted((a, b) -> {
                    int index = Integer.compare(b.getValue().size(), a.getValue().size());
                    if (index == 0) {
                        index = lowerBeforeUpperCaseSort.compare(a.getKey(), b.getKey());
                    }
                    return index;
                })
                .forEach(event -> {
                    System.out.println(String.format("%s - %d", event.getKey(), event.getValue().size()));
                    event.getValue().stream()
                            .sorted(lowerBeforeUpperCaseSort)
                            .forEach(s -> {
                                System.out.println(String.format("%s", s));
                            });
                });


    }
}
