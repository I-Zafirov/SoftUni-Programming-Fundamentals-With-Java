package T19MidExamPreparation;

import java.util.*;

public class CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String values = scanner.nextLine();
        String[] items = values.split(" ");
        List<String> coffees = new ArrayList<>();

        coffees.addAll(Arrays.asList(items));

        int commands = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        String[] arr = command.split(" ");

        for (int i = 0; i < commands; i++) {
            switch (arr[0]) {
                case "Include":
                    coffees.add(arr[1]);
                    break;
                case "Remove":
                    int num = Integer.parseInt(arr[2]);
                    if (coffees.size() < num) {
                        break;
                    }
                    if (arr[1].equals("first")) {
                        for (int j = 0; j < num; j++) {
                            coffees.remove(0);
                        }
                    } else if (arr[1].equals("last")) {
                        for (int j = 0; j < num; j++) {
                            coffees.remove(coffees.size() - 1);
                        }
                    }
                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(arr[1]);
                    int index2 = Integer.parseInt(arr[2]);
                    if (index1 >= coffees.size() || index2 >= coffees.size()) {
                        break;
                    }
                    String item1 = coffees.get(index1);
                    String item2 = coffees.get(index2);
                    coffees.set(index1, item2);
                    coffees.set(index2, item1);
                    break;
                case "Reverse":
                    Collections.reverse(coffees);
                    break;
            }
            if (i < commands - 1) {
                command = scanner.nextLine();
                arr = command.split(" ");
            }
        }

        System.out.println("Coffees:");
        for (int i = 0; i < coffees.size(); i++) {
            System.out.printf("%s ", coffees.get(i));
        }
    }
}
