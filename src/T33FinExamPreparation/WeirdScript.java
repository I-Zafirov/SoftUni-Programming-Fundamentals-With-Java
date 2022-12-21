package T33FinExamPreparation;

import java.util.Scanner;

public class WeirdScript {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int keyNum = sc.nextInt();
        sc.nextLine();
        while (true) {
            if (keyNum > 52) {
                keyNum -= 52;
            } else {
                break;
            }
        }
        if (keyNum < 27) {
            keyNum += 96;
        } else {
            keyNum += 38;
        }
        String key = String.format("%s%s", (char) keyNum, (char) keyNum);

        String input = sc.nextLine();

        boolean foundStart = false;
        String text = "";
        while (!input.equals("End")) {
            for (int i = 0; i < input.length(); i++) {

                boolean check = i < input.length() - 1 && input.substring(i, i + 2).equals(key);
                if (foundStart && !check) {
                    text += input.charAt(i);
                }

                if (check) {
                    i += 1;
                    if (foundStart) {
                        foundStart = false;
                        if (!text.equals("")) {
                            System.out.println(text);
                            text = "";
                        }
                    } else {
                        foundStart = true;
                    }
                }
            }

            input = sc.nextLine();
        }
    }
}
