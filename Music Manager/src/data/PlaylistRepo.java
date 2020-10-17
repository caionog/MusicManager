package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import negocio.Music;
import negocio.Playlist;
import negocio.User;

public class PlaylistRepo {
    private ArrayList<Playlist> playlistsLibrary = new ArrayList<Playlist>();

    public ArrayList<Playlist> getPlaylistsBank() {
        return playlistsLibrary;
    }

    // CRUD

    // Create Music no ArrayList
    // Adiciona Playlist no Arraylist e atualiza o .txt
    public void createPlaylist(ArrayList<Music> musics, User creator) {

        int id = playlistsLibrary.size()+1;
        Playlist p = new Playlist(id, musics, creator);

        playlistsLibrary.add(p);

        // TO-DO Código que adiciona no .txt mais uma playlist
    }

    // Read Playlist num .txt e coloca tds elas no arraylist MusicBanck
    public void readPlaylistLibrary() throws FileNotFoundException {
        FileReader reader = new FileReader("Music Manager\\src\\data\\txt storage\\repositorio de playlists.txt");

        // int character = reader.read();

        // String id = "";
        
 
        // while ( character != ' ' ) {
        //     id += character;
        //     System.out.print((char) character);
        //     character = reader.read();
        // }

        // System.out.print( "\n" + valueOff(id));
    }

    // Deletar Playlist no ArrayList e atualiza o .txt
    public Boolean deletePlaylist(Playlist p) {
        Boolean result =  playlistsLibrary.remove(p);

        if (result == true) {
            // Atualiza o .txt
        }

        return result;
    }

    // Funções auxiliares
    private Playlist searchPlaylist(int id) {
        Playlist p = null;
        
        for (Playlist playlist : playlistsLibrary) {
            if (playlist.getId() == id) {
                p = playlist;
            }
        }

        return p;
    }
}
