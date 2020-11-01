package negocio.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import negocio.beans.Music; // Classes base

import negocio.beans.Genre; // Enum

public interface IMusicRepo {
  
    public void createMusic(String title, String artist, Genre genre, String duration) throws IOException, FileNotFoundException;

    public ArrayList<String> readMusic(int musicId) throws FileNotFoundException;

    public void deleteMusic(Music m);

    public void populateMusicLibrary() throws IOException;

    public ArrayList<Music> getMusicLibrary();

    public Music getMusicByIndex(int index);

    public Music getMusicById(int id);

    public void resetRepo();

    public Music searchMusic(int id);
}
