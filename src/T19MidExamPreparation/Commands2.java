package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Commands2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> listNumbers = new ArrayList<Integer>();
        listNumbers = getnumbers(scan);
        String manipulation = scan.nextLine();
        while ((manipulation.equals("end")) != true) {
            listNumbers = manipulations(listNumbers, manipulation);
            manipulation = scan.nextLine();
        }
        printListNumbers(listNumbers, ", ");

    }

    private static void printListNumbers(List<Integer> listNumbers, String delimiter) {
        String output = "";
        for (int i = 0; i < listNumbers.size(); i++) {
            if (i == (listNumbers.size() - 1)) {
                output += listNumbers.get(i);
            }else {
                output += listNumbers.get(i) + delimiter;
            }
        }

        System.out.println(output);

    }

    private static List<Integer> manipulations(List<Integer> listNumbers, String manipulation) {
        String[] command = manipulation.split(" ");
        List<Integer> output = new ArrayList<Integer>();
        switch (command[0]) {
            case "reverse":
                output = getReverseFromTo(listNumbers, Integer.parseInt(command[2]), Integer.parseInt(command[4]));
                break;
            case "sort":
                output = getSortFromTo(listNumbers, Integer.parseInt(command[2]), Integer.parseInt(command[4]));
                break;
            case "remove":
                output = getRemove(listNumbers, Integer.parseInt(command[1]));
                break;

        }
        return output;

    }

    private static List<Integer> getRemove(List<Integer> listNumbers, int count) {
        if (count > (listNumbers.size() - 1)) {
            count = listNumbers.size();
        }
        for (int i = 0; i < count; i++) {
            listNumbers.remove(0);
        }
        return listNumbers;
    }

    private static List<Integer> getSortFromTo(List<Integer> listNumbers, int start, int count) {
        List<Integer> sort = new ArrayList<Integer>();
        int lastIndex = start + count;
        if (start < 0) {
            if (lastIndex < 0) {
                return listNumbers;
            }else if (lastIndex > (listNumbers.size() - 1)) {
                start = 0;
                lastIndex = listNumbers.size();
            }else {
                start = 0;
            }
        }else if (start > (listNumbers.size() - 1)) {
            return listNumbers;
        }else {
            if (lastIndex < 0) {
                return listNumbers;
            }else if (lastIndex > (listNumbers.size() - 1)) {
                lastIndex = listNumbers.size();
            }
        }

        for (int i = start; i < lastIndex; i++) {
            sort.add(listNumbers.get(i));
        }
        sort.sort(null);
        for (int i = start, j = 0; i < lastIndex; i++, j++) {
            listNumbers.set(i, sort.get(j));
        }
        return listNumbers;
    }

    private static List<Integer> getReverseFromTo(List<Integer> listNumbers, int start, int count) {
        List<Integer> reverse = new ArrayList<Integer>();
        int lastIndex = start + count;
        if (start < 0) {
            if (lastIndex < 0) {
                return listNumbers;
            }else if (lastIndex > (listNumbers.size() - 1)) {
                start = 0;
                lastIndex = listNumbers.size();
            }else {
                start = 0;
            }
        }else if (start > (listNumbers.size() - 1)) {
            return listNumbers;
        }else {
            if (lastIndex < 0) {
                return listNumbers;
            }else if (lastIndex > (listNumbers.size() - 1)) {
                lastIndex = listNumbers.size();
            }
        }

        for (int i = (lastIndex - 1); i >= start; i--) {
            reverse.add(listNumbers.get(i));
        }
        for (int i = start, j = 0; i < lastIndex; i++, j++) {
            listNumbers.set(i, reverse.get(j));
        }
        return listNumbers;
    }

    private static List<Integer> getnumbers(Scanner scan) {
        List<Integer> output = new ArrayList<Integer>();
        String[] input = scan.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            output.add(Integer.parseInt(input[i]));
        }
        return output;
    }

}
