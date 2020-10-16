package data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import negocio.Genre;
import negocio.Music;

public class MusicRepo {
    private ArrayList<Music> library = new ArrayList<Music>();

    // CRD (o U é Update/Editar, e editar música não faz sentido)

    // Create Music no ArrayList
    public void createMusic(String title, String artist, ArrayList<Genre> genres, String summary, String metaData) {

        // Simulação dos dados extraidos na musica "GD\BackOnTrack.mp3"
        genres = new ArrayList<Genre>();
        Genre g = Enum.valueOf(Genre.class, "ELETRONIC");
        Music m = new Music(1, "BackOnTrack", "Waterflame", genres, "Musica do jogo geometry dash", "metaData");
        m.addGenre(g);
        System.out.println("Simulação de criar música: \n" + m.toString());

        // Comentado enquanto a função extrair estivar sendo criada
        // int id = library.size()+1;
        // Music m = new Music(id, title, artist, genres, summary, metaData);

        library.add(m);

        // TO-DO: Código que adiciona no .txt mais uma Music
    }

    // Read Music num .txt e coloca tds elas no arraylist MusicBanck
    public void readMusicBanck() throws IOException {
        FileReader reader = new FileReader("Music Manager\\src\\data\\txt storage\\repositorio de musicas.txt");

        reader.close();
        // int character = reader.read();

        // String id = "";
        // String name;

        
 
        // while ( character != ' ' ) {
        //     id += character;
        //     System.out.print((char) character);
        //     character = reader.read();
        // }

        // System.out.print( "\n" + int.valueOff(id));

        // Music m = new Music( int.valueOff(id) );
    }

    // Deletar Music no ArrayList e atualiza o .txt
    public Boolean deleteMusic(Music m) {
        Boolean result = library.remove(m);

        if (result == true) {
            // Atualiza o .txt
        }

        return result;
    }

    // Funções auxiliares

    private Music searchMusic(int id) {
        Music m = null;
        
        for (Music music : library) {
            if (music.getId() == id) {
                m = music;
            }
        }

        return m;
    }
}
