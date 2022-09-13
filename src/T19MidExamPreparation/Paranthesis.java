package T19MidExamPreparation;

import java.util.Scanner;

public class Paranthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean correct = true;
        int additional = 0;
        int removed = 0;
        int brotv=0;
        int brzatv=0;
        String a = scanner.nextLine();
        if(a.charAt(0)==')'){
            correct=false;
        }
        if(a.charAt(a.length()-1)=='('){
            correct=false;
        }
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==')'){
                brzatv++;
            }
            if(a.charAt(i)=='('){
                brotv++;
            }

        }
        if(brzatv!=brotv){
            correct=false;
        }
        int br=0;
        int br2=0;
        boolean bool=true;
//Helper.printResult(correct, removed, additional);
        for(int k=0;k<a.length();k++){


            if(a.charAt(k)=='('){
                br++;
                bool=false;
            }
            else  if(a.charAt(k)==')'){
                br2++;
            }
            if(br2>br){
                br2--;
                removed++;
            }

        }


        int br4=0;
        int br5=0;
        boolean bool2=true;
        for(int y=a.length()-1;y>=0;y--) {

            if (a.charAt(y) == ')') {
                br4++;

            } else if (a.charAt(y) == '(') {
                br5++;
            }

            if (br5 > br4) {
                additional++;
                br5--;
            }
        }


        System.out.println(correct);
        System.out.println(removed);

    }
}
