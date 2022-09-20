package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class TasksPlanner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] array= Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        while (true){
            String command=scanner.nextLine();
            if (command.equals("End")){
                break;
            }
            String[] line=command.split("\\s+");

            switch (line[0]){
                case "Complete":
                    int index=Integer.parseInt(line[1]);
                    if(index>=0&& index<array.length-1){
                        array[index]=0;
                    }

                    break;

                case "Change":
                    index=Integer.parseInt(line[1]);
                    int time=Integer.parseInt(line[2]);
                    if(index>=0&& index<array.length-1){
                        array[index]=time;
                    }
                    break;
                case "Drop":
                    index=Integer.parseInt(line[1]);

                    if(index>=0&& index<array.length-1){
                        array[index]=-1;
                    }
                    break;
                case "Count":
                    if (line[1].equals("Completed")){
                        int sum=0;
                        for (int i = 0; i <array.length ; i++) {
                            if(array[i]==0){
                                sum++;
                            }

                        }
                        System.out.println(sum);

                    }else if (line[1].equals("Incomplete")){
                        int sum=0;
                        for (int i = 0; i <array.length ; i++) {
                            if(array[i]>0){
                                sum++;
                            }

                        }
                        System.out.println(sum);

                    }else if (line[1].equals("Dropped")){
                        int sum=0;
                        for (int i = 0; i <array.length ; i++) {
                            if(array[i]==-1){
                                sum++;
                            }

                        }
                        System.out.println(sum);

                    }
                    break;

            }
            for (int i = 0; i <array.length ; i++) {

                System.out.print(array[i]+" ");


            }
            System.out.println();

        }
        for (int i = 0; i <array.length ; i++) {
            if(array[i]>0){
                System.out.print(array[i]+" ");
            }
        }
    }
}
