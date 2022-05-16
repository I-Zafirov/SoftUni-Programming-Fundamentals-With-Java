package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EasterGifts2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> giftList = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String input;

        while (!"No Money".equals(input = scan.nextLine())) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "OutOfStock":
                    IntStream.range(0, giftList.size()).filter(i -> giftList.get(i).equals(command[1]))
                            .forEach(i -> giftList.set(i, "None"));
                    break;
                case "Required":
                    if (Integer.parseInt(command[2]) >= 0 && Integer.parseInt(command[2]) < giftList.size()) {
                        giftList.set(Integer.parseInt(command[2]), command[1]);
                    }
                    break;
                case "JustInCase":
                    giftList.set(giftList.size() - 1, command[1]);
                    break;
            }
        }
        IntStream.range(0, giftList.size()).filter(i -> !giftList.get(i).equals("None"))
                .mapToObj(giftList::get).map(s -> s + " ").forEach(System.out::print);
    }
}
