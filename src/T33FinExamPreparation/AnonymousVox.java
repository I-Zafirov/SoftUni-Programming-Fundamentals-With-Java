package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnonymousVox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String encodedText = reader.readLine();
        String values = reader.readLine();

        Pattern pattern = Pattern.compile("([A-Za-z]+)(.*)\\1");
        Matcher matcher = pattern.matcher(encodedText);

        values = values.replaceAll("\\{", "");
        String[] valuesArr = values.split("}");

        ArrayList<String> myList = new ArrayList<>();
        for (String s : valuesArr) {
            myList.add(s);
        }

        while (matcher.find()) {
            String word = matcher.group(2);
            encodedText = encodedText.replaceFirst(word, myList.get(0));
            myList.remove(0);
        }

        System.out.println(encodedText);
    }
}
