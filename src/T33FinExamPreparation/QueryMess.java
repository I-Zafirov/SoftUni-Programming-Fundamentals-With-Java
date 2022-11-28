package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class QueryMess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        while (!"end".equalsIgnoreCase(line)) {
            Map<String, ArrayList<String>> keyMap = new LinkedHashMap<>();

            line = line.replaceAll(".+\\?", "");
            line = line.replaceAll("\\+|%20", " ");
            line = line.replaceAll("\\s{2,}", " ").trim();

            String[] keyValues = line.split("&");

            for (int i = 0; i < keyValues.length; i++) {
                String[] pairs = keyValues[i].split("=");
                String key = pairs[0].trim();
                String value = pairs[1].trim();

                if (!keyMap.containsKey(key)) {
                    keyMap.put(key, new ArrayList<>());
                }
                keyMap.get(key).add(value);
            }

            for (String key : keyMap.keySet()) {
                System.out.print(key + "=");
                System.out.print(keyMap.get(key));
            }
            System.out.println();

            line = reader.readLine();
        }
    }
}
