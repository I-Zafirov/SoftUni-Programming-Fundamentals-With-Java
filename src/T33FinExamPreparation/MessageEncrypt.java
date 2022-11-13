package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        String expression;
        boolean isThereAnyCoincidence = false;
        Pattern pattern = Pattern
                .compile("([*|@])(?<message>[A-Z][a-z][a-z]+)\\1:\\s\\[(?<one>[A-Za-z])\\]\\|\\[(?<two>[A-Za-z])\\]\\|\\[(?<three>[A-Za-z])\\]\\|?$");

        for (int a = 0; a < number; a++) {
            expression = scanner.nextLine();
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find()) {
                String message = matcher.group("message");
                String one = matcher.group("one");
                String two = matcher.group("two");
                String three = matcher.group("three");
                if (!message.equals("") && !one.equals("") && !two.equals("") && !three.equals("")) {
                    System.out.printf("%s: %d %d %d%n", message, (int) one.charAt(0), (int) two.charAt(0), (int) three.charAt(0));
                }
                isThereAnyCoincidence = true;
                message = "";
                one = "";
                two = "";
                three = "";
            }
            if (!isThereAnyCoincidence) {
                System.out.println("Valid message not found!");
            } else {
                isThereAnyCoincidence = false;
            }
        }
    }
}


//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int number = Integer.parseInt(input.nextLine());
//
//        String expression;
//        Pattern pattern = Pattern.compile("([*@])(?<message>[A-Z][a-z][a-z]+)\\1:\\s\\[(?<one>[A-Za-z])\\]\\|\\[(?<two>[A-Za-z])\\]\\|\\[(?<three>[A-Za-z])\\]\\|?$");
//
//        for (int a = 0; a < number; a++) {
//            expression = input.nextLine();
//
//            Matcher matcher = pattern.matcher(expression);
//
//            try{
//                matcher.find();
//                String message = matcher.group("message");
//                String one = matcher.group("one");
//                String two = matcher.group("two");
//                String three = matcher.group("three");
//
//                System.out.printf("%s: %d %d %d%n", message, (int)one.charAt(0), (int)two.charAt(0), (int)three.charAt(0));
//            }
//            catch (Exception ex){
//                System.out.println("Valid message not found!");
//            }
//        }
//    }
