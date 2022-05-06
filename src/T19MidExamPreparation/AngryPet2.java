package T19MidExamPreparation;

import java.util.Scanner;

public class AngryPet2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arrstring = a.split(" ");
        int[] arr = new int[arrstring.length];
        for (int l = 0; l < arrstring.length; l++) {
            arr[l] = Integer.parseInt(arrstring[l]);
        }
        int entry = Integer.parseInt(scanner.nextLine());
        String skupoilievtino = scanner.nextLine();
        String polojitelnoiliotricatelno = scanner.nextLine();
        int left = 0;
        int right = 0;
        for (int i = 0; i < entry; i++) {
            if (skupoilievtino.equals("cheap")) {
                if (polojitelnoiliotricatelno.equals("positive")) {
                    if (arr[i] > 0 && arr[i] < arr[entry]) {
                        left += arr[i];
                    }
                }
            }

            if (skupoilievtino.equals("cheap")) {
                if (polojitelnoiliotricatelno.equals("negative")) {
                    if (arr[i] < 0 && arr[i] < arr[entry]) {
                        left += arr[i];
                    }
                }
            }

            if (skupoilievtino.equals("cheap")) {
                if (polojitelnoiliotricatelno.equals("all")) {
                    if (arr[i] < arr[entry]) {
                        left += arr[i];
                    }
                }
            }

            if (skupoilievtino.equals("expensive")) {
                if (polojitelnoiliotricatelno.equals("positive")) {
                    if (arr[i] > 0 && arr[i] >= arr[entry]) {
                        left += arr[i];
                    }
                }
            }

            if (skupoilievtino.equals("expensive")) {
                if (polojitelnoiliotricatelno.equals("negative")) {
                    if (arr[i] < 0 && arr[i] >= arr[entry]) {
                        left += arr[i];
                    }
                }
            }

            if (skupoilievtino.equals("expensive")) {
                if (polojitelnoiliotricatelno.equals("all")) {
                    if (arr[i] >= arr[entry]) {
                        left += arr[i];
                    }
                }
            }

        }




        for (int i = entry; i < arr.length; i++) {
            if (skupoilievtino.equals("cheap")) {
                if (polojitelnoiliotricatelno.equals("positive")) {
                    if (arr[i] > 0 && arr[i] < arr[entry]) {
                        right += arr[i];
                    }
                }
            }

            if (skupoilievtino.equals("cheap")) {
                if (polojitelnoiliotricatelno.equals("negative")) {
                    if (arr[i] < 0 && arr[i] < arr[entry]) {
                        right += arr[i];
                    }
                }
            }

            if (skupoilievtino.equals("cheap")) {
                if (polojitelnoiliotricatelno.equals("all")) {
                    if (arr[i] < arr[entry]) {
                        right += arr[i];
                    }
                }
            }

            if (skupoilievtino.equals("expensive")) {
                if (polojitelnoiliotricatelno.equals("positive")) {
                    if (arr[i] > 0 && arr[i] >= arr[entry]) {
                        right += arr[i];
                    }
                }
            }

            if (skupoilievtino.equals("expensive")) {
                if (polojitelnoiliotricatelno.equals("negative")) {
                    if (arr[i] < 0 && arr[i] >= arr[entry]) {
                        right += arr[i];
                    }
                }
            }

            if (skupoilievtino.equals("expensive")) {
                if (polojitelnoiliotricatelno.equals("all")) {
                    if (arr[i] >= arr[entry]) {
                        right += arr[i];
                    }
                }
            }

        }
        if(right>left){
            System.out.printf("Right - %d",right);
        }
        else{
            System.out.printf("Left - %d",left);
        }
    }
}
