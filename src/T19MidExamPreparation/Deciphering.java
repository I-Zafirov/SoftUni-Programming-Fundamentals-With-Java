package T19MidExamPreparation;

import java.util.Scanner;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String text=scanner.nextLine();
        String line=scanner.nextLine();
        String[] tokens=line.split(" ");
        if(isValid(text)){
            StringBuilder newWord=new StringBuilder();
            for (int i = 0; i <text.length() ; i++) {
                int n=(int)text.charAt(i)-3;
                char c=(char)n;
                newWord.append(c);
            }
            String word=newWord.toString();
            String myWord=word.replaceAll(tokens[0],tokens[1]);
            System.out.println(myWord);
        } else {

            System.out.println("This is not the book you are looking for.");
        }

    }

    private static boolean isValid(String text) {
        boolean valid=true;
        for (int i = 0; i <text.length() ; i++) {
            char symbol=text.charAt(i);
            if((symbol<100 || symbol>122) &&  (symbol!='{' && symbol!='}' && symbol!='|' && symbol!='#')){
                valid=false;
            }
        }
        return valid;
    }
}
