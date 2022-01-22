package x08_DataTypesAndVariables.lab;

import java.util.Scanner;

public class x11_RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Length: ");
        double length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        double wight = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        double height = Double.parseDouble(scanner.nextLine());

        double volume = (length * wight * height) / 3;
        System.out.printf("Pyramid Volume: %.2f", volume);
    }
}

