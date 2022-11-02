package T33FinExamPreparation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MagicCard {
    public static void main(String[] args) {
        Map<Character, Integer> faces = new HashMap<>();
        faces.put('2',20);
        faces.put('3',30);
        faces.put('4',40);
        faces.put('5',50);
        faces.put('6',60);
        faces.put('7',70);
        faces.put('8',80);
        faces.put('9',90);
        faces.put('1',100);
        faces.put('J',120);
        faces.put('Q',130);
        faces.put('K',140);
        faces.put('A',150);

        int sum = 0;
        Scanner sc = new Scanner(System.in);
        String[] cards = sc.nextLine().split(" ");
        String oddOrEven = sc.nextLine();
        String magicCard = sc.nextLine();

        int start = 0;
        if(oddOrEven.equals("odd")){
            start++;
        }
        for (int i = start; i < cards.length; i+=2) {
            String card = cards[i];
            int cardValue = faces.get(card.charAt(0));
            if (card.charAt(0) == magicCard.charAt(0)) {
                cardValue *= 3;
            } else if (card.charAt(card.length() - 1) == magicCard.charAt(magicCard.length() - 1)) {
                cardValue *= 2;
            }
            sum+=cardValue;
        }

        System.out.println(sum);
    }
}
