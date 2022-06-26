package T19MidExamPreparation;

import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mail = input.nextLine();

        String expression;
        String[] commands;

        while(!(expression = input.nextLine()).equals("Complete")){
            commands = expression.split("\\s+");

            switch (commands[0]){
                case "Make": mail = makesLetters(mail, commands[1]); break;
                case "GetDomain": getsDomain(mail, Integer.parseInt(commands[1])); break;
                case "GetUsername": getsUsername(mail); break;
                case "Replace": mail = replacesLetter(mail, commands[1].charAt(0)); break;
                case "Encrypt": encryptsLetters(mail); break;
                default: break;
            }
        }
    }


    public static String makesLetters(String mail, String command){
        if(command.equals("Upper")){
            mail = mail.toUpperCase();
        }
        else if(command.equals("Lower")){
            mail = mail.toLowerCase();
        }

        System.out.println(mail);
        return mail;
    }


    public static void getsDomain(String mail, int number){
        String result = mail.substring(mail.length() - number, mail.length());

        System.out.println(result);
    }


    public static void getsUsername(String mail){
        StringBuilder result = new StringBuilder();

        if(mail.contains("@")){
            for(int a = 0; a < mail.indexOf("@"); a++){
                result.append(mail.charAt(a));
            }
            System.out.println(result);
        }
        else{
            System.out.printf("The email %s doesn't contain the @ symbol.%n", mail);
        }
    }


    public static String replacesLetter(String mail, char letter){
        String result = mail.replaceAll("" + letter, "-");
        System.out.println(result);

        return result;
    }


    public static void encryptsLetters(String mail){
        for(int b = 0; b < mail.length(); b++){
            System.out.printf("%d ", (int)mail.charAt(b));
        }
        System.out.println();
    }
}
