package negocio;

public class Music {
	//Classe que vai informar os dados das musicas para a criacao das playlists
	private String musicName;
	private Genres musicGenres;
	private int musicID;
	private String musicArtist;
	private String musicRecorder;
	
	//Construtores e get/sets
	public Music(String musicName, Genres musicGenre, int musicID, String musicArtist, String musicRecorder) {
		this.musicName = musicName;
		this.musicGenres = musicGenre;
		this.musicID = musicID;
		this.musicArtist = musicArtist;
		this.musicRecorder = musicRecorder;
	}
	
	
	
	public String getMusicName() {
		return musicName;
	}



	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}



	public Genres getMusicGenre() {
		return musicGenres;
	}



	public void setMusicGenre(Genres musicGenres) {
		this.musicGenres = musicGenres;
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
		String s = ""; 

		s += "Artista: " + this.musicArtist;
		s += "musicID: " + this.musicID;
		s += "Titulo: " + this.musicName;
		s += "Gravadora: " + this.musicRecorder;

		return s;
	}
	
	public void addFavMusic(Music music) 
	{
		//Favoritos = this.music?
	}
	
	public void addFavPlaylist(Music music) 
	{
		
	}

}
