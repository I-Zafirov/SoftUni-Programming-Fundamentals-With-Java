package T19MidExamPreparation;

import java.util.LinkedList;
import java.util.List;

public class NestedList {
    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<>());
        list.get(0).add(5);
        System.out.println(list.get(0).get(0));
    }
}
