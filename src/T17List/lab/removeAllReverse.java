package T17List.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class removeAllReverse {
    public static void main(String[] args) {
        //с проверка отзад напред
        //removeAll();
        List<String> words = new ArrayList(Arrays.asList("abc", "def", "abc",
                        "abc", "def"));
    }
    private static void removeAll(List<String> elements, String value) {
        int i = elements.size() - 1;
        while (i >= 0) {
            if (elements.get(i).equals(value)) {
                elements.remove(i);
            }
            i--;
        }
    }
}
