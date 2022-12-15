package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseYourChainsBuddy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inout = reader.readLine();

        Pattern pattern = Pattern.compile("(?:<p>)(.*?)(?:</p>)");
        Matcher matcher = pattern.matcher(inout);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String matchedStr = matcher.group(1);
            sb.append(matchedStr);
        }

        String filterStr = sb.toString().replaceAll("[^a-z\\d]+", " ");
        filterStr = filterStr.replaceAll("\\s+", " ");
        String[] filterStrArr = filterStr.split(" ");

        for (int i = 0; i < filterStrArr.length; i++) {
            filterStrArr[i] = Rot13ToString(filterStrArr[i]) + " ";
        }

        PrintDescriptString(filterStrArr);

    }

    private static void PrintDescriptString(String[] filterStrArr) {
        for (String ch : filterStrArr) {
            System.out.print(ch);
        }
    }

    private static String Rot13ToString(String str) {
        StringBuilder result = new StringBuilder();

        char[] letterArr = str.toCharArray();
        for (char letter : letterArr) {
            result.append(Rot13(letter));
        }

        return result.toString();
    }

    private static char Rot13(char letter) {
        if (letter < 97 || letter > 122) {
            return letter;
        }

        int offset = 97;

        return (char) ((letter - offset + 13) % 26 + offset);
    }

}
