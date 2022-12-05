package T33FinExamPreparation;

import java.util.Scanner;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] tokens = line.split(":");
            String artist = tokens[0];
            String song = tokens[1];
            if (isValidArtist(artist) && isValidSong(song)) {
                int encryptionKey = artist.length() % ('z' - 'a' + 1);
                String encryptedArtist = encrypt(artist, encryptionKey);
                String encryptedSong = encrypt(song, encryptionKey);

                System.out.println("Successful encryption " + encryptedArtist + "@" + encryptedSong);
            } else {
                System.out.println("Invalid input!");
            }
            line = scanner.nextLine();
        }
    }

    private static String encrypt(String s, int encryptionKey) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char encryptedCh;
            if (ch != ' ' && ch != '\'') {
                encryptedCh = (char) (ch + encryptionKey);
                if (Character.isUpperCase(ch) && encryptedCh > 'Z') {
                    encryptedCh = (char) ('A' + (encryptedCh - 'Z' - 1));
                }
                if (Character.isUpperCase(ch) && encryptedCh > 'z') {
                    encryptedCh = (char) ('a' + (encryptedCh - 'z' - 1));
                }
            } else {
                encryptedCh = ch;
            }
            encrypted.append(encryptedCh);
        }
        return encrypted.toString();
    }

    private static boolean isValidArtist(String artist) {
        if (!Character.isUpperCase(artist.charAt(0))) {
            return false;
        }
        for (int i = 1; i < artist.length(); i++) {
            char ch = artist.charAt(i);
            boolean validChar = ('a' <= ch && ch <= 'z') || ch == '\'' || ch == ' ';
            if (!validChar) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidSong(String song) {

        for (int i = 1; i < song.length(); i++) {
            char ch = song.charAt(i);
            boolean validChar = ('A' <= ch && ch <= 'Z') || ch == ' ';
            if (!validChar) {
                return false;
            }
        }
        return true;
    }
}
