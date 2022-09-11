package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberArray2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line=scanner.nextLine();

        while (!line.equals("End")){
            String[] commands=line.split(" ");
            String command=commands[0];

            if(command.equals("Switch")){
                int index=Integer.parseInt(commands[1]);
                if(index>=0 && index<numbers.size()){
                    int number=numbers.get(index);
                    numbers.set(index,-number);
                }
            } else if(command.equals("Change")){
                int index=Integer.parseInt(commands[1]);
                int number=Integer.parseInt(commands[2]);
                if(index>=0 && index<numbers.size()){
                    numbers.set(index,number);
                }
            } else if(command.equals("Sum")){
                String sign=commands[1];
                if(sign.equals("Negative")){
                    int sum=0;
                    for(int i=0;i<numbers.size();i++){
                        if(numbers.get(i)<0){
                            sum+=numbers.get(i);
                        }
                    }
                    System.out.println(sum);
                }
                if(sign.equals("Positive")){
                    int sum=0;
                    for(int i=0;i<numbers.size();i++){
                        if(numbers.get(i)>=0){
                            sum+=numbers.get(i);
                        }
                    }
                    System.out.println(sum);
                }
                if(sign.equals("All")){
                    int sum=0;
                    for (int i = 0; i <numbers.size() ; i++) {
                        sum+=numbers.get(i);
                    }
                    System.out.println(sum);
                }
            }

            line=scanner.nextLine();
        }

        for(Integer number : numbers){
            if(number>=0) {
                System.out.print(number+" ");
            }
        }
    }
}
