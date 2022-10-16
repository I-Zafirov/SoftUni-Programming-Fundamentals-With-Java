package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Files {
    private static BufferedReader reader;
    private static Map<String, Map<String, Long>> roots;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        roots = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String input = reader.readLine();
            String root = input.substring(0, input.indexOf("\\"));
            String fileData = input.substring(input.lastIndexOf("\\") + 1);
            String file = fileData.split(";")[0];
            long size = Long.parseLong(fileData.split(";")[1]);

            roots.putIfAbsent(root, new TreeMap<>());
            roots.get(root).put(file, size);
        }

        String parameters = reader.readLine();
        String exe = parameters.split(" in ")[0];
        String root = parameters.split(" in ")[1];
        List<String> output = new ArrayList<>();
        if (roots.containsKey(root)) {
            output = roots.get(root).entrySet().stream()
                    .filter(e -> e.getKey().endsWith(exe))
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .map(e -> String.format("%s - %d KB", e.getKey(), e.getValue()))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (output.size() > 0) {
            output.forEach(System.out::println);
        } else {
            System.out.println("No");
        }


    }
}
