package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CameraView {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int[] myArr = Arrays.stream(input.split(" ")).mapToInt(Integer::valueOf).toArray();
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\|")));

        String reGex = "^<([a-zA-Z1-9]{" + myArr[0] + "})?([A-Za-z1-9]{1," + myArr[1] + "})";
        Pattern pattern = Pattern.compile(reGex);

        List<String> resultList = new ArrayList<>();
        for (String s : myList) {
            Matcher matcher = pattern.matcher(s);

            if (matcher.find()) {
                resultList.add(matcher.group(2));
            }
        }

        System.out.println(String.join(", ", resultList));
    }
}
