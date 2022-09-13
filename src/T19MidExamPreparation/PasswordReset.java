package T19MidExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        String[] commands = scan.nextLine().split("\\s+");

        while (!commands[0].equals("Done")) {
            switch (commands[0]) {
                case "TakeOdd":
                    String odd = "";

                    for (int i = 1; i < password.length(); i += 2) {

                        odd += password.charAt(i);
                    }
                    password = odd;
                    System.out.println(password);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(commands[1]);
                    int length = Integer.parseInt(commands[2]);

                    String firstPart = password.substring(0, startIndex);
                    String secondPart = password.substring(startIndex + length);

                    password = firstPart + secondPart;
                    System.out.println(password);
                    break;
                case "Substitute":
                    String oldSymbol = commands[1];
                    String newSymbol = commands[2];
                    String temporary = "";

                    if (password.contains(oldSymbol)) {

                        temporary = password.replaceAll(oldSymbol, newSymbol);
                        password = temporary;

                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            commands = scan.nextLine().split("\\s+");
        }
        System.out.println("Your password is: " + password);
    }
}
