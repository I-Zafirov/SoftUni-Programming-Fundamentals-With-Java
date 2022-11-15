package T33FinExamPreparation;

import java.util.Scanner;

public class Monopoly2 {
    static int turns = 0;
    static int money = 50;
    static int hotels = 0;
    static int rows = 0;

    public static void stepCheck(char c, int row, int col) {
        switch (c) {
            case 'H':
                hotels++;
                System.out.format("Bought a hotel for %d. Total hotels: %d.%n", money, hotels);
                money = 0;
                break;
            case 'J':
                System.out.format("Gone to jail at turn %d.%n", turns);
                turns += 2;
                money += hotels * 20;
                break;
            case 'S':
                money -= col * row;
                System.out.format("Spent %d money at the shop.%n", row * col, row, col);
                break;
        }
        if (money < 0) {
            money = 0;
        }
        money += hotels * 10;
        turns++;
    }

    public static void gameCalc(char[] line, int lineNumber) {
        if (lineNumber % 2 == 0) {
            for (int i = line.length - 1; i >= 0; i--) {
                stepCheck(line[i], lineNumber, i + 1);
            }
        } else {
            for (int i = 0; i < line.length; i++) {
                stepCheck(line[i], lineNumber, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();

        try {
            rows = Integer.parseInt(firstLine.split(" ")[0]);
        } catch (Exception e) {

        }
        for (int i = 1; i <= rows; i++) {
            gameCalc(sc.nextLine().toCharArray(), i);

        }
        System.out.format("Turns %d%n", turns);
        System.out.format("Money %d%n", money);
    }
}
