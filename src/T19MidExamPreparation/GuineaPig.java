package T19MidExamPreparation;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double food = Double.parseDouble(scanner.nextLine());;
        double hey = Double.parseDouble(scanner.nextLine());
        double cover = Double.parseDouble(scanner.nextLine());
        double guineaPigWeight = Double.parseDouble(scanner.nextLine());
        boolean isFoodEnough = true;

        for (int day = 1; day <= 30; day++) {
            food -= 0.3;
            if (Math.floor(food*1000) <= 0) {
                isFoodEnough = false;
                break;
            }
            if (day % 2 == 0) {
                hey -= 0.05 * food;
                if (Math.floor(hey * 1000 ) <= 0) {
                    isFoodEnough = false;
                    break;
                }
            }
            if (day % 3 == 0) {
                cover -= guineaPigWeight / 3;
                if (Math.floor(cover * 1000) <= 0) {
                    isFoodEnough = false;
                    break;
                }
            }
        }

        if (isFoodEnough) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.02f, Hay: %.02f, Cover: %.02f.", food, hey, cover);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}
