package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SnowFlake {
    private static BufferedReader reader;
    private static String[] regex = {
            "^[^0-9A-Za-z\\n]+$",
            "^[0-9_]+$",
            "^[^0-9A-Za-z\\n]+[0-9_]+(?<core>[A-Za-z]+)[0-9_]+[^0-9A-Za-z\\n]+$",
            "^[0-9_]+$",
            "^[^0-9A-Za-z\\n]+$"
    };

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int core = 0;
        for (int i = 0; i < regex.length; i++) {
            String input = reader.readLine();
            Pattern pattern = Pattern.compile(regex[i]);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                if (i == 2) {
                    core = matcher.group("core").length();
                }
            } else {
                System.out.println("Invalid");
                return;
            }
        }


        System.out.println("Valid");
        System.out.println(core);
    }

}
