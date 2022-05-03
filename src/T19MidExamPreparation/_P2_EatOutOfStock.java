package T19MidExamPreparation;

import java.util.Scanner;

public class _P2_EatOutOfStock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] cookies = scan.nextLine().split(", ");
        String command = scan.nextLine();
        while (!command.equals("Eat")) {
            String[] commandArr = command.split(" ");
            switch (commandArr[0]) {
                case "Update-Any":
                    cookies = updateAny(cookies, commandArr[1]);
                    break;
                case "Remove":
                    cookies = remove(cookies, commandArr[1], Integer.parseInt(commandArr[2]));
                    break;
                case "Update-Last":
                    cookies = updateLast(cookies, commandArr[1]);
                    break;
                case "Rearrange":
                    cookies = rearrange(cookies, commandArr[1]);
                    break;
            }
            command = scan.nextLine();
        }
        scan.close();

        printCookies(cookies);

    }

    private static void printCookies(String[] cookies) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].equals("Out of stock")) {
                continue;
            }else {
                System.out.print(cookies[i]);
                if (i < (cookies.length - 1)) {
                    System.out.print(" ");
                }
            }

        }

    }

    private static String[] rearrange(String[] cookies, String biscuit) {
        boolean found = false;
        for (int i = 0; i < (cookies.length - 1); i++) {
            if (cookies[i].equals(biscuit)) {
                found = true;
            }
            if (found) {
                cookies[i] = cookies[i + 1];
            }
        }
        if (found) {
            cookies[cookies.length - 1] = biscuit;
        }
        return cookies;
    }

    private static String[] updateLast(String[] cookies, String biscuit) {
        cookies[cookies.length - 1] = biscuit;
        return cookies;
    }

    private static String[] remove(String[] cookies, String biscuit, int index) {
        if ((0 <= index) && (index < cookies.length)) {
            cookies[index] = biscuit;
        }
        return cookies;
    }

    private static String[] updateAny(String[] cookies, String biscuit) {
        for (int i = 0; i < cookies.length; i++) {
            if (biscuit.equals(cookies[i])) {
                cookies[i] = "Out of stock";
            }
        }
        return cookies;
    }

}
