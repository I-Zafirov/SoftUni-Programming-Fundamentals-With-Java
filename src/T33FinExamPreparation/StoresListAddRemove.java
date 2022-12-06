package T33FinExamPreparation;

import java.util.*;

public class StoresListAddRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> storedItems = new LinkedHashMap<>();
        String input;

        while (!"END".equals(input = scanner.nextLine())) {
            String[] a = input.split("->");

            if (a[0].equals("Add")) {
                storedItems.putIfAbsent(a[1], new ArrayList<>());
                String[] b = a[2].split(",");
                for (String item : b) {
                    storedItems.get(a[1]).add(item);
                }
            } else if (a[0].equals("Remove")) {
                storedItems.remove(a[1]);
            }
        }
        System.out.println("Stores list:");
        storedItems.entrySet().stream().sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (sort == 0) {
                        sort = e2.getKey().compareTo(e1.getKey());
                    }
                    return sort;
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    //e.getValue().sort((s1, s2) -> s2.compareTo(s1));
                    for (String item : e.getValue()) {
                        System.out.println(String.format("<<%s>>", item));
                    }
                });
    }
}
