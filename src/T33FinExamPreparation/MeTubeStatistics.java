package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MeTubeStatistics {
    private static final String END = "stats time";

    private static BufferedReader reader;
    private static Map<String, Comparator<Video>> comparators;
    private static MeTube meTube;

    static {
        meTube = new MeTube();
        reader = new BufferedReader(new InputStreamReader(System.in));
        comparators = new HashMap<>() {{
            put("by views", (v1, v2) -> v2.getViews() - v1.getViews());
            put("by likes", (v1, v2) -> v2.getLikes() - v1.getLikes());
        }};
    }

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        runApp();
    }

    private static void runApp() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String input;
        while (!END.equals(input = reader.readLine())) {
            String[] tokens;
            String videoName;
            if (input.contains("-")) {
                tokens = input.split("-");
                videoName = tokens[0];
                int vies = Integer.parseInt(tokens[1]);
                meTube.add(videoName, vies);
            } else {
                tokens = input.split(":");
                String rateAction = tokens[0];
                videoName = tokens[1];
                meTube.rate(videoName, rateAction);
            }
        }

        String sortingCriteria = reader.readLine();
        meTube.setComparator(comparators.get(sortingCriteria));
        System.out.println(meTube.toString());
    }

    static class MeTube {

        private Map<String, Video> videos;
        private Comparator<Video> comparator;

        public MeTube() {
            this.videos = new LinkedHashMap<>();
            this.comparator = Comparator.comparingInt(v -> 1);
        }

        void add(String videoName, int views) {
            this.videos.putIfAbsent(videoName, new Video(videoName));
            this.videos.get(videoName).addViews(views);
        }

        void rate(String videoName, String rateAction) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            if (this.videos.containsKey(videoName)) {
                Video video = this.videos.get(videoName);
                video.getClass().getDeclaredMethod(rateAction).invoke(video);
            }
        }

        public void setComparator(Comparator<Video> comparator) {
            this.comparator = comparator;
        }

        @Override
        public String toString() {
            return this.videos.values()
                    .stream()
                    .sorted(this.comparator)
                    .map(Video::toString)
                    .collect(Collectors.joining("\n"));
        }
    }

    static class Video {
        private String videoName;
        private int views;
        private int likes;

        public Video(String videoName) {
            this.videoName = videoName;
            this.views = 0;
            this.likes = 0;
        }

        public int getViews() {
            return this.views;
        }

        public int getLikes() {
            return this.likes;
        }

        public void addViews(int views) {
            this.views += views;
        }

        public void like() {
            this.likes += 1;
        }

        public void dislike() {
            this.likes -= 1;
        }

        @Override
        public String toString() {
            return String.format("%s - %d views - %d likes", this.videoName, this.views, this.likes);
        }

    }

    static class VieosViewsComparator implements Comparator<Video> {

        @Override
        public int compare(Video o1, Video o2) {
            return 0;
        }

    }
}


