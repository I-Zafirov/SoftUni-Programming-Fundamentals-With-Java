package T33FinExamPreparation;

import java.util.*;

public class RoyalFlushesClubsDiamondsHeartsSpades {
    static List<String> suits = Arrays.asList(new String[]{"s", "d", "h", "c"});
    static LinkedList<String> flushCards = new LinkedList<>(Arrays.asList(new String[]{"10", "J", "Q", "K", "A"}));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lines = sc.nextInt();
        sc.nextLine();

        LinkedList<String> allCards = new LinkedList<>();
        for (int i = 0; i < lines; i++) {
            String hand = sc.nextLine();
            int size = 0;
            for (int j = 0; j < hand.length(); j++) {
                if (suits.contains(String.valueOf(hand.charAt(j)))) {
                    allCards.add(hand.substring(size, j + 1));
                    size = j + 1;
                }
            }
        }

        int count = 0;
        boolean expanded = false;

        while (!expanded) {
            String combinSuit = "";
            LinkedList<String> combin = new LinkedList<>();
            boolean combinFound = false;
            expanded = true;
            List<Integer> indexes = new ArrayList<>();

            for (int i = 0; i < allCards.size() && !combinFound; i++) {
                String currCard = allCards.get(i).substring(0, allCards.get(i).length() - 1);
                String currSuit = allCards.get(i).substring(allCards.get(i).length() - 1, allCards.get(i).length());

                if (flushCards.contains(currCard)) {
                    if (combin.size() == 0 && currCard.equals("10")) {
                        combin.add(currCard + currSuit);
                        combinSuit = currSuit;
                        allCards.remove(i);
                        i--;
                    } else if (flushCards.get(combin.size()).equals(currCard) && combinSuit.equals(currSuit)) {
                        combin.add(currCard);
                        indexes.add(i);
                    } else if (combinSuit.equals(currSuit) && !flushCards.get(combin.size()).equals(currCard)) {
                        combinFound = true;
                    }

                } else if (combinSuit.equals(currSuit)) {
                    combinFound = true;
                    i--;
                } else {
                    allCards.remove(i);
                    i--;
                }

                if (combin.size() == 5) {
                    String suitCombin = combin.get(0).substring(combin.get(0).length() - 1, combin.get(0).length());
                    if (suitCombin.equals("s")) {
                        System.out.println("Royal Flush Found - Spades");
                    } else if (suitCombin.equals("h")) {
                        System.out.println("Royal Flush Found - Hearts");
                    } else if (suitCombin.equals("d")) {
                        System.out.println("Royal Flush Found - Diamonds");
                    } else if (suitCombin.equals("c")) {
                        System.out.println("Royal Flush Found - Clubs");
                    }
                    count++;
                    combinFound = true;


                    for (int j = 0; j < indexes.size(); j++) {
                        int place = indexes.get(j);
                        allCards.set(place, "m");
                    }
                    for (int j = 0; j < allCards.size(); j++) {
                        if (allCards.get(j).equals("m")) {
                            allCards.remove(j);
                            j--;
                        }
                    }
                }
            }

            for (int i = 0; i < allCards.size(); i++) {
                String currCard = allCards.get(i).substring(0, allCards.get(i).length() - 1);
                if (currCard.equals("10")) {
                    expanded = false;
                }
            }
        }
        System.out.println("Royal's Royal Flushes - " + count + ".");
    }
}
