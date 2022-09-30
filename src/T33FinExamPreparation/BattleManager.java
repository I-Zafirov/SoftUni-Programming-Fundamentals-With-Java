package T33FinExamPreparation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> playerHealth = new HashMap<>();
        HashMap<String, Integer> playerEnergy = new HashMap<>();

        String expression;
        String[] command;

        while (!(expression = scanner.nextLine()).equals("Results")) {
            command = expression.split(":");

            switch (command[0]) {
                case "Add": {
                    playerHealth = addsHealth(playerHealth, command[1], Integer.parseInt(command[2]));
                    playerEnergy = addsEnergy(playerEnergy, command[1], Integer.parseInt(command[3]));
                    break;
                }
                case "Attack": {
                    if (playerHealth.containsKey(command[1]) && playerHealth.containsKey(command[2]) && playerEnergy.containsKey(command[1]) && playerEnergy.containsKey(command[2])) {
                        playerHealth = changesHealth(playerHealth, command[2], Integer.parseInt(command[3]));
                        playerEnergy = changesEnergy(playerEnergy, command[1]);
                    } else {
                        break;
                    }
                    if (playerHealth.get(command[2]) <= 0) {
                        playerHealth.remove(command[2]);
                        playerEnergy.remove(command[2]);
                        System.out.printf("%s was disqualified!%n", command[2]);
                    }
                    if (playerEnergy.get(command[1]) == 0) {
                        playerHealth.remove(command[1]);
                        playerEnergy.remove(command[1]);
                        System.out.printf("%s was disqualified!%n", command[1]);
                    }
                    break;
                }
                case "Delete": {
                    if (playerHealth.containsKey(command[1]) && playerEnergy.containsKey(command[1])) {
                        playerHealth.remove(command[1]);
                        playerEnergy.remove(command[1]);
                    } else if (command[1].equals("All")) {
                        playerHealth.clear();
                        playerEnergy.clear();
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
        System.out.println("People count: " + playerHealth.size());

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        playerHealth
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(pl -> {
                    result.put(pl.getKey(), pl.getValue());
                });
        for (Map.Entry<String, Integer> print : result.entrySet()) {
            System.out.printf("%s - %d - %d%n", print.getKey(), print.getValue(), playerEnergy.get(print.getKey()));
        }
//        HashMap<String, Integer> finalPlayerEnergy = playerEnergy;
//
//        playerHealth
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
//                .forEach(pl -> {
//                    System.out.printf("%s - %d - %d%n", pl.getKey(), pl.getValue(), finalPlayerEnergy.get(pl.getKey()));
//
//                });
    }

    public static HashMap<String, Integer> addsHealth(HashMap<String, Integer> playerHealth, String name, int health) {
        playerHealth.putIfAbsent(name, 0);
        playerHealth.put(name, playerHealth.get(name) + health);
        return playerHealth;
    }

    public static HashMap<String, Integer> addsEnergy(HashMap<String, Integer> playerEnergy, String name, int energy) {
        playerEnergy.putIfAbsent(name, energy);
        return playerEnergy;
    }

    public static HashMap<String, Integer> changesHealth(HashMap<String, Integer> playerHealth, String defender, int damage) {
        playerHealth.put(defender, playerHealth.get(defender) - damage);
        return playerHealth;
    }

    public static HashMap<String, Integer> changesEnergy(HashMap<String, Integer> playerEnergy, String attacker) {
        playerEnergy.put(attacker, playerEnergy.get(attacker) - 1);
        return playerEnergy;
    }
}



//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        HashMap<String, Integer> playersHealth = new HashMap<>();
//        HashMap<String, Integer> playersEnergy = new HashMap<>();
//
//        String expression = input.nextLine();
//
//        while (!expression.equals("Results")) {
//            String[] data = expression.split(":");
//            String command = data[0];
//
//            if (command.equals("Add")) {
//                String name = data[1];
//                int health = Integer.parseInt(data[2]);
//                int energy = Integer.parseInt(data[3]);
//
//                if (!playersHealth.containsKey(name) && !playersEnergy.containsKey(name)) {
//                    playersHealth.put(name, health);
//                    playersEnergy.put(name, energy);
//                }
//                else {
//                    playersHealth.put(name, playersHealth.get(name) + health);
//                }
//            }
//            else if (command.equals("Attack")) {
//                String attacker = data[1];
//                String defender = data[2];
//                int damage = Integer.parseInt(data[3]);
//
//                if (playersHealth.containsKey(attacker) && playersHealth.containsKey(defender)) {
//                    playersHealth.put(defender, playersHealth.get(defender) - damage);
//
//                    if (playersHealth.get(defender) <= 0) {
//                        playersHealth.remove(defender);
//                        playersEnergy.remove(defender);
//                        System.out.printf("%s was disqualified!%n", defender);
//                    }
//
//                    playersEnergy.put(attacker, playersEnergy.get(attacker) - 1);
//
//                    if (playersEnergy.get(attacker) == 0) {
//                        playersHealth.remove(attacker);
//                        playersEnergy.remove(attacker);
//                        System.out.printf("%s was disqualified!%n", attacker);
//                    }
//                }
//            }
//            else if (command.equals("Delete")) {
//                String user = data[1];
//
//                if (playersHealth.containsKey(user) && playersEnergy.containsKey(user)) {
//                    playersHealth.remove(user);
//                    playersEnergy.remove(user);
//                }
//                else if (user.equals("All")) {
//                    playersHealth.clear();
//                    playersEnergy.clear();
//                }
//            }
//
//            expression = input.nextLine();
//        }
//
//        System.out.println("People count: " + playersHealth.size());
//
//        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
//
//        playersHealth
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
//                .forEach(pl -> {
//                    result.put(pl.getKey(), pl.getValue());
//                });
//
//        for(Map.Entry<String, Integer> print : result.entrySet()){
//            System.out.printf("%s - %d - %d%n", print.getKey(), print.getValue(), playersEnergy.get(print.getKey()));
//        }
//    }