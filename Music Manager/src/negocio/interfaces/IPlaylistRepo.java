package negocio.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
 
import negocio.beans.Music; // Classes base
import negocio.beans.Playlist;

import data.MusicRepo;


public interface IPlaylistRepo {
  
    public void createPlaylist(ArrayList<Music> musics, String creator) throws IOException;

    public ArrayList<String> readPlaylist(int playlistId) throws FileNotFoundException;

    public void updateDeletedMusics(int selectedMusicId) throws IOException;

    public void updateVisibility(String newVisibility, int playlistId) throws IOException;

    public void deletePlaylist(Playlist p);

    public void populatePlaylistLibrary(MusicRepo musicRepo) throws FileNotFoundException;

    public ArrayList<Playlist> getPlaylistsLibrary();
    
    //AQUI
  //	public ArrayList<Playlist> getPlaylistMusicLibrary();

    public Playlist getPlaylistByIndex(int index);

    public Playlist getPlaylistById(int id);

    public void resetRepo();

    public Playlist searchPlaylist(int id);
    
 
}
