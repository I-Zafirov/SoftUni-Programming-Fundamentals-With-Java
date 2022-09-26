package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String infoAnimal = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[n][:](.+)[;][t][:](.+)[;][c][-][-](.+)");
            Pattern alfa = Pattern.compile("[A-Za-z ]");
            Pattern digit = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(infoAnimal);
            if (matcher.find()) {
                String nameFull = matcher.group(1);
                String name = "";
                Matcher matcherAlfa = alfa.matcher(nameFull);
                while (matcherAlfa.find()) {
                    name += matcherAlfa.group();
                }
                Matcher matcherDigit = digit.matcher(nameFull);
                while (matcherDigit.find()) {
                    sum += (int) (matcherDigit.group().charAt(0) - '0');
                }
                String animalFull = matcher.group(2);
                String animal = "";
                matcherAlfa = alfa.matcher(animalFull);
                while (matcherAlfa.find()) {
                    animal += matcherAlfa.group();
                }
                matcherDigit = digit.matcher(animalFull);
                while (matcherDigit.find()) {
                    sum += (int) (matcherDigit.group().charAt(0) - '0');
                }
                String stateFull = matcher.group(3);
                String country = "";
                matcherAlfa = alfa.matcher(stateFull);
                while (matcherAlfa.find()) {
                    country += matcherAlfa.group();
                }
                matcherDigit = digit.matcher(stateFull);
                while (matcherDigit.find()) {
                    sum += (int) (matcherDigit.group().charAt(0) - '0');
                }
                System.out.printf("%s is a %s from %s%n", name, animal, country);
            }
        }
        System.out.printf("Total weight of animals: %dKG%n", sum);

    }
}
