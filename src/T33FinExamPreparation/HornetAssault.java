package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HornetAssault {
    private static BufferedReader reader;
    private static long[] beehives;
    private static long[] hornets;
    private static long hornetsPower;
    private static int firstAlive;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        receiveInput();

        for (int i = 0; i < beehives.length; i++) {
            long bees = beehives[i];

            if (bees > 0 && bees >= hornetsPower) {
                beehives[i] -= hornetsPower;
                hornetDies();
                hornetsPower = getHornetsPower();
            } else {
                beehives[i] = 0;
            }

        }

        if (areAliveBees()) {
            String aliveHives = getAliveHives();
            System.out.println(aliveHives);
        } else {
            String aliveHornets = getAliveHornets();
            System.out.println(aliveHornets);
        }
    }

    private static boolean areAliveBees() {
        for (long beehive : beehives) {
            if (beehive > 0) {
                return true;
            }
        }
        return false;
    }

    private static void hornetDies() {
        if (firstAlive < hornets.length) {
            hornets[firstAlive++] = 0;
        }
    }

    private static String getAliveHives() {
        StringBuilder output = new StringBuilder();
        for (long beehive : beehives) {
            if (beehive > 0) {
                output.append(beehive).append(" ");
            }
        }
        return output.toString().trim();
    }

    private static String getAliveHornets() {
        StringBuilder output = new StringBuilder();
        for (long hornet : hornets) {
            if (hornet > 0) {
                output.append(hornet).append(" ");
            }
        }
        return output.toString().trim();
    }

    private static long getHornetsPower() {
        long power = 0;
        for (int i = firstAlive; i < hornets.length; i++) {
            power += hornets[i];
        }
        return power;
    }

    private static void receiveInput() throws IOException {
        beehives = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();
        hornets = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();

        hornetsPower = getHornetsPower();
    }
}
