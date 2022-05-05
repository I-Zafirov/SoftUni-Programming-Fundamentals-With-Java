package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _P3_CardSuccessfullyBought {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String vehicles = scanner.nextLine();
        List<String> names = Arrays.stream(vehicles.split(", "))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i<n; i++){
            String [] tokens = scanner.nextLine().split(", ");
            String command = tokens[0];

            switch (command){
                case "Add":
                    String name = tokens[1];
                    names.contains(name);
                    if (names.contains(name)){
                        System.out.println("Card is already bought");
                        break;
                    }else {
                        System.out.println("Card successfully bought");
                        names.add(name);
                    }
                    break;
                case "Remove":
                    String name1 = tokens[1];
                    names.contains(name1);
                    if (names.contains(name1)){
                        System.out.println("Card successfully sold");
                        names.remove(name1);
                        break;
                    }else{
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    int index = Integer.parseInt(tokens[1]);
                    if (index<names.size()){
                        names.remove(index);
                        System.out.println("Card successfully sold");
                        break;
                    }else{
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    int index1 = Integer.parseInt(tokens[1]);
                    String name2 = tokens[2];
                    names.contains(name2);
                    if (index1<names.size()){
                        if (names.contains(name2)){
                            System.out.println("Card is already bought");
                            break;
                        }else{
                            names.add(index1,name2);
                            System.out.println("Card successfully bought");
                        }
                    }else{
                        System.out.println("Index out of range");
                    }
                    break;


            }


        }
        System.out.println(String.join(", ", names));
    }
}
