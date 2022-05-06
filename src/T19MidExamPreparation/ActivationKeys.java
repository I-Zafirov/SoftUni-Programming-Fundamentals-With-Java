package T19MidExamPreparation;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] commands = scan.nextLine().split(">>>");

        while (!commands[0].equals("Generate")) {

            switch (commands[0]) {
                case "Contains":
                    String substring = commands[1];
                    if (input.contains(substring)) {
                        System.out.println(input + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(commands[2]);
                    int endIndex = Integer.parseInt(commands[3]);

                    String newString = input.substring(startIndex, endIndex);

                    if(commands[1].equals("Upper")){
                        newString = newString.toUpperCase();
                        StringBuilder sb = new StringBuilder();
                        sb.append(input);
                        sb.replace(startIndex, endIndex, newString);
                        input = sb.toString();
                    }else{
                        newString = newString.toLowerCase();
                        StringBuilder sb = new StringBuilder();
                        sb.append(input);
                        sb.replace(startIndex, endIndex, newString);
                        input = sb.toString();
                    }
                    System.out.println(input);

                    break;
                case "Slice":
                    int start = Integer.parseInt(commands[1]);
                    int end = Integer.parseInt(commands[2]);

                    StringBuilder sb = new StringBuilder();
                    sb.append(input);
                    sb.replace(start, end, "");
                    input = sb.toString();

                    System.out.println(input);
                    break;
            }
            commands = scan.nextLine().split(">>>");
        }
        System.out.println("Your activation key is: " + input);
    }
}
