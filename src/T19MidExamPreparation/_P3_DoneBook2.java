package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _P3_DoneBook2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> books = Arrays.stream(scanner.nextLine().split("&"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] tokens = command.split(" \\| ");
            String action = tokens[0];
            switch (action) {
                case "Add Book":
                    String addBook = tokens[1];
                    if (books.contains(addBook)) {
                        break;
                    } else {
                        books.add(0, addBook);
                    }
                    break;
                case "Take Book":
                    String removeBook = tokens[1];
                    if (!books.contains(removeBook)) {
                        break;
                    } else {
                        books.remove(removeBook);
                    }
                    break;
                case "Swap Books":
                    String book1 = tokens[1];
                    String book2 = tokens[2];
                    int index1 = books.indexOf(tokens[1]);
                    int index2 = books.indexOf(tokens[2]);

                    if (books.contains(book1) && books.contains(book2)) {
                        Collections.swap(books, index1, index2);
                    }
                    break;
                case "Insert Book":
                    String insertBook = tokens[1];
                    books.add(insertBook);
                    break;
                case "Check Book":
                    int index = Integer.parseInt(tokens[1]);

                    if (index < 0 || index > books.size()) {
                        break;
                    } else {
                        System.out.println(books.get(index));
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        String booksOnShelf = String.join(", ", books);
        System.out.println(booksOnShelf);
    }
}
