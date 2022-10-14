package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtractSentencesByKeyword {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine().toLowerCase();
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("[.?!]")));

        for (int i = 0; i < myList.size(); i++) {
            List<String> result = new ArrayList<>(Arrays.asList(myList.get(i).split("[\\s:,.;!?'\\[\\]()/\\\\]+")));
            if (result.contains(word)) {
                System.out.println(myList.get(i).trim());
            }
        }
    }
}
