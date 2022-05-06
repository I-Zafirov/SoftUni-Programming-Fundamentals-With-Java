package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class AngryCar {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[] list = Arrays.stream(inp.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int point = Integer.parseInt( inp.nextLine());
        String  command =inp.nextLine();

        int[] left = new int[point];
        int[] right=  new int[list.length - point-1];

        for( int i =0; i<list.length; i++){
            if( i<point){
                left[i]=list[i];
            }else if( i>point){
                right[i-(point+1)]=list[i];
            }else{
                continue;
            }
        }
        int sumleft = 0;
        int sumRight = 0;
        switch (command) {
            case "cheap":
                for( int i =0; i<left.length; i++){
                    if(left[i]<list[point]){
                        sumleft+=left[i];
                    }
                }
                for( int i =0; i<right.length; i++){
                    if(right[i]<list[point]){
                        sumRight+=right[i];
                    }
                }
                break;
            case "expensive":
                for( int i =0; i<left.length; i++){
                    if(left[i]>=list[point]){
                        sumleft+=left[i];
                    }
                }
                for( int i =0; i<right.length; i++){
                    if(right[i]>=list[point]){
                        sumRight+=left[i];
                    }
                }
                break;
        }
        if( sumleft >= sumRight){
            System.out.print("Left - " + sumleft);
        }else{
            System.out.print("Right - " + sumRight);
        }
    }
}
