package T19MidExamPreparation;

import java.util.Scanner;

public class _P1_MoreNeededItemsPurchasedFor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double priceForFlourPerPackage = Double.parseDouble(scan.nextLine());
        double pricePerSingleEgg = Double.parseDouble(scan.nextLine());
        double pricePerSingleApron = Double.parseDouble(scan.nextLine());
        int packagesFlourCount = 0;
        int freePackagesCount = 0;

        for (int i = 0; i < students; i++) {
            packagesFlourCount++;
            if(packagesFlourCount % 5 == 0){
                freePackagesCount++;
            }
        }
        double eggsPrice = pricePerSingleEgg * 10 * students;
        double flourPrice = priceForFlourPerPackage * (students - freePackagesCount);

        double studentsMore = Math.ceil(students * 0.20 + students);
        //double totalPrice = apronPrice + eggsPrice + flourPrice;
        double apronPrice = pricePerSingleApron * studentsMore;
        double totalPrice = apronPrice + eggsPrice + flourPrice;

        if(totalPrice <= budget){
            System.out.printf("Items purchased for %.2f$.",totalPrice);
        }else {
            System.out.printf("%.2f$ more needed.", totalPrice - budget);
        }
    }
}
