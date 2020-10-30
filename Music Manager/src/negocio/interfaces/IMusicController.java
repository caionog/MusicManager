package negocio.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import negocio.beans.Music; // Classes base
import negocio.beans.User;

import negocio.beans.Genre; // Enum

public interface IMusicController {
  
    public void extractMetaData(String path) throws Exception, IOException, SAXException, TikaException;

    public void resetRepo();
    
    public void populateMusicLibrary() throws IOException;

    public void deleteMusic(User loggedUser, Music selectedMusic) throws IOException;

    public void printMetadata(String path) throws Exception, IOException, SAXException, TikaException;

    public void printSummary(String path) throws Exception, IOException, SAXException, TikaException;

    public ArrayList<Music> getMusicLibrary();

    public Music getMusicById(int id);

    public ArrayList<Music> filterMusic(Genre genre, String title);
}
