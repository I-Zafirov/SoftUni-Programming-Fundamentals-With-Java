package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[num][num];
        List<String> commands = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        int countFood = 0;
        int lenght = 1;
        int col = 0;
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = input[j];
                if (input[j].equals("f")) {
                    countFood++;
                }
                if (input[j].equals("s")) {
                    row = i;
                    col = j;
                }

            }
        }
        System.out.println();
        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);

            if ("up".equals(command)) {
                if (row == 0) {
                    row = matrix.length - 1;
                } else {
                    row = row - 1;
                }

            } else if ("right".equals(command)) {
                if (col == matrix[0].length - 1) {
                    col = 0;
                } else {
                    col = col + 1;
                }
            } else if ("left".equals(command)) {
                if (col == 0) {
                    col = matrix[0].length - 1;
                } else {
                    col = col - 1;
                }

            } else if ("down".equals(command)) {
                if (row == matrix.length - 1) {
                    row = 0;
                } else {
                    row = row + 1;
                }
            }

            if (matrix[row][col].equals("f")) {
                countFood--;
                lenght++;
                if (countFood == 0) {
                    System.out.printf("You win! Final snake length is %d", lenght);
                    return;
                }
            } else if (matrix[row][col].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }
        System.out.printf("You lose! There is still %d food to be eaten.", countFood);

    }
}
