package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Icarus2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int indexPosition = Integer.parseInt(reader.readLine());
        int damage = 1;

        String command = reader.readLine();
        while (!"Supernova".equals(command)) {
            String[] commArr = command.split("\\s+");
            String direction = commArr[0];
            int steps = Integer.parseInt(commArr[1]);

            switch (direction) {
                case "left":
                    for (int i = 0; i < steps; i++) {
                        indexPosition--;

                        if (indexPosition < 0) {
                            indexPosition = numbers.length - 1;
                            damage++;
                        }

                        numbers[indexPosition] -= damage;
                    }
                    break;
                case "right":
                    for (int i = 0; i < steps; i++) {
                        indexPosition++;

                        if (indexPosition > numbers.length - 1) {
                            indexPosition = 0;
                            damage++;
                        }

                        numbers[indexPosition] -= damage;
                    }
                    break;
            }


            command = reader.readLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
