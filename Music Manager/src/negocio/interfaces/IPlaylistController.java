package negocio.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import negocio.User; // Classes base
import negocio.Music;
import negocio.Playlist;

import negocio.Genre; // Enum

public interface IPlaylistController {
  
    public void groupSelectedMusic(ArrayList<Music> selected, User creator) throws IOException;

    public void resetRepo();

    public void populatePlaylistLibrary() throws FileNotFoundException;

    public void togglePlaylistVisibility(Playlist p) throws IOException;

    public void editPlaylist(Music selectedMusic);

    public void deletePlaylist();

    public ArrayList<Playlist> getPlaylistsLibrary();

    public Playlist getPlaylistByIndex(int index);

    public ArrayList<Playlist> filterPlaylist(Genre genre, String title);
}
