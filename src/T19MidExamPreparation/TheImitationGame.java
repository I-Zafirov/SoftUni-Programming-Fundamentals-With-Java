package T19MidExamPreparation;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();

        String commands = scanner.nextLine().toLowerCase();

        while (!commands.equals("decode")){
            String[] operations = commands.split("\\|");
            String verb = operations[0];
            switch (verb){
                case "move":
                    encryptedMessage = move(encryptedMessage, Integer.parseInt(operations[1]));
                    break;
                case "insert":
                    encryptedMessage = insert(encryptedMessage, Integer.parseInt(operations[1]), operations[2]);
                    break;
                case "changeall":
                    encryptedMessage = changeall(encryptedMessage, operations[1], operations[2]);
                    break;
            }

            commands = scanner.nextLine().toLowerCase();
        }

        System.out.printf("The decrypted message is: %s", String.join("", encryptedMessage));
    }

    private static String move(String str, int numberOfLetters){
        String first = str.substring(0, numberOfLetters);
        String second = str.substring(numberOfLetters);
        return second + first;
    }

    private static String insert(String str, int index, String value){
        String firstPart = str.substring(0, index);
        String secondPart = str.substring(index);
        return firstPart + value + secondPart;
    }

    private  static String changeall(String str, String substring, String replacement){
        return str.replace(substring, replacement);
    }
}
