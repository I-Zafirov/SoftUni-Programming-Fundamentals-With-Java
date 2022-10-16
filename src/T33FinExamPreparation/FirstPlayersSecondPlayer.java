package T33FinExamPreparation;

import java.util.Scanner;

public class FirstPlayersSecondPlayer {
    private static boolean gameOver = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] map = new char[size][size];
        int[] firstPlayer = new int[2];
        int[] secondPlayer = new int[2];

        readMap(scanner, size, map, firstPlayer, secondPlayer);

        while (true) {
            String[] command = scanner.nextLine().split("\\s+");

            String firstPlayerCommand = command[0];
            String secondPlayerCommand = command[1];

            firstPlayer = movePlayer(size, map, firstPlayer, firstPlayerCommand, 'f');
            if (gameOver) {
                printMap(size, map);
                break;
            }
            secondPlayer = movePlayer(size, map, secondPlayer, secondPlayerCommand, 's');

            if (gameOver) {
                printMap(size, map);
                break;
            }
        }
    }


    private static int[] movePlayer(int size, char[][] map, int[] player, String command, char mark) {
        if (command.equals("up")) {
            player[0]--;
            if (player[0] < 0) {
                player[0] = size - 1;
            }
        } else if (command.equals("down")) {
            player[0]++;
            if (player[0] > size - 1) {
                player[0] = 0;
            }
        } else if (command.equals("left")) {
            player[1]--;
            if (player[1] < 0) {
                player[1] = size - 1;
            }
        } else if (command.equals("right")) {
            player[1]++;
            if (player[1] > size - 1) {
                player[1] = 0;
            }
        }
        if (map[player[0]][player[1]] == '*') {
            map[player[0]][player[1]] = mark;
        } else {
            map[player[0]][player[1]] = 'x';
            gameOver = true;
        }
        return player;
    }

    private static void readMap(Scanner scanner, int size, char[][] map, int[] firstPlayer, int[] secondPlayer) {
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();

            map[i] = line.toCharArray();

            if (line.contains("f")) {
                firstPlayer[0] = i;
                firstPlayer[1] = line.indexOf("f");
            }

            if (line.contains("s")) {
                secondPlayer[0] = i;
                secondPlayer[1] = line.indexOf("s");
            }
        }
    }

    private static void printMap(int size, char[][] map) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < map[row].length; col++) {
                System.out.print(map[row][col]);
            }
            System.out.println();
        }
    }

}
