package negocio;
import java.util.ArrayList;

public class Music {
	//Classe que vai informar os dados das m�sicas para a cria��o das playlists
	private String musicName;
	private ArrayList<String> musicGenre;
	private int musicID;
	private String musicArtist;
	private String musicRecorder;
	
	//Construtores e get/sets
	public Music(String musicName,ArrayList<String> musicGenre,int musicID,
			String musicArtist,String musicRecorder) {}
	
	
	
	public String getMusicName() {
		return musicName;
	}



	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}



	public ArrayList<String> getMusicGenre() {
		return musicGenre;
	}



	public void setMusicGenre(ArrayList<String> musicGenre) {
		this.musicGenre = musicGenre;
	}



	public int getMusicID() {
		return musicID;
	}



	public void setMusicID(int musicID) {
		this.musicID = musicID;
	}



	public String getMusicArtist() {
		return musicArtist;
	}



	public void setMusicArtist(String musicArtist) {
		this.musicArtist = musicArtist;
	}



	public String getMusicRecorder() {
		return musicRecorder;
	}



	public void setMusicRecorder(String musicRecorder) {
		this.musicRecorder = musicRecorder;
	}


//M�todos
	public boolean equals(Music outraMusic) 
	{
		return true;
	}
	
	public String toString() 
	{
		return this.musicArtist + this.musicID + this.musicName + this.musicRecorder;
	}
	
	public void addFavMusic(Music music) 
	{
		//Favoritos = this.music?
	}
	
	public void addFavPlaylist(Music music) 
	{
		
	}

}
