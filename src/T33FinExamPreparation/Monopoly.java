package T33FinExamPreparation;

import java.util.Scanner;

public class Monopoly {
    private static int moneyPerTurn = 0;
    private static int money = 50;
    private static int turn = 0;
    private static int totalHotels = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();

        String[][] board = new String[row][col];

        for (int i = 0; i < board.length; i++) {
            String[] rows = scanner.nextLine().split("");
            for (int j = 0; j < rows.length; j++) {
                board[i][j] = rows[j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            String[] line = board[i];
            if (i % 2 == 0) {
                for (int j = 0; j < line.length; j++) {
                    update((i + 1) * (j + 1), line[j]);
                }
            } else {
                for (int j = line.length - 1; j >= 0; j--) {
                    update((i + 1) * (j + 1), line[j]);
                }
            }
        }

        System.out.printf("Turns %d\n", turn);
        System.out.printf("Money %d\n", money);
    }

    private static void update(int i, String s) {
        switch (s) {
            case "H":
                turn++;
                totalHotels++;
                System.out.printf("Bought a hotel for %d. Total hotels: %d.\n", money, totalHotels);
                money = 0;
                moneyPerTurn += 10;
                break;
            case "J":
                System.out.printf("Gone to jail at turn %d.\n", turn);
                turn += 3;
                money += 2 * moneyPerTurn;
                break;
            case "F":
                turn++;
                break;
            case "S":
                int moneyToSpend = i;
                moneyToSpend = moneyToSpend > money ? money : moneyToSpend;
                money -= moneyToSpend;
                System.out.printf("Spent %d money at the shop.\n", moneyToSpend);
                turn++;
                if (money < 0) {
                    money = 0;
                }
                break;
        }

        money += moneyPerTurn;
    }
}
