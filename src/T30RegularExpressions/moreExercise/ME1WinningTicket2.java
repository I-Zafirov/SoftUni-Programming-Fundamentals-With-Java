package T30RegularExpressions.moreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME1WinningTicket2 {
    private static final String REGEX = "(?=.{20}).*?(?=(?<ch>[@#$^]))(?<match>\\k<ch>{6,}).*(?<=.{10})\\k<match>.*";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final Pattern SEPARATOR = Pattern.compile("\\s*,\\s*");

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = SEPARATOR.split(scan.nextLine().trim());

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                Matcher matcher = PATTERN.matcher(ticket);
                if (matcher.matches()) {
                    String match = matcher.group("match");
                    System.out.printf("ticket \"%s\" - %d%s%s%n",
                            ticket, match.length(), match.charAt(0),
                            (match.length() == 10) ? " Jackpot!" : "");
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            }
        }
    }
}

/*
1. (?=.{20}) - Positive Lookahead, проверяваме дали стринга е с точно 20 символа.
Решението ще мине в Judge и без тази част, защото това се проверява и на друго място в кода.
2. .*? - пропускаме всички символи в началото на стринга, които са различни от @#$^
3. (?=(?<ch>[@#$^])) - Positive Lookahead, намираме първия символ от @#$^ и го запазваме в група с име "ch".
Важно е да се отбележи, че този символ още не "изконсумиран" от регекса и се включва в следващата проверка
4. (?<match>\\k<ch>{6,}) - търсим 6 или повече поредни символа от групата "ch" и ги запазваме в група с име "match"
5. .* - пропускаме всякакви символи, които може да се намират между двете групи печеливши символи
6. (?<=.{10}) - Positive Lookbehind, разделяме стринга на две части по 10 символа и указваме,
че ще проверяваме втората част
7. \\k<match> - търсим съвпадение (във втората половина на стринга) на групата "match", която сме намерили в първата
8. .* - пропускаме всякакви символи, които може да са останали в края на стринга след намерената група "match"
*/