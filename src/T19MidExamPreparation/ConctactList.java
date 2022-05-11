package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConctactList {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> contacts= Arrays.stream(scanner.nextLine()
                        .split(" "))
                .collect(Collectors.toList());


        while(true){
            String line=scanner.nextLine();
            String[] commands=line.split(" ");
            String command=commands[0];

            if(command.equals("Add")){
                String contact=commands[1];
                int index=Integer.parseInt(commands[2]);
                if(contacts.contains(contact)){
                    if(index>=0 && index<contacts.size()){
                        contacts.add(index,contact);
                    }
                } else {
                    contacts.add(contact);
                }
            } else if(command.equals("Remove")){
                int index=Integer.parseInt(commands[1]);
                if(index>=0 && index<contacts.size()){
                    contacts.remove(index);
                }
            } else if(command.equals("Export")){
                int startIndex=Integer.parseInt(commands[1]);
                int count=Integer.parseInt(commands[2]);
                int sum =startIndex+count-1;
                if(sum>=contacts.size()){
                    sum=contacts.size()-1;
                    for (int i = startIndex; i <=sum ; i++) {
                        System.out.print(contacts.get(i)+" ");
                    }
                    System.out.println();
                } else {
                    for (int i = startIndex; i <=sum ; i++) {
                        System.out.print(contacts.get(i)+" ");
                    }
                    System.out.println();
                }
            } else if(command.equals("Print")){
                String type=commands[1];
                if(type.equals("Normal")){
                    System.out.print("Contacts: ");
                    for (int i = 0; i <contacts.size() ; i++) {
                        System.out.print(contacts.get(i)+" ");
                    }
                    break;
                } else {
                    Collections.reverse(contacts);
                    System.out.print("Contacts: ");
                    for (int i = 0; i <contacts.size() ; i++) {
                        System.out.print(contacts.get(i)+" ");
                    }
                    break;
                }
            }
        }
    }
}
