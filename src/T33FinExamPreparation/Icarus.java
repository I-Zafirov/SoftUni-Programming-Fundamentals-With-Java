package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Icarus {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> numbersList = Arrays.stream(reader.readLine().split("\\s+")).map(Long::valueOf).collect(Collectors.toList());

        int indexPosition = Integer.parseInt(reader.readLine());
        int[] indexP = new int[2];
        indexP[0] = indexPosition;
        indexP[1] = 1;

        String command = reader.readLine();

        while (!"Supernova".equals(command)) {
            String[] commandArr = command.split("\\s+");
            String direction = commandArr[0];
            int steps = Integer.parseInt(commandArr[1]);

            switch (direction) {
                case "left":
                    IcarusStepingLeft(numbersList, steps, indexP);
                    break;
                case "right":
                    IcarusStepingRight(numbersList, steps, indexP);
                    break;
            }

            command = reader.readLine();
        }

        for (Long num : numbersList) {
            System.out.print(num + " ");
        }

    }

    private static void IcarusStepingRight(List<Long> numbersList, int steps, int[] indexP) {
        int index = indexP[0];
        int damage = indexP[1];

        for (int i = 0; i < steps; i++) {
            index++;

            if (index > numbersList.size() - 1) {
                index = 0;
                damage++;
            }

            long value = numbersList.get(index) - damage;
            numbersList.set(index, value);
        }

        indexP[0] = index;
        indexP[1] = damage;
    }

    private static void IcarusStepingLeft(List<Long> numbersList, int steps, int[] indexP) {
        int index = indexP[0];
        int damage = indexP[1];

        for (int i = 0; i < steps; i++) {
            index--;

            if (index < 0) {
                index = numbersList.size() - 1;
                damage++;
            }

            long value = numbersList.get(index) - damage;
            numbersList.set(index, value);
        }

        indexP[0] = index;
        indexP[1] = damage;
    }
}
