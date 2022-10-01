package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CharLogger {
    private static BufferedReader reader;
    private static String END = "end";
    private static List<String> chat;
    private static Map<String, Command> commands;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        chat = new ArrayList<>();
        commands = new HashMap<String, Command>() {{
            put("Chat", new Chat());
            put("Delete", new Delete());
            put("Edit", new Edit());
            put("Pin", new Pin());
            put("Spam", new Spam());
        }};
    }

    public static void main(String[] args) throws IOException {
        runApp();
    }

    private static void runApp() throws IOException {
        String input;
        while (!END.equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            commands.get(command).execute(Arrays.stream(tokens).skip(1).toArray(String[]::new));
        }

        System.out.println(String.join("\n", chat));
    }

    static class Spam implements Command {

        @Override
        public void execute(String[] tokens) {
            for (String message : tokens) {
                commands.get("Chat").execute(message);
            }
        }
    }

    static class Pin implements Command {

        @Override
        public void execute(String[] tokens) {
            String message = tokens[0];
            if (chat.contains(message)) {
                commands.get("Delete").execute(tokens);
                commands.get("Chat").execute(tokens);
            }
        }
    }

    static class Edit implements Command {

        @Override
        public void execute(String[] tokens) {
            String messageToEdit = tokens[0];
            String editedVersion = tokens[1];
            int index = chat.indexOf(messageToEdit);
            if (index >= 0) {
                chat.set(index, editedVersion);
            }
        }
    }

    static class Delete implements Command {

        @Override
        public void execute(String[] tokens) {
            chat.remove(tokens[0]);
        }
    }

    static class Chat implements Command {

        @Override
        public void execute(String[] tokens) {
            chat.add(tokens[0]);
        }
    }

    private interface Command {
        void execute(String... tokens);
    }
}
