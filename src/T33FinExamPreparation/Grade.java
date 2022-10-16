package T33FinExamPreparation;

import java.util.*;

public class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        String[] headerInfo = scanner.nextLine().split(", ");
        List<String> header = new LinkedList<>(Arrays.asList(headerInfo));
        String[][] table = new String[lines - 1][header.size()];
        for (int row = 0; row < lines - 1; row++) {
            String[] input = scanner.nextLine().split(", ");
            for (int col = 0; col < header.size(); col++) {

                table[row][col] = input[col];
            }
        }
        String[] command = scanner.nextLine().split("\\s+");
        switch (command[0]) {
            case "hide":
                if (header.contains(command[1])) {
                    printWithout(command[1], header, table, lines - 1);
                }
                break;
            case "sort":
                if (header.contains(command[1])) {
                    printSorted(command[1], header, table, lines - 1);
                }
                break;
            case "filter":
                if (header.contains(command[1])) {
                    printFiltered(command[1], command[2], header, table, lines - 1);
                }
                break;
            default:
                break;
        }
    }

    private static void printFiltered(String filterHead, String filterValue, List<String> header, String[][] table, int rowsCount) {
        System.out.println(String.join(" | ", header));
        int filterHeadIndex = header.lastIndexOf(filterHead);
        List<String> result = new ArrayList<>();
        for (int row = 0; row < rowsCount; row++) {
            for (int col = 0; col < header.size(); col++) {
                if (table[row][col].equals(filterValue) && col == filterHeadIndex) {
                    result.addAll(Arrays.asList(table[row]).subList(0, header.size()));
                }
            }
        }
        System.out.println(String.join(" | ", result));
    }

    private static void printSorted(String sortBy, List<String> header, String[][] table, int rowsCount) {
        int sortingColumnIndex = header.lastIndexOf(sortBy);

        List<List<String>> tableAsList = tableAsList(header, table, rowsCount);

        tableAsList.sort(Comparator.comparing(list -> list.get(sortingColumnIndex)));
        if (sortBy.equals("grade")) {
            Collections.reverse(tableAsList);
        }
        System.out.println(String.join(" | ", header));
        tableAsList.forEach(list -> System.out.println(String.join(" | ", list)));
    }

    private static List<List<String>> tableAsList(List<String> header, String[][] table, int rowsCount) {
        List<List<String>> tableAsList = new LinkedList<>();
        for (int row = 0; row < rowsCount; row++) {

            List<String> colData = new LinkedList<>();
            for (int col = 0; col < header.size(); col++) {
                colData.add(table[row][col]);
            }
            tableAsList.add(colData);
        }
        return tableAsList;
    }

    private static void printWithout(String s, List<String> header, String[][] table, int rowsCount) {
        int colsCount = header.size();
        List<String> hideHeader = new ArrayList<>(header);
        hideHeader.remove(s);
        System.out.println(String.join(" | ", hideHeader));
        for (int row = 0; row < rowsCount; row++) {
            List<String> rowString = new ArrayList<>();
            for (int col = 0; col < colsCount; col++) {
                if (!header.get(col).equals(s)) {
                    rowString.add(table[row][col]);
                }
            }
            System.out.println(String.join(" | ", rowString));
        }
    }
}
