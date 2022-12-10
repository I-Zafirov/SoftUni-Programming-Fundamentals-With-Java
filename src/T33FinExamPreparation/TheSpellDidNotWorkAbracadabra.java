package T33FinExamPreparation;

import java.util.Scanner;

public class TheSpellDidNotWorkAbracadabra {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        StringBuilder data = new StringBuilder(inp.nextLine());
        String input = inp.nextLine();
        while (!input.equals("Abracadabra")) {
            String[] inputData = input.split(" ");
            String command = inputData[0];
            int index;
            switch (command) {
                case "Abjuration":
                    String d = data.toString().toUpperCase();
                    data = new StringBuilder(d);
                    System.out.println(d);
                    break;
                case "Necromancy":
                    String l = data.toString().toLowerCase();
                    data = new StringBuilder(l);
                    System.out.println(l);
                    break;
                case "Illusion":
                    index = Integer.parseInt(inputData[1]);
                    if (index < 0 || index >= data.toString().length()) {
                        System.out.println("The spell was too weak.");
                    } else {
                        data.deleteCharAt(index);
                        data.insert(index, inputData[2]);
                        System.out.println("Done!");
                    }
                    break;
                case "Divination":
                    String old = inputData[1];
                    String newOne = inputData[2];
                    if (data.toString().contains(inputData[1])) {
                        data = new StringBuilder(data.toString().replaceAll(old, newOne));
                        System.out.println(data);
                    }
                    break;
                case "Alteration":
                    String val = inputData[1];
                    if (data.toString().contains(inputData[1])) {
                        data = new StringBuilder(data.toString().replaceAll(val, ""));
                        System.out.println(data);
                    }
                    break;
                default:
                    System.out.println("The spell did not work!");
            }
            input = inp.nextLine();
        }
    }
}
