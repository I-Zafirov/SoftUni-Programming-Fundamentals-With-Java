package T33FinExamPreparation;

import java.util.Scanner;

public class NoShakeShakedIt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        String patt = sc.nextLine();

        while (true) {
            boolean firstFound = false;
            boolean lastFound = false;
            String copyWord = word;
            if (patt.length() > 0) {
                for (int i = 0; i < copyWord.length() - patt.length() + 1; i++) {

                    if (copyWord.substring(i, i + patt.length()).equals(patt)) {
                        firstFound = true;
                        copyWord = edit(copyWord, i, i + patt.length());
                        break;
                    }
                }

                for (int i = copyWord.length(); i >= patt.length(); i--) {

                    if (copyWord.substring(i - patt.length(), i).equals(patt)) {
                        lastFound = true;
                        copyWord = edit(copyWord, i - patt.length(), i);
                        break;
                    }
                }
            }

            if (lastFound && firstFound) {
                System.out.println("Shaked it.");
                word = copyWord;
                patt = edit(patt, patt.length() / 2, patt.length() / 2 + 1);

            } else {
                System.out.println("No shake.");
                System.out.println(word);
                break;
            }
        }
    }

    public static String edit(String str, int start, int end) {
        String val1 = str.substring(0, start);
        String val2 = str.substring(end, str.length());
        String res = val1 + val2;
        return res;
    }
}
