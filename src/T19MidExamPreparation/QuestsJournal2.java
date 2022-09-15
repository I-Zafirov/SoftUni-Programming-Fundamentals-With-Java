package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestsJournal2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<String> journals= Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());

        String line=scanner.nextLine();

        while(!line.equals("Retire!")){
            String[] quests=line.split(" \\- ");

            if(quests[0].equals("Start")){
                if(!journals.contains(quests[1])){
                    journals.add(quests[1]);
                }
            } else if(quests[0].equals("Complete")){
                if(journals.contains(quests[1])){
                    journals.remove(quests[1]);
                }
            } else if(quests[0].equals("Side Quest")){
                String str=quests[1];
                String[] insideQuests=str.split(":");

                if(journals.contains(insideQuests[0])){
                    int index=journals.indexOf(insideQuests[0]);
                    if(!journals.contains(insideQuests[1])){
                        journals.add(index+1,insideQuests[1]);
                    }
                }

            } else {
                if(journals.contains(quests[1])){
                    int index=journals.indexOf(quests[1]);
                    journals.remove(index);
                    journals.add(quests[1]);
                }
            }

            line=scanner.nextLine();

        }

        for (int i = 0; i <journals.size()-1 ; i++) {
            System.out.print(journals.get(i)+", ");
        }
        System.out.print(journals.get(journals.size()-1));
    }
}
