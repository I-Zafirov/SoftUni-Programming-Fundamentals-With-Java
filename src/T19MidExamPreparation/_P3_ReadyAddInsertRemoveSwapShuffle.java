package T19MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class _P3_ReadyAddInsertRemoveSwapShuffle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> desc = Arrays.stream(scanner.nextLine().split(":"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        List<String> newDesc = new ArrayList<>();

        while (!command.equals("Ready")){
            String[] tokens = command.split("\\s+");
            String action = tokens[0];
            switch (action){
                case "Add":
                    String cardAdd = tokens[1];
                    if (desc.contains(cardAdd)){
                        newDesc.add(cardAdd);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    String cardInsert = tokens[1];
                    int cardInsertIndex = Integer.parseInt(tokens[2]);
                    if (desc.contains(cardInsert)){
                        newDesc.add(cardInsertIndex,cardInsert);
                    }else{
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    String cardRemove = tokens[1];
                    if (newDesc.contains(cardRemove)){
                        newDesc.remove(cardRemove);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String card1 = tokens[1];
                    String card2 = tokens[2];
                    int index1 = newDesc.indexOf(card1);
                    int index2 = newDesc.indexOf(card2);
                    Collections.swap(newDesc, index1,index2);
                    break;
                case "Shuffle":
                    Collections.reverse(newDesc);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(newDesc.toString().replaceAll("[\\[\\],]", ""));
    }
}
