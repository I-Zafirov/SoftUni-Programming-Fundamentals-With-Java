package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasList2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<String> santaList= Arrays.stream(scanner.nextLine()
                        .split("&"))
                .collect(Collectors.toList());

        String line=scanner.nextLine();

        while (!line.equals("Finished!")) {
            String[] commands=line.split(" ");

            if(commands[0].equals("Bad")){
                if(!santaList.contains(commands[1])){
                    santaList.add(0,commands[1]);
                }
            }
            if(commands[0].equals("Good")){
                if(santaList.contains(commands[1])){
                    santaList.remove(commands[1]);
                }
            }
            if(commands[0].equals("Rename")){
                String oldName=commands[1];
                String newName=commands[2];
                if(santaList.contains(oldName)){
                    int index=santaList.indexOf(oldName);
                    santaList.set(index,newName);
                }
            }
            if(commands[0].equals("Rearrange")){
                if(santaList.contains(commands[1])){
                    int index=santaList.indexOf(commands[1]);
                    santaList.remove(index);
                    santaList.add(commands[1]);
                }
            }
            line=scanner.nextLine();
        }

        for (int i = 0; i <santaList.size()-1 ; i++) {
            System.out.print(santaList.get(i)+", ");
        }
        System.out.print(santaList.get(santaList.size()-1));
    }
}
