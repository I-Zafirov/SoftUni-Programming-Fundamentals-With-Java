package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MemoryView {
    private static BufferedReader reader;
    private static StringBuilder input;
    private static int[] memory;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        input = new StringBuilder();
    }

    public static void main(String[] args) throws IOException {
        readLines();

        memory = Arrays.stream(input.toString().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < memory.length - 6; i++) {
            int pointerA = memory[i], pointerB = memory[i + 1], pointerC = memory[i + 2];
            if (pointerA == 32656 && pointerB == 19759 && pointerC == 32763 && memory[i + 3] == 0 && memory[i + 5] == 0) {
                int size = memory[i + 4];
                StringBuilder result = new StringBuilder();
                for (int j = i + 6; j < i + 6 + size; j++) {
                    result.append((char) memory[j]);
                }
                System.out.println(result.toString());
                i += 5 + size;
            }
        }


    }

    private static void readLines() throws IOException {
        String line;
        while (!"Visual Studio crash".equals(line = reader.readLine())) {
            input.append(line).append(" ");
        }
    }
}
