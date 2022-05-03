package T19MidExamPreparation;

import java.util.*;

public class _P1_ {
    private static List<Integer> pairs = new LinkedList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");
        String[] secondLine = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        populateData(firstLine, secondLine, stack, queue);

        while (true) {
            if (stack.isEmpty() || queue.isEmpty()) {
                break;
            }
            Integer leftSock = stack.peek();
            Integer rightSock = queue.peek();

            if (leftSock > rightSock) {
                createPair(leftSock, rightSock, stack, queue);
            } else if (rightSock > leftSock) {
                stack.pop();
            } else {
                incrementNremove(stack, queue);
            }
        }

        System.out.println(Collections.max(pairs));
        pairs.forEach(p -> System.out.print(p + " "));
    }

    private static void incrementNremove(ArrayDeque<Integer> stack, ArrayDeque<Integer> queue) {
        Integer element = stack.pop();
        stack.push(element + 1);

        queue.poll();
    }

    private static void createPair(Integer leftSock, Integer rightSock, ArrayDeque<Integer> stack, ArrayDeque<Integer> queue) {
        pairs.add(leftSock + rightSock);
        stack.pop();
        queue.poll();
    }


    private static void populateData(String[] firstLine, String[] secondLine, ArrayDeque<Integer> stack, ArrayDeque<Integer> queue) {
        for (String element : firstLine) {
            stack.push(Integer.valueOf(element));
        }
        for (String element : secondLine) {
            queue.offer(Integer.valueOf(element));
        }
    }
}
