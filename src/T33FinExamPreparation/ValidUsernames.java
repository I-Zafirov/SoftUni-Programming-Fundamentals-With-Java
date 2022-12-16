package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("[\\s/\\\\()]")));

        List<String> sortedList = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\b[A-Za-z][\\w+]{2,24}\\b)");

        for (String s : myList) {
            Matcher matcher = pattern.matcher(s);

            if (matcher.find()) {
                sortedList.add(s);
            }
        }

        int lengthCounter = 0;
        for (int i = 1; i < sortedList.size(); i++) {
            int momentLength = sortedList.get(i).length() + sortedList.get(i - 1).length();

            if (momentLength > lengthCounter) {
                lengthCounter = momentLength;
                myList.clear();
                myList.add(sortedList.get(i - 1));
                myList.add(sortedList.get(i));
            }
        }

        for (String userName : myList) {
            System.out.println(userName);
        }
    }
}
