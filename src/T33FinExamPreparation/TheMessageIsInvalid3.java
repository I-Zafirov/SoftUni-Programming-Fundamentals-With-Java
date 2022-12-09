package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheMessageIsInvalid3 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = Integer.parseInt(inp.nextLine());
        for (int i = 0; i < n; i++) {
            String data = inp.nextLine();
            String first = "[\\!](?<command>[A-Z][a-z]{2,})[\\!][:][\\[](?<string>[A-Za-z]{8,})[\\]]";
            Pattern pattern = Pattern.compile(first);
            Matcher matcher = pattern.matcher(data);
            if (matcher.find()) {
                List<String> arr = new ArrayList<>();
                for (char a : matcher.group("string").toCharArray()) {
                    int res = (int) a;
                    String s = String.valueOf(res);
                    arr.add(s);
                }
                System.out.printf("%s: %s%n", matcher.group("command"), String.join(" ", arr));
            } else {
                System.out.println("The message is invalid");
            }

        }
    }
}
