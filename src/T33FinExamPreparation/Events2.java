package T33FinExamPreparation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events2 {
    static TreeMap<String,TreeMap<String, TreeSet<String>>> eventData = new TreeMap<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String regex = "^#([a-zA-Z]+):\\s*@([a-zA-Z]+)\\s*(([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]))$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            Matcher matcher = pattern.matcher(sc.nextLine());
            if(matcher.find()){
                String person = matcher.group(1);
                String city = matcher.group(2);
                String hour = matcher.group(3);

                if(!eventData.containsKey(city)){
                    eventData.put(city,new TreeMap<String, TreeSet<String>>());
                }
                if(!eventData.get(city).containsKey(person)){
                    eventData.get(city).put(person,new TreeSet<String>());
                }
                eventData.get(city).get(person).add(hour);
            }
        }

        String[] citiesToPrint = sc.nextLine().split(",");
        Arrays.sort(citiesToPrint);

        for(String city : citiesToPrint){
            if(eventData.containsKey(city)){
                System.out.println(city+":");
                int count = 1;
                for(String person : eventData.get(city).keySet()){
                    // Arrays.sort(eventData.get(city).get(person));
                    String hours = eventData.get(city).get(person).toString().replace('[','\0').replace(']','\0');
                    System.out.printf("%d. %s -> %s\n",count++,person,hours);
                }
            }
        }

    }
}
