package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> mainMaterials = new TreeMap<>();
        TreeMap<String, Integer> otherMaterials = new TreeMap<>();
        mainMaterials.put("shards", 0);
        mainMaterials.put("fragments", 0);
        mainMaterials.put("motes", 0);

        Pattern myPatt = Pattern.compile("([0-9]+)[ ]([\\w\\S]+)");
        boolean obtained = false;
        while (!obtained){
            String input = sc.nextLine();
            Matcher matcher = myPatt.matcher(input);
            while (matcher.find()){
                int amount = Integer.parseInt(matcher.group(1));
                String material = matcher.group(2).toLowerCase();

                if (mainMaterials.containsKey(material)){
                    mainMaterials.put(material, mainMaterials.get(material) + amount);
                    if (mainMaterials.get(material) >= 250){
                        obtained = true;
                        mainMaterials.put(material, mainMaterials.get(material) - 250);
                        if (material.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                        }else if (material.equals("fragments")){
                            System.out.println("Valanyr obtained!");
                        }else{
                            System.out.println("Dragonwrath obtained!");
                        }
                    }
                }else {
                    if (!otherMaterials.containsKey(material)){
                        otherMaterials.put(material, 0);
                    }
                    otherMaterials.put(material,otherMaterials.get(material) + amount);
                }
                if (obtained){
                    break;
                }
            }
        }


        mainMaterials.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue())).forEach(s -> {
            System.out.println(s.getKey() + ": " + s.getValue());
        });
        for (Map.Entry<String, Integer> stringIntegerEntry : otherMaterials.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + ": " + stringIntegerEntry.getValue());
        }
    }
}
