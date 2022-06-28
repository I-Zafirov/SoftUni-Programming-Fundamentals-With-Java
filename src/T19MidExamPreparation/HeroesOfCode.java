package T19MidExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> mapHp = new TreeMap<>();
        Map<String, Integer> mapManna = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] stats = scan.nextLine().split("\\s+");

            String name = stats[0];
            int hp = Integer.parseInt(stats[1]);
            int manna = Integer.parseInt(stats[2]);

            mapHp.putIfAbsent(name, 0);
            mapHp.put(name, mapHp.get(name) + hp);

            mapManna.putIfAbsent(name, 0);
            mapManna.put(name, mapManna.get(name) + manna);
        }

        String[] commands = scan.nextLine().split(" - ");
        while (!commands[0].equals("End")) {
            String name = commands[1];

            switch (commands[0]) {
                case "Heal":
                    int amountHp = Integer.parseInt(commands[2]);
                    int heal = mapHp.get(name);

                    if(heal + amountHp>100){
                        mapHp.put(name, 100);

                        System.out.printf("%s healed for %d HP!\n", name, (100 - (heal)));
                    }else {
                        mapHp.put(name, mapHp.get(name) + amountHp);

                        System.out.printf("%s healed for %d HP!\n", name, amountHp);
                    }
                    break;
                case "Recharge":
                    int amountManna = Integer.parseInt(commands[2]);
                    int manna = mapManna.get(name);

                    if(manna + amountManna>200){
                        mapManna.put(name, 200);

                        System.out.printf("%s recharged for %d MP!\n",name, (200 -(manna)));
                    }else {
                        mapManna.put(name, mapManna.get(name) + amountManna);
                        System.out.printf("%s recharged for %d MP!\n", name, amountManna);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commands[2]);
                    String attacker = commands[3];
                    int currentHp = mapHp.get(name);

                    mapHp.put(name, mapHp.get(name) - damage);
                    if (currentHp - damage <= 0) {
                        mapHp.remove(name);
                        mapManna.remove(name);

                        System.out.printf("%s has been killed by %s!\n", name, attacker);
                    } else {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", name, damage,
                                attacker, mapHp.get(name));
                    }
                    break;
                case "CastSpell":
                    int mannaNeeded = Integer.parseInt(commands[2]);
                    String spellName = commands[3];
                    int spellCast = mapManna.get(name);

                    if(spellCast >= mannaNeeded){
                        mapManna.put(name, mapManna.get(name) - mannaNeeded);

                        System.out.printf("%s has successfully cast %s and now has %d MP!\n",name, spellName,
                                mapManna.get(name));
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!\n", name, spellName);
                    }
                    break;
            }

            commands = scan.nextLine().split(" - ");
        }

        mapHp.entrySet().stream().
                sorted((a, b) -> b.getValue().compareTo(a.getValue())).
                forEach(e ->{
                    String name1 = e.getKey();
                    int name1Value = e.getValue();
                    int name2 = mapManna.get(name1);
                    System.out.println(name1);
                    System.out.printf(" HP: %d\n", name1Value);
                    System.out.printf(" MP: %d\n", name2);
                });
    }
}
