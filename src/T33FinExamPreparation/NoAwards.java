package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class NoAwards {
    private static List<String> participants;
    private static List<String> songs;
    private static Map<String, Set<String>> singers;
    private static BufferedReader reader;

    static {
        participants = new ArrayList<>();
        songs = new ArrayList<>();
        singers = new LinkedHashMap<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        participants = parseList();
        songs = parseList();

        String input;
        while (!"dawn".equals(input = reader.readLine())) {
            String[] tokens = input.split(", ");
            String singer = tokens[0];
            String song = tokens[1];
            String award = tokens[2];

            if (participants.contains(singer) && songs.contains(song)) {
                singers.putIfAbsent(singer, new TreeSet<>());
                singers.get(singer).add(award);
            }
        }

        if (singers.isEmpty()) {
            System.out.println("No awards");
        } else {
            printResult();
        }

    }

    private static void printResult() {
        singers.entrySet().stream()
                .sorted(compareByAwardCountAndName())
                .forEach(singer -> {
                    System.out.println(String.format("%s: %d awards", singer.getKey(), singer.getValue().size()));
                    singer.getValue()
                            .forEach(s -> System.out.println(String.format("--%s", s)));
                });
    }

    private static Comparator<Map.Entry<String, Set<String>>> compareByAwardCountAndName() {
        return (s1, s2) -> {
            int index = Integer.compare(s2.getValue().size(), s1.getValue().size());
            return index != 0 ? index : s1.getKey().compareTo(s2.getKey());
        };
    }

    private static ArrayList<String> parseList() throws IOException {
        return Arrays.stream(reader.readLine().split(", "))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
