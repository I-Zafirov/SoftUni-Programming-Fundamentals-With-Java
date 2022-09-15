package T19MidExamPreparation;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] command = scan.nextLine().split(":\\|:");

        while (!command[0].equals("Reveal")) {
            StringBuilder sb = new StringBuilder();

            switch (command[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);

                    sb.append(input);
                    sb.insert(index, " ");
                    input = sb.toString();

                    System.out.println(input);
                    break;
                case "Reverse":
                    String substringToReverse = command[1];
                    if (input.contains(substringToReverse)) {
                        sb.append(substringToReverse);
                        sb.reverse();

                        String reversed = sb.toString();
                        input = input.replaceFirst(substringToReverse, "") + reversed;

                        System.out.println(input);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String original = command[1];
                    String replacement = command[2];

                    input = input.replaceAll(original, replacement);

                    System.out.println(input);
                    break;
            }
            command = scan.nextLine().split(":\\|:");
        }

        System.out.println("You have a new text message: " + input);
    }
}
