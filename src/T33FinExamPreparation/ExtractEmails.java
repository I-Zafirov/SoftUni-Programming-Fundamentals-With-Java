package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        Pattern pattern = Pattern.compile("([\\w.-]+@[a-zA-Z-]+)(\\.[a-zA-Z-]+)+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String email = matcher.group().toString();

            if (!(email.startsWith(".") || email.startsWith("-") || email.startsWith("_") || email.endsWith(".") || email.endsWith("-") || email.endsWith("_"))) {
                System.out.println(matcher.group());
            }
        }
    }
}
