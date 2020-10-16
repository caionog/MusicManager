package negocio;

import java.util.ArrayList;

public class Playlist {

	private int id;
	private ArrayList<Music> musics;
	private User creator;
	private _Visibility visibility = Enum.valueOf(_Visibility.class, "INVISIBLE");
	
	public Playlist(int id, ArrayList<Music> musics, User creator) {
		this.id = id;
		this.musics = musics;
		this.creator = creator;
	}

	//---------------------getters-----------------//

	public int getId() {
		return id;
	}
	public ArrayList<Music> getMusics() {
		return musics;
	}
	public User getCreator() {
		return creator;
	}
	public _Visibility getVisibility() {
		return visibility;
	}

	//----------------------setters------------------//

	public void setId(int id) {
		this.id = id;
	}
	public void setMusics(ArrayList<Music> musics) {
		this.musics = musics;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public void setVisibility(_Visibility visibility) {
		this.visibility = visibility;
	}

	//--------------------metodos-------------------\\

	public void addMusicPlaylist(Music m) {
		this.musics.add(m);
	}

	public void removeMusicPlaylist(Music m) {
		musics.remove(m);
	}

	public String toString() {
		String s = "=-= Dados do usuario =-=" + "\n";
		s += creator.toString() + "\n";
		s += "=-= dados da playlist =-=" + "\n";
		s += musics.toString();

		return s;
	}
}
