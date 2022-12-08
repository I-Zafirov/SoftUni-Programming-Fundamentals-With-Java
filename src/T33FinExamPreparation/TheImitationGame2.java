package T33FinExamPreparation;

import java.util.Scanner;

public class TheImitationGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String command = scanner.nextLine();

        StringBuilder decryptedMessage = new StringBuilder(message);
        while (!command.equals("Decode")) {
            String[] token = command.split("\\|");
            switch (token[0]) {
                case "Move":
                    int nLetters = Integer.parseInt(token[1]);
                    String subStr = decryptedMessage.substring(0, nLetters);
                    decryptedMessage.delete(0, subStr.length());
                    decryptedMessage.append(subStr);

                    break;
                case "Insert":
                    int index = Integer.parseInt(token[1]);
                    String value = token[2];
                    decryptedMessage.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = token[1];
                    String replacement = token[2];
                    if (message.contains(substring)) {
                        message = decryptedMessage.toString().replace(substring, replacement);
                        decryptedMessage = new StringBuilder(message);
                        break;
                    }
            }
            message = decryptedMessage.toString();
            command = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }
}
