package gui.controller;

public class MusicFilter {

    private String title = "";
    private String artist = "";
    private String genreStr = "";
    private String durationStr = "";


    public MusicFilter(String title, String artist, String genreStr, String durationStr) {
        this.title = title;
        this.artist = artist;
        this.genreStr = genreStr;
        this.durationStr = durationStr;
    }

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

    public String getGenreStr() {
        return genreStr;
    }

    public void setGenreStr(String genreStr) {
        this.genreStr = genreStr;
    }

    public String getDurationStr() {
        return durationStr;
    }

    public void setDurationStr(String durationStr) {
        this.durationStr = durationStr;
    }
    
}
