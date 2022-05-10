package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<String> messages = new ArrayList<>();

        while (!input.equals("end")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Chat":
                    String messageToBeAdded = tokens[1];
                    messages.add(messageToBeAdded);
                    break;
                case "Delete":
                    String messageToBeDeleted = scan.nextLine();
                    if(messages.contains(messageToBeDeleted)){
                        messages.remove(messageToBeDeleted);
                    }
                    break;
                case "Edit":
                    String messageToEdit = tokens[1];
                    String editedVersion = tokens[2];

                    int indexOfMessage = messages.indexOf(messageToEdit);
                    messages.set(indexOfMessage, editedVersion);
                    break;
                case "Pin":
                    String messageToBePinned = tokens[1];
                    if(messages.contains(messageToBePinned)){
                        messages.remove(messageToBePinned);
                        messages.add(messageToBePinned);
                    }
                    break;
                case "Spam":
                    for (int i = 1; i <= tokens.length - 1 ; i++) {
                        String currentItem = tokens[i];
                        messages.add(currentItem);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (String message : messages) {
            System.out.println(message);
        }
    }
}
