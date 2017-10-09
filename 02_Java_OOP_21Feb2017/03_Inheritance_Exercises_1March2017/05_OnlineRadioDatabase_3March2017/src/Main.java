import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        RadioDatabase radioDb = new RadioDatabase();


            for (int i = 0; i < n; i++) {
                try {
                    String[] inputTokens = reader.readLine().trim().split(";");
                    String artistName = inputTokens[0];
                    String songName = inputTokens[1];
                    String[] timeTokens = inputTokens[2].trim().split(":");
                    Song song = new Song(artistName, songName, timeTokens);
                    radioDb.addSong(song);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            System.out.println(radioDb);
    }
}



/*
Input 1:
3
ABBA;Mamma Mia;3:35
Nasko Mentata;Shopskata salata;4:123
Nasko Mentata;Shopskata salata;4:12

Expected output 1:
Song added.
Song seconds should be between 0 and 59.
Song added.
Songs added: 2
Playlist length: 0h 7m 47s


Input 2:
5
Nasko Mentata;Shopskata salata;14:59
Nasko Mentata;Shopskata salata;14:59
Nasko Mentata;Shopskata salata;14:59
Nasko Mentata;Shopskata salata;14:59
Nasko Mentata;Shopskata salata;0:5

Expected output 2:
Song added.
Song added.
Song added.
Song added.
Song added.
Songs added: 5
Playlist length: 1h 0m 1s


 */
