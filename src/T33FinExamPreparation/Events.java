package T33FinExamPreparation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfEvents = scanner.nextInt();
        scanner.nextLine();
        Pattern pattern = Pattern
                .compile("^#([A-Za-z0-9]+):\\s*@([A-Za-z]+)\\s*(([2][0-3]|[0-1]?[0-9]):([0-9][0-9]))$");
        TreeMap<String, TreeMap<String, ArrayList<String>>> eventsData = new TreeMap<>();
        for (int i = 0; i < numOfEvents; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String person = matcher.group(1);
                String city = matcher.group(2);
                String time = matcher.group(3);
                if (!eventsData.containsKey(city)) {
                    eventsData.put(city, new TreeMap<>());
                }
                if (!eventsData.get(city).containsKey(person)) {
                    eventsData.get(city).put(person, new ArrayList<String>() {
                    });
                }
                eventsData.get(city).get(person).add(time);
            }
        }
        String[] querys = scanner.nextLine().split(",");
        Arrays.sort(querys);
        for (String query : querys) {
            if (eventsData.containsKey(query)) {
                System.out.println(query + ":");
                String[] namess = new String[eventsData.get(query).size()];
                eventsData.get(query).keySet().toArray(namess);
                int counter = 1;
                for (String name : namess) {
                    System.out.printf("%d. %s -> ", counter, name);
                    List<String> times = eventsData.get(query).get(name);
                    times.sort(String::compareTo);
                    String str = times.toString()
                            .replace('[', '\0')
                            .replace(']', '\0')
                            .trim();
                    System.out.println(str);
                    counter++;
                }
            }
        }
    }
}
