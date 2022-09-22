package T19MidExamPreparation;

import java.util.Scanner;

public class TribonacciSequence {
    static int printTribRec(int n)
    {

        if (n == 0 || n == 1 || n == 2)
            return 0;

        if (n == 3)
            return 1;
        else
            return printTribRec(n - 1) +
                    printTribRec(n - 2) +
                    printTribRec(n - 3);
    }

    static void printTrib(int n)
    {
        for (int i = 1; i < n; i++)
            System.out.print(printTribRec(i)
                    +" ");
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        printTrib(n);
    }
}
