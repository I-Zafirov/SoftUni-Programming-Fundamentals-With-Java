package T19MidExamPreparation;

import java.util.Scanner;

public class TheImitationGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] encryptedMessage = scanner.nextLine().split("");

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

    private static String[] move(String[] str, int numberOfLetters){
        String[] first = new String[numberOfLetters];
        for (int i = 0; i < first.length; i++) {
            first[i] = str[i];
        }
        String[] second = new String[str.length - numberOfLetters];
        for (int i = 0; i < second.length; i++) {
            second[i] = str[numberOfLetters + i];
        }

        String[] movedStr = new String[str.length];
        for (int i = 0; i < second.length; i++) {
            movedStr[i] = second[i];
        }
        for (int i = 0; i < first.length; i++) {
            movedStr[second.length + i] = first[i];
        }

        return movedStr;
    }

    private static String[] insert(String[] str, int index, String value){
        String[] valueStr = value.split("");
        String[] secondPart = new String[str.length - index];
        for (int i = 0; i < secondPart.length; i++) {
            secondPart[i] = str[index + i];
        }
        String[] insertedStr = new String[str.length + valueStr.length];

        for (int i = 0; i < index; i++) {
            insertedStr[i] = str[i];
        }

        for (int i = 0; i < valueStr.length; i++) {
            insertedStr[index + i] = valueStr[i];
        }
        for (int i = 0; i < str.length - index; i++) {
            insertedStr[index + valueStr.length + i] = secondPart[i];
        }

        return insertedStr;
    }

    private  static String[] changeall(String[] str, String substring, String replacement){
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(substring)){
                str[i] = replacement;
            }
        }
        return str;
    }
}
