import java.util.ArrayList;
import java.util.List;

public class RadioDatabase {

    private List<Song> playList;
    private int totalTime;

    public RadioDatabase() {
        this.playList = new ArrayList<>();
    }

    public void addSong(Song song) throws NoSuchFieldException, IllegalAccessException {
        this.playList.add(song);
//        Field fieldTimeSeconds = song.getClass().getDeclaredField("timeSeconds");
//        fieldTimeSeconds.setAccessible(true);
        totalTime += song.getTime(); //(int) fieldTimeSeconds.get(song);
        System.out.println("Song added.");
    }

    private List<Song> getPlayList() {
        return this.playList;
    }


    private int getTotalTime() {
        return totalTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int timeSeconds = this.getTotalTime();
        int hours = timeSeconds / 3600;
        timeSeconds %= 3600;
        int minutes = timeSeconds / 60;
        timeSeconds %= 60;
        int seconds = timeSeconds;
        sb.append(String.format("Songs added: %s%n", this.getPlayList().size()));
        sb.append(String.format("Playlist length: %sh %sm %ss", hours, minutes, seconds));
        return sb.toString();
    }

}
