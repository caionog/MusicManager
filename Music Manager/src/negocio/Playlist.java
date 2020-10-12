package negocio;
import negocio.Music;
import java.util.ArrayList;

public class Playlist {
	public ArrayList<Music> library = new ArrayList<Music>();
	int contador = 0;
	public int getSizeLibrary() 
	{
		return this.library.size();
	}
	public void addMusicLibrary(Music music) 
	{
		this.library.add(music);
		
		
	}
	
	public String getTitle(Music music) 
	{
		return music.getTitleSong();
	}
	/*
	public Music searchMusicLibrary(String title) 
	{
		int achou = this.getSizeLibrary();
		for(int posicao=0;posicao<achou;posicao++) 
		{
			Music titlesearcher = library.
			
		}
	}
*/
}
