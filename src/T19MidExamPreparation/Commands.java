package T19MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Commands {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list  =
                Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<Integer> bounds = new ArrayList<>();
        List<Integer> reverse = reverseList(bounds);

        String[] command = scan.nextLine().split(" ");


        while (!command[0].equals("end")){

            switch (command[0]){
                case "reverse":
                    int start = Integer.parseInt(command[2]);
                    int count = Integer.parseInt(command[4]);
                    for(int i = start; i<list.size(); i++){
                        if(i==count){
                            break;
                        }else{
                            bounds.add(list.get(i));
                        }
                    }
                    for(int i = 0; i<reverse.size(); i++){
                        list.add(start, reverse.get(i));
                    }

                case "sort":

                    break;
                case "remove":

            }
            command = scan.nextLine().split(" ");

        }
    }
    public static<T> List<T> reverseList(List<T> list)
    {
        return list.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(ArrayList::new), lst -> {
                            Collections.reverse(lst);
                            return lst.stream();
                        }
                )).collect(Collectors.toCollection(ArrayList::new));
    }
}
