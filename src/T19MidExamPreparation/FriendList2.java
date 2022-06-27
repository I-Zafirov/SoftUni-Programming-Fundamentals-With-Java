package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FriendList2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        List<String> list = Arrays.stream(inp.nextLine().split(", ")).collect(Collectors.toList());
        String inputLine= inp.nextLine();

        int bl=0;
        int l=0;
        while( !inputLine.equals("Report")){
            String []command = inputLine.split(" ");
            String c=command[0];
            switch (c) {
                case "Blacklist":
                    if (list.contains(command[1])) {
                        System.out.printf("%s was blacklisted.%n", command[1]);
                        list.set(list.indexOf(command[1]), "Blacklisted");
                        bl++;
                    } else {
                        System.out.printf("%s was not found.%n", command[1]);
                    }

                    break;
                case "Error":
                    if ( Integer.parseInt(command[1])>=0 && Integer.parseInt(command[1])<list.size()  && !list.get( Integer.parseInt(command[1])).equals("Lost") &&
                            !list.get( Integer.parseInt(command[1])).equals("Blacklisted") ){
                        System.out.printf("%s was lost due to an error.%n",list.get( Integer.parseInt(command[1])) );
                        list.set(Integer.parseInt(command[1]), "Lost");
                        l++;
                    }
                    break;
                case "Change":
                    if ( Integer.parseInt(command[1])>=0 && Integer.parseInt(command[1])<list.size()){
                        String name = list.get(Integer.parseInt(command[1]));
                        list.set(Integer.parseInt(command[1]), command[2]);
                        System.out.printf("%s changed his username to %s.%n",name, command[2]);
                    }

                    break;

            }
            inputLine=inp.nextLine();
        }
        System.out.println("Blacklisted names: " + bl);
        System.out.println("Lost names: " + l);
        System.out.println(String.join(" ", list));

    }
}
