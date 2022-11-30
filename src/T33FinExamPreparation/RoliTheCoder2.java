package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoliTheCoder2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> idEventChecker = new HashMap<>();
        TreeMap<String, Integer> eventCountMembers = new TreeMap<>();
        TreeMap<String, ArrayList<String>> eventMembers = new TreeMap<>();


        String input = reader.readLine();

        while (!input.equals("Time for Code")) {
            UpdateAllMaps(idEventChecker, eventCountMembers, eventMembers, input);

            input = reader.readLine();
        }

        PrintResult(eventCountMembers, eventMembers);
    }

    private static void PrintResult(TreeMap<String, Integer> eventCountMembers, TreeMap<String, ArrayList<String>> eventMembers) {
        eventCountMembers.entrySet().stream().sorted((x1, x2) -> x2.getValue().compareTo(x1.getValue())).forEach(x -> {
            System.out.println(x.getKey() + " - " + x.getValue());

            Collections.sort(eventMembers.get(x.getKey()), String.CASE_INSENSITIVE_ORDER);
            for (String member : eventMembers.get(x.getKey())) {
                System.out.println(member);
            }
        });
    }

    private static void UpdateAllMaps(HashMap<String, String> idEventChecker, TreeMap<String, Integer> eventCountMembers, TreeMap<String, ArrayList<String>> eventMembers, String input) {
        String[] inputArr = input.split("\\s+");
        String id = inputArr[0];
        String eventName = inputArr[1];

        // If she is given event in an invalid format (such as without a hashtag), she ignores that line of input
        if (eventName.length() > 1 && eventName.charAt(0) == '#') {
            eventName = eventName.substring(1, eventName.length());
            ArrayList<String> membersList = new ArrayList<>();
            AddMembersList(inputArr, membersList);

            if (!idEventChecker.containsKey(id)) {
                idEventChecker.put(id, eventName);

                eventCountMembers.put(eventName, membersList.size());

                eventMembers.put(eventName, new ArrayList<>());
                eventMembers.get(eventName).addAll(membersList);
            } else {
                /* If she is given ID that already exists she needs to check if the eventName is the same.
                If it is, she adds the participants from the request to the other registered participants.
                If the event id exists but the name doesn’t, it is invalid and you need to ignore it. */
                if (idEventChecker.get(id).equals(eventName)) {
                    UpdateMembersList(eventMembers.get(eventName), membersList);

                    int counter = eventCountMembers.get(eventName) + membersList.size();
                    eventCountMembers.replace(eventName, counter);

                    eventMembers.get(eventName).addAll(membersList);
                }
            }

        }
    }

    private static void UpdateMembersList(ArrayList<String> originalMembersList, ArrayList<String> newMembersList) {
        ArrayList<String> newMembers = new ArrayList<>();
        for (String name : newMembersList) {
            if (!originalMembersList.contains(name)) {
                newMembers.add(name);
            }
        }
        newMembersList.clear();
        newMembersList.addAll(newMembers);
    }

    private static void AddMembersList(String[] inputArr, ArrayList<String> membersList) {
        Pattern pattern = Pattern.compile("(@\\b[A-Za-z0-9'-]+)\\b");
        for (String str : inputArr) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find() && matcher.group().length() == str.length()) {
                membersList.add(str);
            }
        }
    }
}
