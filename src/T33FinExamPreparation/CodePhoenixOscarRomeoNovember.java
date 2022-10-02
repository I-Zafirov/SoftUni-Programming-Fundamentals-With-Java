package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CodePhoenixOscarRomeoNovember {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, List<String>> creatureSMate = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"Blaze it!".equals(input)) {
            UpdateHashMap(creatureSMate, input);

            input = reader.readLine();
        }

        LinkedHashMap<String, Integer> resultMapCM = new LinkedHashMap<>();
        CreatResultMap(resultMapCM, creatureSMate);

        PrintResult(resultMapCM);
    }

    private static void PrintResult(LinkedHashMap<String, Integer> resultMapCM) {
        resultMapCM.entrySet().stream().sorted((x1, x2) -> x2.getValue().compareTo(x1.getValue())).forEach(x -> {
            System.out.println(x.getKey() + " : " + x.getValue());
        });
    }

    private static void CreatResultMap(LinkedHashMap<String, Integer> resultMapCM, LinkedHashMap<String, List<String>> creatureSMate) {
        for (String creature : creatureSMate.keySet()) {
            int count = 0;
            for (String squadMate : creatureSMate.get(creature)) {
                if (!creatureSMate.containsKey(squadMate)) {
                    count++;
                } else {
                    if (!creatureSMate.get(squadMate).contains(creature)) {
                        count++;
                    }
                }
            }
            resultMapCM.put(creature, count);
        }
    }

    private static void UpdateHashMap(LinkedHashMap<String, List<String>> creatureSMate, String input) {
        String[] creatMateArr = input.split(" -> ");
        String creature = creatMateArr[0];
        String squadMate = creatMateArr[1];

        creatureSMate.putIfAbsent(creature, new ArrayList<>());
        if (!creatureSMate.get(creature).contains(squadMate) && !creature.equals(squadMate)) {
            creatureSMate.get(creature).add(squadMate);
        }
    }
}
