package T33FinExamPreparation;

import java.util.HashSet;
import java.util.Scanner;

public class CollectResources2 {
    public static void main(String[] args) {
        HashSet<String> materials = new HashSet<>(); //holds the usefull resources.
        materials.add("wood");
        materials.add("gold");
        materials.add("stone");
        materials.add("food");

        Scanner sc = new Scanner(System.in);
        String[] fields = sc.nextLine().split(" "); // all the fields
        int[] resources = new int[fields.length];
        int finalResult = 0;

        if (!fields[0].equals("")) {
            for (int i = 0; i < fields.length; i++) {
                String[] field = fields[i].split("_");
                if (field.length < 2 && materials.contains(field[0])) {
                    resources[i] = 1;
                } else if (materials.contains(field[0])) {
                    resources[i] = Integer.parseInt(field[1]);
                }

            }

            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int steps = sc.nextInt();
                int currentResult = collect(start, steps, resources.clone());

                if (currentResult > finalResult) {
                    finalResult = currentResult;
                }
            }
        }
        System.out.println(finalResult);
    }

    private static int collect(int start, int steps, int[] resources) {
        int result = 0;

        int index = start;

        while (resources[index] != -1) {
            result += resources[index]; //add resourses to sum
            resources[index] = -1;  //mark it as visited
            index += steps;

            while (index > resources.length - 1) {
                index -= resources.length;
            }
        }
        return result;
    }
}
