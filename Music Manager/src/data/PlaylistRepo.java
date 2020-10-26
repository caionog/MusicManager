package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import negocio._Visibility; // Enum

import negocio.Playlist; // Classes base
import negocio.Music;

public class PlaylistRepo {
	
	private static PlaylistRepo instance;

    private ArrayList<Playlist> playlistsLibrary = new ArrayList<>(0);
    private String absolutePath = "Music Manager\\src\\data\\txt storage\\playlists repository\\";

    // TO-DO alterar id dentro do .txt ou visibilidade (U)
    
    //------------------ Singleton + Construtor ---------------//
    
    public static PlaylistRepo getInstance() {
		if (instance == null) {
            instance = new PlaylistRepo();
        }
        return instance;
    }
    
    private PlaylistRepo() {}

    //------------------ CRUD de playlists ---------------//

    // Create Music no ArrayList e cria um .txt no repositorio
    public void createPlaylist(ArrayList<Music> musics, int creatorId) throws IOException {

        // Cria a playlist
        int id = generateId(); // Gera um id unico, ou seja, nao se repete
        Playlist p = new Playlist(id, musics, creatorId, _Visibility.INVISIBLE);

        // Adiciona na biblioteca
        playlistsLibrary.add(p);

        // Cria o .txt da musica
        File playlistFile = new File(absolutePath + p.getId() + ".txt");
        if (playlistFile.createNewFile()) {

            String s = "";
            s += p.getId() + "\n";
            s += p.getCreatorId() + "\n";
            s += p.getVisibility().getStrValue() + "\n";
            for (Music music : musics) s += music.getId() + ",";
            s += "\n";
            
            // Escreve no file
            FileWriter writer = new FileWriter(playlistFile.getAbsolutePath());
            writer.write(s);
            writer.close();
            
        } else {
            System.out.println("file ja existe"); // Caso o gerador de ID falhe
        }
    }


    // Read playlist.txt
    public ArrayList<String> readPlaylist(int playlistId) throws FileNotFoundException {

        ArrayList<String> playlistData = new ArrayList<>(4);

        File playlistFile = new File(absolutePath + playlistId + ".txt");
        Scanner reader = new Scanner(playlistFile);

        while (reader.hasNextLine()) {
            String lineData = reader.nextLine();
            playlistData.add(lineData);
        }
        reader.close();

        return playlistData;
    }


    // Updaters no .txt
     
    public void updateDeletedMusics(int selectedMusicId) throws IOException {

        // Procura por uma playlist que contenha ua musica "deletada"
        for (Playlist playlist : playlistsLibrary) {

            ArrayList<Music> currentArray = playlist.getMusics();
            for (Music music : currentArray) {

                int currentId = music.getId();
                if ( currentId == selectedMusicId ) {
                    // Se verdade, então atualiza lista de ids do arquivo e o array dessa playlist
                    currentArray.remove(music);

                    File playlistFile = new File(absolutePath + playlist.getId() + ".txt");

                    ArrayList<String> playlistData = readPlaylist(playlist.getId());

                    String playlistId = playlistData.get(0); // Str
                    String creatorId = playlistData.get(1); // str
                    String visibility = playlistData.get(2); // Str
                    String musicIds[] = playlistData.get(3).split(","); // Str -> Str[] / ",2,3" -> [2, 3]

                    // Remove o id copiando o vetor para outro sem copiar o id que precisa ser removido
                    String newMusicIds = "";
                    for (int i = 0; i < musicIds.length; i++) {
                        if ( !musicIds[i].isEmpty() && currentId != Integer.valueOf(musicIds[i]) ) {
                            newMusicIds += musicIds[i] + ",";
                        }
                    }

                    String s = "";
                    s += playlistId + "\n";
                    s += creatorId + "\n";
                    s += visibility + "\n";
                    s += newMusicIds + "\n";

                    // Sobrescreve no file
                    FileWriter writer = new FileWriter(playlistFile.getAbsolutePath());
                    writer.write(s);
                    writer.close();

                    break;
                }
            } // Fim do for each music da playlist atual

        } // Fim do for each playlist
	}

    public void updateVisibility(String newVisibility, int playlistId) throws IOException {

        ArrayList<String> playlistData = readPlaylist(playlistId);

        String id = playlistData.get(0); // Str
        String creatorId = playlistData.get(1); // str
        // Não precisa pegar playlistData.get(2) que é a visibilidade antiga
        String musicsIds = playlistData.get(3); // Str -> Str[]

        String s = "";
        s += id + "\n";
        s += creatorId + "\n";
        s += newVisibility + "\n";
        s += musicsIds + "\n";

        File playlist = new File(absolutePath + playlistId + ".txt");

        FileWriter writer = new FileWriter(playlist.getAbsolutePath());
        writer.write(s); // Sobrescreve o .txt atualizando a visibilidade
        writer.close();
    }
    

    // Delete Playlist no ArrayList e deleta um .txt
    public void deletePlaylist(Playlist p) {
        Boolean teste = false;
        if (teste) {
            System.out.println(p.toString());
            System.out.println(searchPlaylist(p.getId()).toString());
        }

        Boolean result =  playlistsLibrary.remove(p);

        if (result == true) {
            // Atualiza o .txt
            File playlist = new File(absolutePath + p.getId() + ".txt");
            playlist.delete();

            if (teste) {
                System.out.println("Playlist(.txt) com id " + p.getId() + " deletada");
            }
        }
    }


    //------------------ Funções auxiliares ---------------//

    // Read todas as Playlist.txt e coloca tds no arraylist playlistLibrary
    public void populatePlaylistLibrary(MusicRepo musicRepo) throws FileNotFoundException {
        File playlistRepoFolder = new File(absolutePath);

        for (final File playlist : playlistRepoFolder.listFiles()) {

            int playlistId = Integer.valueOf(playlist.getName().split("[.]")[0]);
            ArrayList<String> playlistData = readPlaylist(playlistId);

            int id = Integer.valueOf(playlistData.get(0)); // Str -> int
            int creatorId = Integer.valueOf(playlistData.get(1)); // str -> int
            _Visibility v = Enum.valueOf(_Visibility.class, playlistData.get(2)); // Str -> _Visibilty
            String musicsIds[] = playlistData.get(3).split(","); // Str -> Str[] -> ArrayList<Music>

            // Str[] -> ArrayList<Music>
            ArrayList<Music> musics = new ArrayList<>();
            for (String musicId : musicsIds) {
                if ( !musicId.isEmpty() ){ 
                    Music m = musicRepo.searchMusic(Integer.valueOf(musicId));
                    if (m != null) musics.add(m);
                }
            }

            Playlist p = new Playlist(id, musics, creatorId, v);
            playlistsLibrary.add(p);
        }
    }

    public ArrayList<Playlist> getPlaylistsLibrary() {
        return playlistsLibrary;
    }

    public Playlist getPlaylistByIndex(int index) {
        return playlistsLibrary.get(index);
    }


    public Playlist getPlaylistById(int id) {
		Playlist p = searchPlaylist(id);

        return p;
    }


    private int generateId() throws FileNotFoundException {
        File musicRepoFolder = new File(absolutePath);

        int greaterId = 0;

        for (final File playlist : musicRepoFolder.listFiles()) {
            Scanner reader = new Scanner(playlist);
            int compareId = Integer.valueOf(reader.nextLine());
            reader.close();

            if (compareId >= greaterId) {
                greaterId = compareId;
            }
        }

        return greaterId+1;
    }
    

    public void resetRepo() {
        File playlistRepoFolder = new File(absolutePath);

        for (final File playlistFile : playlistRepoFolder.listFiles()) {
            playlistFile.delete();
        }
        
        playlistsLibrary = new ArrayList<Playlist>(0);
    }


    Playlist searchPlaylist(int id) {
        Playlist p = null;
        
        for (Playlist playlist : playlistsLibrary) {
            if (playlist.getId() == id) {
                p = playlist;
            }
        }

        return p;
    }
}
