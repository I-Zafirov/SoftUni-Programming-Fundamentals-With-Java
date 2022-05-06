package T19MidExamPreparation;

import java.util.Scanner;

public class ArrayModfier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arrstring = a.split(" ");
        int[] arr = new int[arrstring.length];
        for (int l = 0; l < arrstring.length; l++) {
            arr[l] = Integer.parseInt(arrstring[l]);
        }

        while(true){
            String s = scanner.nextLine();
            if(s.equals("end")){
                break;
            }
            if(s.equals("decrease")){
                for(int i = 0; i<arr.length; i++){
                    arr[i]=arr[i]-1;
                }
            }
            else{
                String[]arrs=s.split(" ");
                if(arrs[0].equals("swap")){
                    int c=arr[Integer.parseInt(arrs[1])];
                    arr[Integer.parseInt(arrs[1])]=arr[Integer.parseInt(arrs[2])];
                    arr[Integer.parseInt(arrs[2])]=c;

                }
                if(arrs[0].equals("multiply")){
                    arr[Integer.parseInt(arrs[1])]=arr[Integer.parseInt(arrs[1])]*arr[Integer.parseInt(arrs[2])];
                }
            }
        }

        for(int n=0;n<arr.length;n++){
            if(n==arr.length-1){
                System.out.print(arr[n]);
            }
            else {
                System.out.print(arr[n] + ", ");
            }
        }
    }
}
