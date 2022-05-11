package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> myContacts = new ArrayList<>();
        String[] data = input.nextLine().split("\\s+");

        for(String contact : data){
            myContacts.add(contact);
        }

        while (true) {
            String[] command = input.nextLine().split("\\s+");

            if(command[0].equals("Print")){
                printsContacts(myContacts, command[1]);
                break;
            }

            switch (command[0]){
                case "Add": addsAContact(myContacts, command[1], Integer.parseInt(command[2])); break;
                case "Remove": removesAContact(myContacts, Integer.parseInt(command[1])); break;
                case "Export": exportsAContact(myContacts, Integer.parseInt(command[1]), Integer.parseInt(command[2])); break;
                default: break;
            }
        }
    }

    public static void addsAContact (ArrayList<String> contacts, String contact, int index){
        if(contacts.contains(contact) && index >= 0 && index < contacts.size()){
            contacts.add(index, contact);
        }

        if(!contacts.contains(contact) && index >= 0){
            contacts.add(contact);
        }
    }

    public static void removesAContact (ArrayList<String> contacts, int index){
        if(index >= 0 && index < contacts.size()){
            contacts.remove(index);
        }
    }

    public static void exportsAContact (ArrayList<String> contacts, int index, int number){
        if(index >= 0 && index + number < contacts.size()){
            for(int a = index; a < index + number; a++){
                System.out.printf("%s ", contacts.get(a));
            }
            System.out.println();
        }
        else if(index >= 0 && index + number >= contacts.size()){
            for(int b = index; b < contacts.size(); b++){
                System.out.printf("%s ", contacts.get(b));
            }
            System.out.println();
        }
    }

    public static void printsContacts(ArrayList<String> contacts, String order){
        if(order.equals("Normal")){
            System.out.print("Contacts: ");
            for(String print : contacts){
                System.out.printf("%s ", print);
            }
        }
        else if(order.equals("Reversed")){
            System.out.print("Contacts: ");
            for(int c = contacts.size() - 1; c >= 0; c--){
                System.out.printf("%s ", contacts.get(c));
            }
        }
    }
}


