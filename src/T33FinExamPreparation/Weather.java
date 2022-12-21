package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weather {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("([A-Z]{2})([1-9]{1,}.[1-9]{1,})([A-Za-z]+)\\|");
        HashMap<String, Double> cityTemp = new HashMap<>();
        HashMap<String, String> cityWeather = new HashMap<>();

        String input = reader.readLine();
        while (!input.equals("end")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                AddInfo(cityTemp, cityWeather, matcher.group(1), matcher.group(2), matcher.group(3));
            }

            input = reader.readLine();
        }

        PrintResult(cityTemp, cityWeather);
    }

    private static void PrintResult(HashMap<String, Double> cityTemp, HashMap<String, String> cityWeather) {
        cityTemp.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(c -> {
            System.out.print(String.format("%s => ", c.getKey()));
            System.out.print(String.format("%.2f => ", c.getValue()));
            System.out.print(String.format("%s%n", cityWeather.get(c.getKey())));
        });
    }

    private static void AddInfo(HashMap<String, Double> cityTemp, HashMap<String, String> cityWeather, String matchCit, String matchTem, String matchWeath) {
        String city = matchCit.trim();
        Double temperature = Double.parseDouble(matchTem.trim());
        String weather = matchWeath.trim();

        if (!cityTemp.containsKey(city)) {
            cityTemp.put(city, temperature);
            cityWeather.put(city, weather);
        } else {
            cityTemp.replace(city, temperature);
            cityWeather.replace(city, weather);
        }

    }

}
