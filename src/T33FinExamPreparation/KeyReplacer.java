package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyReplacer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("(?:[\\\\|<|\\|][A-Za-z0-9]+[\\\\|<|\\|])")));
        String text = reader.readLine();

        if (myList.size() == 2) {
            String reGex = "(?<=" + myList.get(0) + ")(.*?)(?=" + myList.get(1) + ")";
            Pattern pattern = Pattern.compile(reGex);
            Matcher matcher = pattern.matcher(text);

            String result = "";
            while (matcher.find()) {
                result = result + matcher.group();
            }

            if (result.length() == 0) {
                System.out.println("Empty result");
            } else {
                System.out.println(result);
            }
        } else {
            System.out.println("Empty result");
        }
    }
}
