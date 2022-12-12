package T33FinExamPreparation;

import java.util.*;

public class UnlikedMeals2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> map = new LinkedHashMap<>();
        int br = 0;
        while (true) {
            String a = scanner.nextLine();
            if (a.equals("Stop")) {
                break;
            }
            String[] arr = a.split("-");
            if (arr[0].equals("Like")) {
                if (map.get(arr[1]) == null) {
                    List<String> list = new ArrayList<>();
                    list.add(arr[2]);
                    map.put(arr[1], list);
                }
                if (!map.get(arr[1]).contains(arr[2])) {
                    map.get(arr[1]).add(arr[2]);
                }


            }

            if (arr[0].equals("Unlike")) {
                if (map.get(arr[1]) == null) {
                    System.out.printf("%s is not at the party.%n", arr[1]);
                } else if (!map.get(arr[1]).contains(arr[2])) {
                    System.out.printf("%s doesn't have the %s in his/her collection.%n", arr[1], arr[2]);
                } else if (map.get(arr[1]).contains(arr[2])) {
                    br++;
                    map.get(arr[1]).remove(arr[2]);
                    System.out.printf("%s doesn't like the %s.%n", arr[1], arr[2]);
                }
            }


        }

        map.entrySet().stream()
                .sorted((p1, p2) -> p1.getKey().compareTo(p2.getKey()))
                .sorted((p3, p4) -> Integer.compare(p4.getValue().size(), p3.getValue().size()))
                .forEach(p -> {
                    System.out.print(p.getKey());
                    System.out.print(": ");
                    for (int i = 0; i < p.getValue().size(); i++) {
                        System.out.print(p.getValue().get(i));
                        if (i != p.getValue().size() - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();

                });

        System.out.print("Unliked meals: ");
        System.out.println(br);

    }
}
