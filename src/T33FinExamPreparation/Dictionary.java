package T33FinExamPreparation;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] allWordsWithDefinitions = scanner.nextLine().split(" \\| ");
        Map<String, List<String>> dictionary = new TreeMap<>();
        for (String wordWithDefinitionToAdd : allWordsWithDefinitions) {
            String[] wordAndDefinition = wordWithDefinitionToAdd.split(": ");
            String wordToAdd = wordAndDefinition[0];
            String definitionToAdd = wordAndDefinition[1];
            if (!dictionary.containsKey(wordToAdd)) {
                dictionary.put(wordToAdd, new ArrayList<>());
            }
            List<String> newDefinitions = dictionary.get(wordToAdd);
            newDefinitions.add(definitionToAdd);
            dictionary.put(wordToAdd, newDefinitions);
        }
        String[] allWordsToTest = scanner.nextLine().split(" \\| ");
        String command = scanner.nextLine();
        if (command.equals("Test")) {
            for (String wordToTest : allWordsToTest) {
                if (dictionary.containsKey(wordToTest)) {
                    List<String> wordDefinitions = dictionary.get(wordToTest);

                    System.out.println(wordToTest + ":");
                    wordDefinitions.stream()
                            .sorted((d1, d2) -> Integer.compare(d2.length(), d1.length()))
                            .forEach(definition -> System.out.println(" -" + definition));
                }
            }
        } else {
            dictionary.keySet().forEach(word -> System.out.printf("%s ", word));
        }
    }
}
