package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CookingFactory2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> bestList=new ArrayList<>();
        int bestsum=Integer.MIN_VALUE;
        double bestAvr=-100;
        int bestlent=0;
        while(true){
            String line=scanner.nextLine();
            if(line.equals("Bake It!")){
                break;
            }
            String[] batch=line.split("#");
            int[] bint=new int[batch.length];
            for (int i = 0; i <batch.length ; i++) {
                bint[i]=Integer.parseInt(batch[i]);
            }
            int sum=0;

            for (int i = 0; i <bint.length; i++) {
                sum+=bint[i];
            }
            Double avr=(sum*1.0)/bint.length;
            int lenght=bint.length;
            boolean change=false;
            if(sum>bestsum){
                change=true;
            }else if(sum==bestsum){
                if(avr>bestAvr){
                    change=true;
                }else if(avr==bestAvr){
                    if(lenght<bestList.size() ){
                        change=true;
                    }
                }
            }
            if (change){
                bestsum=sum;
                bestlent=lenght;
                bestAvr=avr;
                bestList.clear();
                for (int i = 0; i <lenght ; i++) {
                    bestList.add(bint[i]);
                }

            }
        }
        System.out.printf("Best Batch quality: %d",bestsum);
        System.out.println();

        for (int i = 0; i <bestList.size() ; i++) {
            System.out.print(bestList.get(i)+" ");

        }
        System.out.println();
    }
}
