package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        List<String> artists=new ArrayList<>();
        List<String> songs=new ArrayList<>();


        while (!line.equals("end")){
            String[] tokens=line.split(":");
            String artist=tokens[0];
            String song=tokens[1];
            StringBuilder encryptedArtist=new StringBuilder();
            StringBuilder encryptedSong=new StringBuilder();
            if(isValid(artist) && isValid1(song)){
                encryptedArtist=encryptedMessage(artist,artist.length());
                encryptedSong=encryptedMessage(song,artist.length());
                System.out.println("Successful encryption: "+encryptedArtist+"@"+encryptedSong);
            } else {
                System.out.println("Invalid input!");
            }
            line=scanner.nextLine();
        }
    }

    private static StringBuilder encryptedMessage(String song, int key) {
        StringBuilder word=new StringBuilder();
        for (int i = 0; i <song.length(); i++) {
            if(song.charAt(i)==' ' || song.charAt(i)=='\''){
                word.append(song.charAt(i));
            } else {
                if(song.charAt(i)>=65 && song.charAt(i)<=90){
                    int symbol = (int) song.charAt(i) + key;
                    if (symbol > 90) {
                        int diff = symbol - 90;
                        symbol = 64 + diff;
                    }
                    char c = (char) symbol;
                    word.append(c);
                } else {
                    int symbol = (int) song.charAt(i) + key;
                    if (symbol > 122) {
                        int diff = symbol - 122;
                        symbol = 96 + diff;
                    }
                    char c = (char) symbol;
                    word.append(c);
                }
            }

        }
        return word;
    }

    private static boolean isValid1(String song) {
        boolean isValid=true;
        for (int i = 0; i <song.length() ; i++) {
            char symbol=song.charAt(i);
            if((symbol<65 || symbol>122) && symbol!=' '){
                isValid=false;
            }
        }
        return isValid;
    }

    private static boolean isValid(String artist) {
        boolean isValid=true;
        if(artist.charAt(0)<65 || artist.charAt(0)>90){
            isValid=false;
        }
        for (int i = 1; i <artist.length() ; i++) {
            char symbol=artist.charAt(i);
            if((symbol<97 || symbol>122) && (symbol!='\'' && symbol!=' ')){
                isValid=false;
            }
        }
        return isValid;
    }
}
