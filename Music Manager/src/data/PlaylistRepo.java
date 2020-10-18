package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import negocio.Music;
import negocio.Playlist;
import negocio.User;
import negocio._Visibility;

public class PlaylistRepo {

    private ArrayList<Playlist> playlistsLibrary = new ArrayList<>();
    private String absolutePath = "Music Manager\\src\\data\\txt storage\\playlists repository\\";

    // TO-DO alterar id dentro do .txt ou visibilidade (U)

    // CRUD

    // Create Music no ArrayList e cria um .txt no repositorio
    public void createPlaylist(ArrayList<Music> musics, User creator) throws IOException {

        // Cria a playlist
        int id = generateId(); // Gera um id unico, ou seja, nao se repete
        Playlist p = new Playlist(id, musics, creator.getUserId(), _Visibility.INVISIBLE);

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

    // Read Playlist num .txt e coloca tds elas no arraylist playlistsLibrary
    public void readPlaylistLibrary(MusicRepo musicRepo) throws FileNotFoundException {
        File playlistRepoFolder = new File(absolutePath);

        for (final File playlist : playlistRepoFolder.listFiles()) {
            Boolean teste = false;
            if (teste) {
                System.out.println(playlist.getName());
                System.out.println(playlist.getPath());
            }

            ArrayList<String> playlistData = new ArrayList<>(4);
            Scanner reader = new Scanner(playlist);
            while (reader.hasNextLine()) {
                String lineData = reader.nextLine();
                if (teste) {
                    System.out.println(lineData);
                }
                
                playlistData.add(lineData);
            }
            reader.close();

            int id = Integer.valueOf(playlistData.get(0)); // Str -> int
            int creatorId = Integer.valueOf(playlistData.get(1)); // str -> int
            _Visibility v = Enum.valueOf(_Visibility.class, playlistData.get(2)); // Str -> _Visibilty
            String musicsIds[] = playlistData.get(3).split(","); // Str -> Str[] -> ArrayList<Music>

            // Str[] -> ArrayList<Music>
            ArrayList<Music> musics = new ArrayList<>();
            for (String musicId : musicsIds) {
                Music m = musicRepo.searchMusic(Integer.valueOf(musicId));
                if (m != null) musics.add(m);
            }

            Playlist p = new Playlist(id, musics, creatorId, v);
            playlistsLibrary.add(p);
        }
    }

    // Update palylist no Arraylist e no .txt ?
    public void updatePlaylist(int[] selectedToRemoveMusicIds) {

    }

    public void updatePlaylist(Playlist p) throws IOException {
        if ( p.getVisibility().getValue()) {
			p.setVisibility( _Visibility.INVISIBLE );
		} else {
			p.setVisibility( _Visibility.VISIBLE );
        }
        
        // Atualiza o .txt
        File playlistFile = new File(absolutePath + p.getId() + ".txt");

        ArrayList<String> playlistData = new ArrayList<>(4);
        Scanner reader = new Scanner(playlistFile);
        while (reader.hasNextLine()) {
            String lineData = reader.nextLine();
            playlistData.add(lineData);
        }
        reader.close();

        // playlistFile.delete();
        //File newPlaylistFile = new File(absolutePath + p.getId() + ".txt");

        String id = playlistData.get(0); // Str
        String creatorId = playlistData.get(1); // str
        String visibility = playlistData.get(2).equals("VISIBLE") ? "INVISIBLE" : "VISIBLE"; // Str -> Str
        String musicsIds = playlistData.get(3); // Str

        final String s = id + "\n" + creatorId + "\n" + visibility + "\n" + musicsIds + "\n";

        FileWriter writer = new FileWriter(playlistFile, false);
        //FileWriter writer = new FileWriter(newPlaylistFile, false);
        writer.write(s);
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

    // Funções auxiliares

    public ArrayList<Playlist> getPlaylistsLibrary() {
        return playlistsLibrary;
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
