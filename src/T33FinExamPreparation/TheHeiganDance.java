package T33FinExamPreparation;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double dmg = sc.nextDouble();
        sc.nextLine();

        boolean killedBy = false;
        double heiganHP = 3000000;
        int playerHP = 18500;
        int currX = 7;
        int currY = 7;
        boolean dead = false;
        boolean cloudHitted = false;
        while (!dead) {
            String[] attacks = sc.nextLine().split(" ");
            String spell = attacks[0];
            int spellX = Integer.parseInt(attacks[1]);
            int spellY = Integer.parseInt(attacks[2]);
            boolean[][] damaged = new boolean[15][15];
            heiganHP -= dmg;

            if (cloudHitted) {
                playerHP -= 3500;
                cloudHitted = false;
                if (playerHP <= 0) {
                    killedBy = false;
                }
            }

            damaged = Speller(damaged, spellX, spellY, "put");

            if (damaged[currX][currY] && heiganHP > 0 && playerHP > 0) {
                if (currX - 1 >= 0 && !damaged[currX - 1][currY]) {
                    currX -= 1;
                } else if (currY + 1 < 15 && !damaged[currX][currY + 1]) {
                    currY += 1;
                } else if (currX + 1 < 15 && !damaged[currX + 1][currY]) {
                    currX += 1;
                } else if (currY - 1 >= 0 && !damaged[currX][currY - 1]) {
                    currY -= 1;
                } else {
                    if (spell.equals("Cloud")) {
                        playerHP -= 3500;
                        cloudHitted = true;
                        if (playerHP <= 0) {
                            killedBy = false;
                        }
                    } else {
                        playerHP -= 6000;
                        if (playerHP <= 0) {
                            killedBy = true;
                        }
                    }
                }
            }

            damaged = Speller(damaged, spellX, spellY, "remove");


            if (playerHP <= 0) {
                dead = true;
            }
            if (heiganHP <= 0) {
                dead = true;
            }

        }

        if (heiganHP > 0) {

            System.out.printf("Heigan: %.2f%n", heiganHP);
        } else {
            System.out.println("Heigan: Defeated!");
        }

        if (playerHP > 0) {
            System.out.printf("Player: %d%n", playerHP);
        } else {
            if (killedBy) {
                System.out.println("Player: Killed by Eruption");
            } else {
                System.out.println("Player: Killed by Plague Cloud");
            }
        }

        System.out.printf("Final position: %d, %d", currX, currY);
    }


    public static boolean[][] Speller(boolean[][] matrix, int X, int Y, String command) {
        if (command.equals("put")) {
            if ((X >= 0 && X < 15) && (Y >= 0 && Y < 15)) {
                matrix[X][Y] = true;
            }
            if (X - 1 >= 0 && Y - 1 >= 0) {
                matrix[X - 1][Y - 1] = true;
            }
            if (X + 1 < 15 && Y + 1 < 15) {
                matrix[X + 1][Y + 1] = true;
            }
            if (X - 1 >= 0 && Y + 1 < 15) {
                matrix[X - 1][Y + 1] = true;
            }
            if (X + 1 < 15 && Y - 1 >= 0) {
                matrix[X + 1][Y - 1] = true;
            }
            if (Y + 1 < 15 && (X >= 0 && X < 15)) {
                matrix[X][Y + 1] = true;
            }
            if (Y - 1 >= 0 && (X >= 0 && X < 15)) {
                matrix[X][Y - 1] = true;
            }
            if (X - 1 >= 0 && (Y >= 0 && Y < 15)) {
                matrix[X - 1][Y] = true;
            }
            if (X + 1 < 15 && (Y >= 0 && Y < 15)) {
                matrix[X + 1][Y] = true;
            }
        } else {
            if ((X >= 0 && X < 15) && (Y >= 0 && Y < 15)) {
                matrix[X][Y] = false;
            }
            if (X - 1 >= 0 && Y - 1 >= 0) {
                matrix[X - 1][Y - 1] = false;
            }
            if (X + 1 < 15 && Y + 1 < 15) {
                matrix[X + 1][Y + 1] = false;
            }
            if (X - 1 >= 0 && Y + 1 < 15) {
                matrix[X - 1][Y + 1] = false;
            }
            if (X + 1 < 15 && Y - 1 >= 0) {
                matrix[X + 1][Y - 1] = false;
            }
            if (Y + 1 < 15 && (X >= 0 && X < 15)) {
                matrix[X][Y + 1] = false;
            }
            if (Y - 1 >= 0 && (X >= 0 && X < 15)) {
                matrix[X][Y - 1] = false;
            }
            if (X - 1 >= 0 && (Y >= 0 && Y < 15)) {
                matrix[X - 1][Y] = false;
            }
            if (X + 1 < 15 && (Y >= 0 && Y < 15)) {
                matrix[X + 1][Y] = false;
            }
        }
        return matrix;
    }
}
