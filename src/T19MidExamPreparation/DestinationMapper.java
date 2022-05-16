package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(\\=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1");
        String input = scan.nextLine();

        Matcher matcher = pattern.matcher(input);
        List<String> validDestinations = new ArrayList<>();

        while (matcher.find()){
            validDestinations.add(matcher.group("destination"));
        }
        int lengthSum = 0;

        for(int i = 0; i<validDestinations.size(); i++){
            int currentLength = validDestinations.get(i).length();
            lengthSum+=currentLength;
        }
        System.out.print("Destinations: ");
        for (int j = 0; j< validDestinations.size(); j++){
            if(j==validDestinations.size()-1){
                System.out.print(validDestinations.get(j));
                break;
            }
            System.out.print(validDestinations.get(j) + ", ");
        }
        System.out.println();

        System.out.print("Travel Points: " + lengthSum);
    }
}
