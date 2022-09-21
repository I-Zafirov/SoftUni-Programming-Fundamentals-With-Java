package T19MidExamPreparation;

import java.util.Scanner;

public class TelerikPageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(", ");
        int wordsPerPage = Integer.parseInt(scanner.nextLine());
        String keyword = scanner.nextLine();

        int index = -1;
        int size = words.length;

        for (int i = 0; i < size; i++) {
            String currentWord = words[i];
            if(currentWord.equals(keyword)){
                index = i;
            }
        }

        int page = (index + 1) / wordsPerPage;
        if ((index + 1) % wordsPerPage != 0){
            page += 1;
        }

        if (index != -1){
            System.out.println(page);
        }else{
            System.out.println(index);
        }
    }
}
