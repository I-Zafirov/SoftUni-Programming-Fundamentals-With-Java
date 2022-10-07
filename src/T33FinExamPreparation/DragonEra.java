package T33FinExamPreparation;

import java.util.*;

public class DragonEra {
    public static void main(String[] args) {
        HashMap<String, Integer> year = new HashMap<>();
        year.put("Normal", 1);
        year.put("Good", 2);
        year.put("Bad", 0);

        Scanner sc = new Scanner(System.in);
        int dragonsStart = sc.nextInt();
        sc.nextLine();

        LinkedHashMap<String, List<Integer>> dragons = new LinkedHashMap<>();
        HashMap<String, Integer> dragonsAge = new HashMap<>();
        int currDragon = 1;
        for (int i = 0; i < dragonsStart; i++) {
            int eggs = sc.nextInt();
            sc.nextLine();

            String currName = "Dragon_" + currDragon;
            currDragon++;

            dragons.put(currName, new ArrayList<>());
            dragonsAge.put(currName, 0);
            for (int j = 0; j < eggs; j++) {
                dragons.get(currName).add(0);
            }
        }

        int years = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < years; i++) {
            String yearType = sc.nextLine();

            for (Map.Entry<String, List<Integer>> entrys : dragons.entrySet()) {
                dragonsAge.put(entrys.getKey(), dragonsAge.get(entrys.getKey()) + 1);

                for (int j = 0; j < entrys.getValue().size(); j++) {
                    dragons.get(entrys.getKey()).set(j, dragons.get(entrys.getKey()).get(j) + 1);
                }
                dragons.get(entrys.getKey()).add(0);
            }

            for (Map.Entry<String, Integer> entrys : dragonsAge.entrySet()) {

                if (dragonsAge.get(entrys.getKey()) == 3 || dragonsAge.get(entrys.getKey()) == 4) {
                    dragons.get(entrys.getKey()).add(0);
                }
                if (dragonsAge.get(entrys.getKey()) == 6) {
                    dragons.remove(entrys.getKey());
                    dragonsAge.remove(entrys.getKey());
                }
            }

            for (Map.Entry<String, List<Integer>> entrys : dragons.entrySet()) {

                for (int j = 0; j < entrys.getValue().size(); j++) {
                    if (dragons.get(entrys.getKey()).get(j) == 2) {
                        dragons.get(entrys.getKey()).remove(j);
                        j--;
                        for (int k = 0; k < year.get(yearType); k++) {
                            String dragonName = entrys.getKey().toString() + "/Dragon_" + currDragon;
                            currDragon++;
                            dragons.put(dragonName, new ArrayList<>());
                            dragonsAge.put(dragonName, 0);
                        }
                    }
                }

            }

        }
        System.out.println(dragonsAge);
        System.out.println(dragons);
    }

    public static int ParentsCount(String str) {
        int count = str.length() - str.replace("_", "").length();
        return count + 1;
    }
}
