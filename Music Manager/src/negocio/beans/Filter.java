package negocio.beans;

public class Filter {

    private String title = "";
    private String artist = "";
    private String musicGenreStr = "";
    private String durationStr = "";

    private String creatorName = "";
    private String playlistGenreStr = "";


    public Filter(String title, String artist, String musicGenreStr, String durationStr) {
        this.title = title;
        this.artist = artist;
        this.musicGenreStr = musicGenreStr;
        this.durationStr = durationStr;
    }

    public Filter(String creatorName, String playlistGenreStr) {
        this.creatorName = creatorName;
        this.playlistGenreStr = playlistGenreStr;
    }

    public Filter() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDurationStr() {
        return durationStr;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public void setDurationStr(String durationStr) {
        this.durationStr = durationStr;
    }

    public String getMusicGenreStr() {
        return musicGenreStr;
    }

    public void setMusicGenreStr(String musicGenreStr) {
        this.musicGenreStr = musicGenreStr;
    }

    public String getPlaylistGenreStr() {
        return playlistGenreStr;
    }

    public void setPlaylistGenreStr(String playlistGenreStr) {
        this.playlistGenreStr = playlistGenreStr;
    }
    
}
