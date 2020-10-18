package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import negocio.Genre;
import negocio.Music;

public class MusicRepo {

    private ArrayList<Music> musicLibrary = new ArrayList<>();
    private String absolutePath = "Music Manager\\src\\data\\txt storage\\musics repository\\";

    // CRD (o U é Update, e editar música não faz sentido)

    // Create Music no ArrayList e cria um .txt no repositorio
    public void createMusic(String title, String artist, Genre genre, String duration) throws IOException, FileNotFoundException {

        // Cria a musica
        int id = generateId(); // Gera um id unico, ou seja, nao se repete
        Music m = new Music(id, title, artist, genre, duration);

        // Adiciona na biblioteca
        musicLibrary.add(m);

        // Cria o .txt da musica
        File musicFile = new File(absolutePath + m.getId() + ".txt");
        if (musicFile.createNewFile()) {

            String s = "";
            s += m.getId() + "\n";
            s += m.getTitle() + "\n";
            s += m.getArtist() + "\n";
            s += m.getGenre().getValueStr() + "\n";
            s += m.getDuration();

            // Escreve no file
            FileWriter writer = new FileWriter(musicFile.getAbsolutePath());
            writer.write(s);
            writer.close();
            
        } else {
            System.out.println("file ja existe");  // Caso o gerador de ID falhe
        }

        Boolean teste = true;
        if (teste) {
            System.out.println("= ---------------------- =");
            System.out.println("File name: " + musicFile.getName());
            System.out.println("File path: " + musicFile.getAbsolutePath());
            System.out.println("Successfully wrote to the file :D");
            System.out.println("= ---------------------- =");
        }
    }

    // Read Music num .txt e coloca tds elas no arraylist musicLibrary
    public void readMusicLibrary() throws IOException {
        File musicRepoFolder = new File(absolutePath);

        for (final File music : musicRepoFolder.listFiles()) {
            Boolean teste = false;
            if (teste) {
                System.out.println(music.getName());
                System.out.println(music.getPath());
            }

            ArrayList<String> musicData = new ArrayList<String>(5);
            Scanner reader = new Scanner(music);
            while (reader.hasNextLine()) {
                String lineData = reader.nextLine();
                if (teste) {
                    System.out.println(lineData);
                }
                
                musicData.add(lineData);
            }
            reader.close();

            int id = Integer.valueOf(musicData.get(0)); // Str -> int
            String title = musicData.get(1); // str
            String artist = musicData.get(2); // str
            Genre genre = Enum.valueOf(Genre.class, musicData.get(3)); // Str -> Genre
            String duration = musicData.get(4); // Str (-> double somente na hora de vizualizar)

            Music m = new Music(id, title, artist, genre, duration);
            musicLibrary.add(m);
        }
    }

    // Deletar Music no ArrayList e deleta um .txt
    public void deleteMusic(Music m) {
        Boolean teste = false;
        if (teste) {
            System.out.println(m.toString());
            System.out.println(searchMusic(m.getId()).toString());
        }
        
        Boolean result = musicLibrary.remove(m);

        if (result == true) {
            // Atualiza o .txt
            File music = new File(absolutePath + m.getId() + ".txt");
            music.delete();

            if (teste) {
                System.out.println("Musica(.txt) com id " + m.getId() + " deletada");
            }
        }
    }

    // Funções auxiliares

    public ArrayList<Music> getMusicLibrary() {
        return musicLibrary;
    }

    public Music getMusicByIndex(int index) {
        return musicLibrary.get(index);
    }

    public Music getMusicById(int id) {
        Music m = searchMusic(id);

        return m;
    }

    private int generateId() throws FileNotFoundException {
        File musicRepoFolder = new File(absolutePath);

        int greaterId = 0;

        for (final File music : musicRepoFolder.listFiles()) {
            Scanner reader = new Scanner(music);
            int compareId = Integer.valueOf(reader.nextLine());
            reader.close();

            if (compareId >= greaterId) {
                greaterId = compareId;
            }
        }

        return greaterId+1;
    }

    public void resetRepo() {
        File musicRepoFolder = new File(absolutePath);

        for (final File music : musicRepoFolder.listFiles()) {
            music.delete();
        }
        
        musicLibrary = new ArrayList<Music>(0);
    }

    public Music searchMusic(int id) {
        Music m = null;
        
        for (Music music : musicLibrary) {
            if (music.getId() == id) {
                m = music;
            }
        }

        return m;
    }
}
