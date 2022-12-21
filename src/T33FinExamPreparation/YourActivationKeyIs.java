package T33FinExamPreparation;

import java.util.Scanner;

public class YourActivationKeyIs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rawInput = scan.next();
        String commands = scan.nextLine();

        while (!commands.equals("Generate")) {
            String[] tokens = commands.split(">>>");
            String cmd = tokens[0];

            switch (cmd) {
                case "Contains":
                    String substring = tokens[1];
                    if (rawInput.contains(substring)) {
                        System.out.println(String.format("%s contains %s", rawInput, substring));
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String secondCmd = tokens[1];

                    switch (secondCmd) {
                        case "Upper":
                            int startIndex = Integer.parseInt(tokens[2]);
                            int endIndex = Integer.parseInt(tokens[3]);
                            String cutSub = rawInput.substring(startIndex, endIndex);
                            String newSubUpperCase = cutSub.toUpperCase();
                            rawInput = rawInput.replace(cutSub, newSubUpperCase);
                            System.out.println(rawInput);
                            break;
                        case "Lower":
                            startIndex = Integer.parseInt(tokens[2]);
                            endIndex = Integer.parseInt(tokens[3]);
                            cutSub = rawInput.substring(startIndex, endIndex);
                            String newSubLowerCase = cutSub.toLowerCase();
                            rawInput = rawInput.replace(cutSub, newSubLowerCase);
                            System.out.println(rawInput);
                            break;

                    }
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    String substringToCut = rawInput.substring(startIndex, endIndex);
                    rawInput = rawInput.replace(substringToCut, "");
                    System.out.println(rawInput);
                    break;

            }

            commands = scan.nextLine();
        }
        System.out.println(String.format("Your activation key is: %s", rawInput));
    }
}
