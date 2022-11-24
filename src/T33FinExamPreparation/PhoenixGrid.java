package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoenixGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputMessage = reader.readLine();
        while (!inputMessage.equals("ReadMe")) {
            if (IsValideMessage(inputMessage)) {
                if (IsPalindrom(inputMessage)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }

            inputMessage = reader.readLine();
        }
    }

    private static boolean IsPalindrom(String str) {
        boolean isPal = false;
        StringBuilder sb = new StringBuilder(String.valueOf(str));

        if (str.equals(sb.reverse().toString())) {
            isPal = true;
        }
        return isPal;
    }

    private static boolean IsValideMessage(String inputMessage) {
        String[] messageArr = inputMessage.split("\\.");
        boolean isValide = true;

        for (String str : messageArr) {
            if (str.length() < 3 || str.length() > 3 || str.contains("_") || str.contains(" ") || str.equals("")) {
                isValide = false;
                break;
            }
        }

        return isValide;
    }
}
