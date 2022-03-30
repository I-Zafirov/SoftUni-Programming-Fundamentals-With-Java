package T33FinExamPreparation;

import java.util.Scanner;

public class P1PasswordResetSecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // message
        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String line = scanner.nextLine();
        while (!line.equals("Reveal")) {
            String[] data = line.split(":\\|:");
            String command = data[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(data[1]);
                    sb.insert(index, " ");
                    break;
                case "Reverse":
                    StringBuilder substring = new StringBuilder(data[1]);
                    if (sb.toString().contains(substring)) {
                        //StringBuilder sb parse toString, because StringBuilder don`t has .contains function.
                        // !gnil    hellodar!!gnil
                        int start = sb.indexOf(substring.toString());
                        //int start = sb.indexOf(String.valueOf(substring.chartAt(0)));
                        //int start = sb.indexOf(parse to String(chart start index(0)));
                        int end = start + substring.length() - 1;
                        sb.delete(start, end + 1);
                        substring.reverse();
                        sb.append(substring);
                    } else {
                        System.out.println("error");
                        line = scanner.nextLine();
                        continue;
                    }

                    break;
                case "ChangeAll":
                    String occurrence = data[1];
                    String replacement = data[2];
                    String replacedString = sb.toString().replaceAll(occurrence, replacement);
                    //Start index of substring in StringBuilder sb
                    sb.setLength(0);
                    sb.append(replacedString);
                    break;
            }
            System.out.println(sb);
            line = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", sb.toString());
    }
}
