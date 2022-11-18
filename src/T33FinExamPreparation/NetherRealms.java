package T33FinExamPreparation;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(",\\s*");
        TreeMap<String, Integer> demonHealth = new TreeMap<>();
        TreeMap<String, Double> demonDamage = new TreeMap<>();
        for (int z = 0; z < data.length; z++) {
            data[z] = data[z].replaceAll("\\s", "");
        }
        for (String demon : data) {
            demonHealth.put(demon, 0);
            demonDamage.put(demon, 0.0);
        }
        int currentHealth = 0;
        double currentDamage = 0.0;

        Pattern pattern1 = Pattern.compile("([^0-9\\.\\+\\-\\*\\/])");
        Pattern pattern2 = Pattern.compile("([+-]?\\d+\\.?\\d*)");

        for (String demon : data) {
            Matcher health = pattern1.matcher(demon);
            while (health.find()) {
                currentHealth += (int) health.group().charAt(0);
            }
            demonHealth.put(demon, currentHealth);
            currentHealth = 0;
        }
        for (String demon : data) {
            Matcher damage = pattern2.matcher(demon);
            while (damage.find()) {
                currentDamage += Double.parseDouble(damage.group());
            }
            for (int a = 0; a < demon.length(); a++) {
                if (("" + demon.charAt(a)).equals("/")) {
                    currentDamage /= 2;
                }
                if (("" + demon.charAt(a)).equals("*")) {
                    currentDamage *= 2;
                }
            }
            demonDamage.put(demon, currentDamage);
            currentDamage = 0.0;
        }
        demonHealth
                .entrySet()
                .stream()
                .forEach(a -> System.out.printf("%s - %d health, %.2f damage%n", a.getKey(), a.getValue(), demonDamage.get(a.getKey())));
    }
}

