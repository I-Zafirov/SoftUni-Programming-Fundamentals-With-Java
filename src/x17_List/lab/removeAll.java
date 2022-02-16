package x17_List.lab;

import java.util.List;

public class removeAll {
    public static void main(String[] args) {
        // Метод за премахване на елемент
        // removeAll();
    }
    private static void removeAll(List<String> elements, String value) {
        int i = 0;
        while (i < elements.size()) {
            if (elements.get(i).equals(value)) {
                elements.remove(i);
            } else {
                i++;
            }
        }
    }
}