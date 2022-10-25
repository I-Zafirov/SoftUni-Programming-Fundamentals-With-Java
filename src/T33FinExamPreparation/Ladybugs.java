package T33FinExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ladybugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int[] fields = new int[number];

        List<Integer> indexesOfLadybugs = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        for (int z = 0; z < indexesOfLadybugs.size(); z++) {
            if (indexesOfLadybugs.get(z) >= 0 && indexesOfLadybugs.get(z) < fields.length) {
                fields[indexesOfLadybugs.get(z)] = 1;
            }
        }
        String expression = scanner.nextLine();
        String[] commands;
        int currentPosition;
        while (!expression.equals("end")) {
            commands = expression.split("\\s+");
            int position = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int flight = Integer.parseInt(commands[2]);

            if (position < 0 || position >= fields.length || fields[position] == 0) {
                expression = scanner.nextLine();
                continue;
            }
            currentPosition = position;
            fields[position] = 0;
            if (direction.equals("right")) {
                while (currentPosition >= 0 && currentPosition < fields.length) {
                    currentPosition = currentPosition + flight;
                    if (currentPosition >= 0 && currentPosition < fields.length && fields[currentPosition] == 0) {
                        fields[currentPosition] = 1;
                        break;
                    } else if (currentPosition >= 0 && currentPosition < fields.length && fields[currentPosition] == 1) {
                        continue;
                    }
                }
            } else if (direction.equals("left")) {
                while (currentPosition >= 0 && currentPosition < fields.length) {
                    currentPosition = currentPosition - flight;
                    if (currentPosition >= 0 && currentPosition < fields.length && fields[currentPosition] == 0) {
                        fields[currentPosition] = 1;
                        break;
                    } else if (currentPosition >= 0 && currentPosition < fields.length && fields[currentPosition] == 1) {
                        continue;
                    }
                }
            }
            expression = scanner.nextLine();
        }
        for (int num : fields) {
            System.out.printf("%d ", num);
        }
    }
}


//Проблем: бях написал 'fields[position] == 0 || position < 0 || position >= fields.length'
//условието fields[position] == 0 трябва да бъде след другите две условия

//Exam Preparation II

//Tests:

//3
//0 1 2
//0 right 1
//1 right 1
//2 right 1
//end

//0 0 0

//5
//3
//3 left 2
//1 left -2
//end

//0 0 0 1 0

//3
//0
//0 right 1
//0 right 7
//end

//0 1 0

//3
//0
//0 right 1
//1 right 0
//end

//0 1 0


//100/100

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        int number = Integer.parseInt(input.nextLine());
//        int[] fields = new int[number];
//
//        List<Integer> indexesOfLadybugs = Arrays.stream(input.nextLine().split("\\s+")).map(e -> Integer.parseInt(e)).collect(Collectors.toList());
//
//        for(int z = 0; z < indexesOfLadybugs.size(); z++){
//            if(indexesOfLadybugs.get(z) >= 0 && indexesOfLadybugs.get(z) < fields.length){
//                fields[indexesOfLadybugs.get(z)] = 1;
//            }
//        }
//
//        String expression = input.nextLine();
//        String[] commands;
//        int currentPosition;
//
//        while(!expression.equals("end")){
//            commands = expression.split("\\s+");
//            int position = Integer.parseInt(commands[0]);
//            String direction = commands[1];
//            int flight = Integer.parseInt(commands[2]);
//
//            if(position < 0 || position >= fields.length || fields[position] == 0){
//                expression = input.nextLine();
//                continue;
//            }
//
//            switch (direction){
//                case "right":{
//                    currentPosition = position;
//                    fields[position] = 0;
//
//                    while (currentPosition >= 0 && currentPosition < fields.length){
//                        currentPosition = currentPosition + flight;
//
//                        if(currentPosition >= 0 && currentPosition < fields.length && fields[currentPosition] == 0){
//                            fields[currentPosition] = 1;
//                            break;
//                        }
//                        else if(currentPosition >= 0 && currentPosition < fields.length && fields[currentPosition] == 1){
//                            continue;
//                        }
//                    }
//
//                    break;
//                }
//                case "left":{
//                    currentPosition = position;
//                    fields[position] = 0;
//
//                    while (currentPosition >= 0 && currentPosition < fields.length){
//                        currentPosition = currentPosition - flight;
//
//                        if(currentPosition >= 0 && currentPosition < fields.length && fields[currentPosition] == 0){
//                            fields[currentPosition] = 1;
//                            break;
//                        }
//                        else if(currentPosition >= 0 && currentPosition < fields.length && fields[currentPosition] == 1){
//                            continue;
//                        }
//                    }
//
//                    break;
//                }
//                default: break;
//            }
//
//            expression = input.nextLine();
//        }
//
//        for(int num : fields){
//            System.out.printf("%d ", num);
//        }
//    }

