package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

import negocio.interfaces.IMusicRepo; // Interface

import negocio.beans.Music; // Classe base

import negocio.beans.Genre; // Enum

public class MusicRepo implements IMusicRepo {

    private ArrayList<Music> musicLibrary = new ArrayList<>(0);
    private String absolutePath = "Music Manager\\src\\data\\txt storage\\musics repository\\";

    //------------------ Singleton + Construtor ---------------//
    
    private static MusicRepo instance;
    
    public static MusicRepo getInstance() {
		if (instance == null) {
            instance = new MusicRepo();
        }
        return instance;
    }
    
    private MusicRepo() {}
    
    //------------------ CRD de musics ---------------//

    // Create Music no ArrayList e cria um .txt no repositorio
    @Override
    public void createMusic(String title, String artist, Genre genre, String duration) throws IOException, FileNotFoundException {

        // Cria a musica
        int id = generateId(); // Gera um id único
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

        Boolean teste = false;
        if (teste) {
            System.out.println("= ---------------------- =");
            System.out.println("File name: " + musicFile.getName());
            System.out.println("File path: " + musicFile.getAbsolutePath());
            System.out.println("Successfully wrote to the file :D");
            System.out.println("= ---------------------- =");
        }
    }


    // Read Music.txt
    @Override
    public ArrayList<String> readMusic(int musicId) throws FileNotFoundException {

        ArrayList<String> musicData = new ArrayList<>(5);

        File musicFile = new File(absolutePath + musicId + ".txt");
        Scanner reader = new Scanner(musicFile);

        while (reader.hasNextLine()) {
            String lineData = reader.nextLine();
            musicData.add(lineData);
        }
        reader.close();

        return musicData;
    }


    // Deletar Music no ArrayList e deleta um .txt
    @Override
    public void deleteMusic(Music m) {

        Boolean result = musicLibrary.remove(m);

        if (result == true) {
            // Atualiza o .txt
            File music = new File(absolutePath + m.getId() + ".txt");
            music.delete();
        }
    }


    //------------------ Funções auxiliares ---------------//

    // Read todas as Musics.txt e coloca tds no arraylist musicLibrary
    @Override
    public void populateMusicLibrary() throws IOException {
        File musicRepoFolder = new File(absolutePath);

        for (final File music : musicRepoFolder.listFiles()) {

            int musicId = Integer.valueOf(music.getName().split("[.]")[0]);
            ArrayList<String> musicData = readMusic( musicId );

            int id = Integer.valueOf(musicData.get(0)); // Str -> int
            String title = musicData.get(1); // str
            String artist = musicData.get(2); // str
            Genre genre = Enum.valueOf(Genre.class, musicData.get(3)); // Str -> Genre
            String duration = musicData.get(4); // Str (-> double somente na hora de vizualizar)

            Music m = new Music(id, title, artist, genre, duration);
            musicLibrary.add(m);
        }
    }


    @Override
    public ArrayList<Music> getMusicLibrary() {
        return musicLibrary;
    }


    @Override
    public Music getMusicByIndex(int index) {
        return musicLibrary.get(index);
    }


    @Override
    public Music getMusicById(int id) {
        Music m = searchMusic(id);

        return m;
    }


    private int generateId() throws FileNotFoundException {

        int greaterId = 0, currentId;
        
        for (Music music : musicLibrary) {
			currentId = music.getId();
			
			if ( currentId >= greaterId ) {
				greaterId = currentId;
			}
		}

        return greaterId+1;
    }


    @Override
    public void resetRepo() {
        File musicRepoFolder = new File(absolutePath);

        for (final File music : musicRepoFolder.listFiles()) {
            music.delete();
        }
        
        musicLibrary = new ArrayList<Music>(0);
    }


    @Override
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
