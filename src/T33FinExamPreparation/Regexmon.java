package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexmon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pokemonPat = Pattern.compile("[A-Za-z]+-[A-Za-z]+");
        Pattern didimonPat = Pattern.compile("[^A-Za-z\\-]+");

        String input = reader.readLine();

        boolean isDidiTurn = true;
        while (true) {
            Matcher matcherPoke = pokemonPat.matcher(input);
            Matcher matcherDidi = didimonPat.matcher(input);
            int lastIndex = 0;

            if (matcherDidi.find() && isDidiTurn) {
                System.out.println(matcherDidi.group());
                lastIndex = matcherDidi.end();
                input = input.substring(lastIndex, input.length());
                isDidiTurn = false;
            } else if (matcherPoke.find() && !isDidiTurn) {
                System.out.println(matcherPoke.group());
                lastIndex = matcherPoke.end();
                input = input.substring(lastIndex, input.length());
                isDidiTurn = true;
            } else {
                return;
            }
        }

    }
}
