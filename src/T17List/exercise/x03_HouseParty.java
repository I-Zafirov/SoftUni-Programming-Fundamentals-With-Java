package T17List.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class x03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] data = line.split("\\s+");
            String name = data[0];
            if (!line.contains("is not going!")) { // if (data.length == 3){
                if (guests.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guests.add(name);
                }
            } else {
                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        //guests.forEach(guests -> System.out.println(guest));
        guests.forEach(System.out::println);
    }
}
