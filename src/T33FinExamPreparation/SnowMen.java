package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SnowMen {
    private static BufferedReader reader;
    private static List<Integer> snowmen;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    public static void main(String[] args) throws IOException {
        receiveInput();

        while (snowmen.size() != 1) {

            for (int attackerIndex = 0; attackerIndex < snowmen.size(); attackerIndex++) {

                if (snowmen.get(attackerIndex) >= 0) {
                    int targetIndex = snowmen.get(attackerIndex) % snowmen.size();
                    int diff = Math.abs(attackerIndex - targetIndex);
                    performAttack(attackerIndex, targetIndex, diff);
                }

                if (isStandAlone()) {
                    return;
                }
            }

            removeDeadSnowMen();
        }

    }

    private static void performAttack(int attackerIndex, int targetIndex, int diff) {
        if (attackerIndex == targetIndex) {
            System.out.println(String.format("%d performed harakiri", attackerIndex));
            snowmen.set(attackerIndex, -1);
        } else if (diff % 2 == 0) {
            System.out.println(String.format("%d x %d -> %d wins", attackerIndex, targetIndex, attackerIndex));
            snowmen.set(targetIndex, -1);
        } else if (diff % 2 != 0) {
            System.out.println(String.format("%d x %d -> %d wins", attackerIndex, targetIndex, targetIndex));
            snowmen.set(attackerIndex, -1);
        }
    }

    private static void removeDeadSnowMen() {
        snowmen = snowmen
                .stream()
                .filter(integer -> integer >= 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static boolean isStandAlone() {
        return snowmen.stream()
                .filter(integer -> integer >= 0)
                .count() == 1;
    }

    private static void receiveInput() throws IOException {
        snowmen = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
