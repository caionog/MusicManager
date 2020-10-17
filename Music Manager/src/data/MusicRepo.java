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
    private ArrayList<Music> musicLibrary = new ArrayList<Music>();
    private String absolutePath = "Music Manager\\src\\data\\txt storage\\music repository\\";

    // CRD (o U é Update, e editar música não faz sentido)

    // Create Music no ArrayList
    public void createMusic(String title, String artist, Genre genre, String duration)
            throws IOException {

        // Cria a musica
        int id = generateId();
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
            s += m.getGenre().getValue() + "\n";
            s += m.getDuration();

            // Escreve no file
            FileWriter writer = new FileWriter(musicFile.getAbsolutePath());
            writer.write(s);
            writer.close();
            
        } else {
            System.out.println("file ja existe");
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

    // Read Music num .txt e coloca tds elas no arraylist MusicBanck
    public void readMusicBanck() throws IOException {
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

            int id = Integer.valueOf(musicData.get(0)); // ID (Str)
            String title = musicData.get(1); // Title
            String artist = musicData.get(2); // Artist
            Genre genre = handleGenre(musicData.get(3)); // Genre (Str)
            String duration = musicData.get(4); // Duration(Str/double)

            Music m = new Music(id, title, artist, genre, duration);
            musicLibrary.add(m);
        }
    }

    // Deletar Music no ArrayList e atualiza o .txt
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

        int id = 0;

        for (final File music : musicRepoFolder.listFiles()) {
            Scanner reader = new Scanner(music);
            int compareId = Integer.valueOf(reader.nextLine());
            reader.close();

            if (compareId >= id) {
                id = compareId;
            }
        }

        return id+1;
    }

    public void resetRepo() {
        File musicRepoFolder = new File(absolutePath);

        for (final File music : musicRepoFolder.listFiles()) {
            music.delete();
        }
        
        musicLibrary = new ArrayList<Music>(0);
    }

    private Music searchMusic(int id) {
        Music m = null;
        
        for (Music music : musicLibrary) {
            if (music.getId() == id) {
                m = music;
            }
        }

        return m;
    }

    private Genre handleGenre(String genreStr) {
        int genreInt = Integer.valueOf(genreStr);
        Genre g;
        switch (genreInt) {
            case 0:
                g = Enum.valueOf(Genre.class, "NOT_LISTED");
                break;
            case 1:
                g = Enum.valueOf(Genre.class, "AXE");
                break;
            case 2:
                g = Enum.valueOf(Genre.class, "BLUES");
                break;
            case 3:
                g = Enum.valueOf(Genre.class, "COUNTRY"); 
                break;
            case 4:
                g = Enum.valueOf(Genre.class, "ELETRONIC");
                break;
            case 5:
                g = Enum.valueOf(Genre.class, "LINING");
                break;
            case 6:
                g = Enum.valueOf(Genre.class, "FUNK");
                break;
            case 7:
                g = Enum.valueOf(Genre.class, "GOSPEL");
                break;
            case 8:
                g = Enum.valueOf(Genre.class, "HIPHOP");
                break;
            case 9:
                g = Enum.valueOf(Genre.class, "JAZZ");
                break;
            case 10:
                g = Enum.valueOf(Genre.class, "MPB");
                break;
            case 11:
                g = Enum.valueOf(Genre.class, "CLASSIC");
                break;    
            case 12:
                g = Enum.valueOf(Genre.class, "PAGODE");
                break;
            case 13:
                g = Enum.valueOf(Genre.class, "POP");
                break;
            case 14:
                g = Enum.valueOf(Genre.class, "REAGUE");
                break;
            case 15:
                g = Enum.valueOf(Genre.class, "ROCK");
                break;
            case 16:
                g = Enum.valueOf(Genre.class, "SAMBA");
                break;
            case 17:
                g = Enum.valueOf(Genre.class, "BACK_COUNTRY");
                break;
            default:
                g = Enum.valueOf(Genre.class, "NULL");
        }

        return g;
    }
}
