package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> result = new LinkedHashMap<>();
        String pat = "((([a-z]+)([!@#\\$\\?]*)([a-z]+))+[!@#\\$\\?]*)=(\\d+)--(\\d++)<<([a-z]+)";
        List<Character> symbol = new ArrayList<>();
        symbol.add('!');
        symbol.add('@');
        symbol.add('#');
        symbol.add('$');
        symbol.add('?');


        Pattern pattern = Pattern.compile(pat);
        while (true) {
            String input = reader.readLine();
            if ("Stop!".equals(input)) {
                break;
            }
            Matcher match = pattern.matcher(input);
            if (match.find()) {
                String name = match.group(1);
                StringBuilder sb = new StringBuilder();
                int lenght = Integer.parseInt(match.group(6));
                int countGeneses = Integer.parseInt(match.group(7));
                String organism = match.group(8);
                for (int i = 0; i < name.length(); i++) {
                    char ch = name.charAt(i);
                    if (!symbol.contains(ch)) {
                        sb.append(ch);
                    }

                }
                if (sb.toString().length() == lenght) {
                    result.putIfAbsent(organism, 0L);
                    result.put(organism, result.get(organism) + countGeneses);
                }

            }

        }
        result.entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue())).forEach(x -> {
            System.out.printf("%s has genome size of %d\n", x.getKey(), x.getValue());
        });
    }
}
