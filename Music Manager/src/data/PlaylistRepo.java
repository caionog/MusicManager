package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import negocio.Playlist;

public class PlaylistRepo {
    private ArrayList<Playlist> playlistsBank = new ArrayList<Playlist>();

    // CRD (o U é Update/Editar, e editar música não faz sentido)

    // Create Music no ArrayList
    public void createPlaylist() {
        // Código que adiciona no .txt mais uma playlist
    }

    // Read Playlist num .txt e coloca tds elas no arraylist MusicBanck
    public void readPlaylistBanck() throws FileNotFoundException {
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

    // Adiciona Playlist no Arraylist e atualiza o .txt
    public boolean addPlaylist(Playlist p) { 
        p.setId(playlistsBank.size()+1);

        Boolean result =  playlistsBank.add(p);

        if (result) {
            // Atualiza o .txt
        }

        return result;
    }

    // Deletar Playlist no ArrayList e atualiza o .txt
    public Boolean deletePlaylist(Playlist p) {
        Boolean result =  playlistsBank.remove(p);

        if (result == true) {
            // Atualiza o .txt
        }

        return result;
    }

    // Funções auxiliares
    private Playlist searchPlaylist(int id) {
        Playlist p = null;
        
        for (Playlist playlist : playlistsBank) {
            if (playlist.getId() == id) {
                p = playlist;
            }
        }

        return p;
    }
}
