package gui.controller;

public class PlaylistFilter {

    private String creatorName = "";
    private String genreStr = "";
    

    public PlaylistFilter(String creatorName, String genreStr) {
        this.creatorName = creatorName;
        this.genreStr = genreStr;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getGenreStr() {
        return genreStr;
    }

    public void setGenreStr(String genreStr) {
        this.genreStr = genreStr;
    }

    
}
