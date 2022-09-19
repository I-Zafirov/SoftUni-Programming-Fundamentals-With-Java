package T19MidExamPreparation;

import java.util.Scanner;

public class StringParticles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String arrayAsString = scan.nextLine();

        String[] particles = arrayAsString.split("\\|");

        String input = scan.nextLine();

        while (!input.equals("Done")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Move":
                    int index = Integer.parseInt(tokens[2]);
                    if(tokens[1].equals("Left")){
                        if(isValid(index, particles.length)){
                            if(!particles[index].equals(particles[0])){
                                String temp = particles[index];
                                particles[index] = particles[index - 1];
                                particles[index - 1] = temp;
                            }
                        }
                    }else if(tokens[1].equals("Right")){
                        if(isValid(index, particles.length)){
                            if(!particles[index].equals(particles[particles.length - 1])){
                                String temp = particles[index];
                                particles[index] = particles[index + 1];
                                particles[index + 1] = temp;
                            }
                        }
                    }
                    break;
                case "Check":
                    if(tokens[1].equals("Even")){
                        for (int i = 0; i < particles.length; i++) {
                            if(i % 2 == 0){
                                System.out.print(particles[i] + " ");
                            }
                        }

                    }else if(tokens[1].equals("Odd")){
                        for (int i = 0; i < particles.length; i++) {
                            if(i % 2 == 1){
                                System.out.print(particles[i] + " ");
                            }
                        }
                    }
                    break;

            }


            input = scan.nextLine();
        }
        String weapon = String.join("", particles);
        System.out.printf("You crafted %s!",weapon);

    }

    private static boolean isValid(int index, int length) {
        return index >= 0 && index <= length - 1;
    }
}
