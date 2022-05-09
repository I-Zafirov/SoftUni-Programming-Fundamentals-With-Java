package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BlackList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> friends = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Report")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){

                case "Blacklist":
                    String name = tokens[1];
                    int index = friends.indexOf(name);
                    if(friends.contains(name)){
                        System.out.printf("%s was blacklisted.",name);
                        friends.set(index, "Blacklisted");
                    }else {
                        System.out.printf("%s was not found",name);
                    }
                    break;
                case "Error":
                    int indexToBeChecked = Integer.parseInt(tokens[1]);
                    if(!friends.get(indexToBeChecked).equals("Blacklisted")
                            &&  !friends.get(indexToBeChecked).equals("Lost")){
                        System.out.printf("%s was lost due to an error.", friends.get(indexToBeChecked));
                        friends.set(indexToBeChecked, "Lost");
                    }
                    break;
                case "Change":
                    int indexToBeChanged = Integer.parseInt(tokens[1]);
                    String newName = tokens[2];
                    if(isValid(indexToBeChanged, friends.size())){
                        String currentName = friends.get(indexToBeChanged);
                        System.out.printf("%s changed his username to %s.",currentName, newName);
                        friends.set(indexToBeChanged, newName);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println(String.join(", ", friends));
    }

    private static boolean isValid(int indexToBeChanged, int size) {
        return indexToBeChanged >= 0 && indexToBeChanged <= size - 1;
    }
}
