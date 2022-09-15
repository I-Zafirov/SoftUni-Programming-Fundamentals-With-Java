package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> kids = Arrays.stream(scanner.nextLine().split("&"))
                .collect(Collectors.toList());

        String input = "";

        while (!"Finished!".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            String command = data[0];
            String kidName = data[1];

            switch (command) {
                case "Bad":
                    if (!kids.contains(kidName)) {
                        kids.add(0,kidName);
                    }
                    break;

                case "Good":
                    kids.remove(kidName);
                    break;

                case "Rename":
                    if (kids.contains(kidName)) {
                        String newKidName = data[2];
                        int kidIndex = kids.indexOf(kidName);
                        kids.set(kidIndex,newKidName);
                    }
                    break;

                case "Rearrange":
                    if (kids.contains(kidName)) {
                        kids.remove(kidName);
                        kids.add(kidName);
                    }
                    break;

            }
        }

        System.out.println(kids.toString().replaceAll("[\\[\\]]",""));
    }
}
