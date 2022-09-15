package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> shelf = Arrays
                .stream(scanner.nextLine().split("&+"))
                .collect(Collectors.toList());

        while (true){
            String commands = scanner.nextLine();
            if (commands.equals("Done")){
                break;
            }

            String[] tokens = commands.split(" \\| ");
            String command = tokens[0];

            switch (command){
                case "Add Book":
                    String book = tokens[1];
                    if (!shelf.contains(book)){
                        shelf.add(0, book);
                    }
                    break;
                case "Take Book":
                    book = tokens[1];
                    shelf.remove(book);
                    break;
                case "Swap Books":
                    String book1 = tokens[1];
                    String book2 = tokens[2];
                    if (shelf.contains(book1) && shelf.contains(book2)){
                        Collections.swap(shelf, shelf.indexOf(book1), shelf.indexOf(book2));
                    }
                    break;
                case "Insert Book":
                    book = tokens[1];
                    shelf.add(book);
                    break;
                case "Check Book":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < shelf.size()){
                        System.out.println(shelf.get(index));
                    }
                    break;
//                default:
//                    break;
            }
        }

        System.out.println(String.join(", ", shelf));
    }
}
