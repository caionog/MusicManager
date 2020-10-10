
import java.util.ArrayList;

public class Playlist {
	private User playlistUser;
	private ArrayList<Music> PlaylistMusic;
	
	//GET/SETTERS
	
	
	
	public boolean equals(Playlist outraPlaylist) 
	{
		return true;
	}
	
	public String toString() 
	{
		return "Dados do usuario: " + this.playlistUser.toString() 
		+" dados da playlist: "+ this.PlaylistMusic.toString();
	}
	
	public void createPlaylist() {}
	public void addMusicPlaylist() {}
	public void removeMusicPlaylist() {}
	public void deleteMusicPlaylist() {}

}
