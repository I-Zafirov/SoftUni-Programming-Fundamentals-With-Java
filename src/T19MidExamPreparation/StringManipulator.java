package T19MidExamPreparation;

import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String text=scanner.nextLine();

        String line=scanner.nextLine();

        while (!line.equals("End")){
            String[] tokens=line.split("\\s+");
            String command=tokens[0];
            if(command.equals("Translate")){
                String textToFind=tokens[1];
                String textToReplace=tokens[2];
                text=text.replace(textToFind,textToReplace);
                System.out.println(text);
            }
            if(command.equals("Includes")){
                String textToFind=tokens[1];
                if(text.contains(textToFind)){
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }
            if(command.equals("Start")){
                String textToFind=tokens[1];
                String newText=text.substring(0,textToFind.length());
                if(newText.equals(textToFind)){
                    System.out.println("True");
                }else {
                    System.out.println("False");
                }
            }
            if(command.equals("Lowercase")){
                text=text.toLowerCase();
                System.out.println(text);
            }
            if(command.equals("FindIndex")){
                String textToFind=tokens[1];
                int n=text.lastIndexOf(textToFind.charAt(0));
                System.out.println(n);
            }
            if(command.equals("Remove")){
                int startIndex=Integer.parseInt(tokens[1]);
                int count=Integer.parseInt(tokens[2]);
                int numTo=startIndex+count;
                StringBuilder newText=new StringBuilder(text);
                /*for (int i = startIndex; i <count ; i++) {
                    newText.deleteCharAt(i);
                }*/
                String text1=text.substring(0,startIndex);
                String text2=text.substring(count+startIndex,text.length());
                text=text1+text2;

                /*while(count>0){
                    newText.deleteCharAt(0);
                    count--;
                }
                text=newText.toString();*/
                System.out.println(text);
            }
            line=scanner.nextLine();
        }
    }
}
