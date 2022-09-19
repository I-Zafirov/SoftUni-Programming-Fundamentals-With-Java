package T19MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class StringNumberComparator {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        List<String> seriesOfStrings = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());
        List<String> partArray = new ArrayList<>();
        String command = scan.nextLine();
        int counter = 0;

        while (!command.equals("end")) {
            if (seriesOfStrings.size() >= 1 && seriesOfStrings.size()<=50 && counter >=0 && counter <=20) {
                String[] tokens = command.split(" ");
                switch (tokens[0]) {
                    case "remove":
                        int end = (Integer.parseInt(tokens[1]) - 1);
                        if (end >= 0 && end < seriesOfStrings.size()) {
                            partArray = seriesOfStrings;
                            for (int i = end; i >= 0; i--) {
                                partArray.remove(i);
                            }
                        }
                        break;
                    case "reverse":
                        int start = Integer.parseInt(tokens[2]);
                        int count = Integer.parseInt(tokens[4]);
                        if (start >= 0 && start < seriesOfStrings
                                .size() && count + start >= 0 && count + start < seriesOfStrings.size()) {
//                            for (int i = start; i < start + count; i++) {
//                                partArray.add(seriesOfStrings.get(i));
//                            }
                            Collections.reverse(seriesOfStrings.subList(start,start+ count));
//                            Collections.reverse(partArray);
//                            for (int j = start; j < start + count; j++) {
//                                for (int i = 0; i < partArray.size(); i++) {
//                                    seriesOfStrings.set(j, partArray.get(i));
//                                    j++;
//                                }
//                            }
                        }
                        partArray.clear();
                        break;
                    case "sort":
                        int start1 = Integer.parseInt(tokens[2]);
                        int count1 = Integer.parseInt(tokens[4]);
//                        if (start1 >= 0 && start1 < seriesOfStrings.size() && start1 + count1 >= 0 && start1 + count1 < seriesOfStrings.size()) {
//                            for (int i = start1; i < start1 + count1; i++) {
//                                partArray.add(seriesOfStrings.get(i));
//                            }
                        //Collections.sort(partArray);
                        Collections.sort(seriesOfStrings.subList(start1,start1+ count1));
//                            for (int j = start1; j < start1 + count1; j++) {
//                                for (int i = 0; i < partArray.size(); i++) {
//                                    seriesOfStrings.set(j, partArray.get(i));
//                                    j++;
//                                }
//                            }
//                        }
                        partArray.clear();
                        break;
                }
            }


            command = scan.nextLine();
        }
        System.out.print(String.join(", ", seriesOfStrings));
    }
}
