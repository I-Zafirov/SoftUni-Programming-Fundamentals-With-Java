package x17_List.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class foundElement {
    public static void main(String[] args) {
        // намери дали го има и на кой индекс е
        // ако индекса е -1, няма го в масива
        List<String> words = new ArrayList
                (Arrays.asList("abc", "def", "abc",
                        "abc", "def"));
        int index = words.indexOf("gjv");
        if(index == -1){
            System.out.println("not fount");
        }else{
            System.out.println("not fount");
        }
    }
}
