package T33FinExamPreparation;

import java.util.Scanner;

public class TranslateIncludesStartLowercaseFindIndexRemoveEnd {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        StringBuilder build= new StringBuilder();
        build.append(a);
        while(true){
            String line = scanner.nextLine();
            if(line.equals("End")){
                break;
            }
            String[] arr= line.split(" ");
            if(arr[0].equals("Translate")){
                a= a.replace(arr[1],arr[2]);
                build.replace(0,build.length(),"");
                build.append(a);
                System.out.println(a);
            }

            if(arr[0].equals("Includes")){
                boolean bool=a.contains(arr[1]);
                if(bool){
                    System.out.println("True");
                }
                else{
                    System.out.println("False");
                }
            }

            if(arr[0].equals("Start")){
                int index=a.indexOf(arr[1]);
                if(index==0){
                    System.out.println("True");
                }
                else{
                    System.out.println("False");
                }
            }

            if(arr[0].equals("Lowercase")){
                a=a.toLowerCase();
                build.replace(0,build.length(),"");
                build.append(a);
                System.out.println(a);
            }

            if(arr[0].equals("FindIndex")){
                int index=a.lastIndexOf(arr[1]);
                System.out.println(index);
            }
            if(arr[0].equals("Remove")){
                int start=Integer.parseInt(arr[1]);
                int count=Integer.parseInt(arr[2]);
                build.replace(start,start+count,"");
                a=build.toString();
                System.out.println(a);
            }

        }
    }
}
