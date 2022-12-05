package T33FinExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        List<String> songs = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        Map<String, List<String>> participantsAwards = new LinkedHashMap<>();
        while (!input.equals("dawn")) {
            String[] tokens = input.split(",\\s+");
            String participant = tokens[0];
            String song = tokens[1];
            String award = tokens[2];
            if (participants.contains(participant) && songs.contains(song)) {
                if (!participantsAwards.containsKey(participant)) {
                    participantsAwards.put(participant, new ArrayList<>());
                }
                if (!participantsAwards.get(participant).contains(award)) {
                    participantsAwards.get(participant).add(award);
                }
            }
            input = scanner.nextLine();
        }
        if (participantsAwards.isEmpty()) {
            System.out.println("No awards");
        } else {
            participantsAwards.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int result = Integer.compare(e2.getValue().size(), e1.getValue().size());
                        if (result == 0) {
                            result = e1.getKey().compareTo(e2.getKey());
                        }
                        return result;
                    })
                    .forEach(e -> {
                        System.out.printf("%s: %d awards%n", e.getKey(), e.getValue().size());
                        e.getValue().stream().sorted().forEach(award -> System.out.println("--" + award));
                    });
        }
    }
}
