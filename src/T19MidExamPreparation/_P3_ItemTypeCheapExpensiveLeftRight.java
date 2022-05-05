package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class _P3_ItemTypeCheapExpensiveLeftRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] priceRatings = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int entryPoint = Integer.parseInt(scan.nextLine());
        String itemType = scan.nextLine();

        int leftSum = 0;
        int rightSum = 0;

        switch (itemType){
            case "cheap":
                for (int i = 0; i <= entryPoint - 1; i++) {
                    if(priceRatings[i] < priceRatings[entryPoint]){
                        leftSum += priceRatings[i];
                    }
                }
                for (int i = entryPoint + 1; i <= priceRatings.length - 1 ; i++) {
                    if(priceRatings[i] < priceRatings[entryPoint]){
                        rightSum+= priceRatings[i];
                    }
                }
                break;
            case "expensive":
                for (int i = 0; i <= entryPoint - 1 ; i++) {
                    if(priceRatings[i] >= priceRatings[entryPoint] ){
                        leftSum += priceRatings[i];
                    }
                }
                for (int i = entryPoint + 1; i <= priceRatings.length - 1 ; i++) {
                    if(priceRatings[i] >= priceRatings[entryPoint]){
                        rightSum += priceRatings[i];
                    }
                }
                break;
        }
        if(leftSum >= rightSum){
            System.out.printf("Left - %d",leftSum);
        }else{
            System.out.printf("Right - %d",rightSum);
        }
    }
}
