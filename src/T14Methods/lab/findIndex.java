package T14Methods.lab;

import java.util.Scanner;

public class findIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = new String[] {"swedish", "vegans", "marching", "ashore"};

        String searchWord = "vegans";
        int index = findIndex(words, searchWord);

        System.out.println(index);
    }
    private static int findIndex(String[] words, String searchWord){
        for (int i = 0; i < words.length; i++) {
if (words[i].equals(searchWord)){
return i;
            }
        }
        return -1;
    }
}
