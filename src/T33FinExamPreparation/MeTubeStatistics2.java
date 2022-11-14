package T33FinExamPreparation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeTubeStatistics2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> vidViews = new HashMap<>();
        Map<String, Integer> vidRatings = new HashMap<>();

        String input;

        while (!"stats time".equals(input = scanner.nextLine())) {

            String[] inputInfo;
            String video;
            int views;

            if (input.contains("-")) {
                inputInfo = input.split("-");
            } else {
                inputInfo = input.split(":");
            }
            switch (inputInfo[0]) {

                case "like":
                    video = inputInfo[1];

                    if (vidViews.containsKey(video)) {
                        vidRatings.put(video, vidRatings.get(video) + 1);
                    }
                    continue;
                case "dislike":
                    video = inputInfo[1];
                    if (vidViews.containsKey(video)) {
                        vidRatings.put(video, vidRatings.get(video) - 1);
                    }
                    continue;
            }
            video = inputInfo[0];
            views = Integer.parseInt(inputInfo[1]);

            vidViews.putIfAbsent(video, 0);
            vidRatings.putIfAbsent(video, 0);
            vidViews.put(video, vidViews.get(video) + views);

        }

        String printOrder = scanner.nextLine();

        if (printOrder.equals("by likes")) {
            vidRatings.entrySet().stream().sorted((pair1, pair2) ->
                            Integer.compare(pair2.getValue(), pair1.getValue()))
                    .forEach(pair ->
                            System.out.println(String.format("%s - %d views - %d likes", pair.getKey(),
                                    vidViews.get(pair.getKey()), pair.getValue())));
        } else {
            vidViews.entrySet().stream().sorted((pair1, pair2) -> Integer.compare(pair2.getValue(), pair1.getValue()))
                    .forEach(pair ->
                            System.out.println(String.format("%s - %d views - %d likes"
                                    , pair.getKey()
                                    , pair.getValue()
                                    , vidRatings.get(pair.getKey()))));
        }

    }
}
