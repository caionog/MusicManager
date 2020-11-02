package negocio.beans;

import java.util.ArrayList;

public class Playlist {

	private int id;
	private ArrayList<Music> musics;
	private String creator;
	private _Visibility visibility = _Visibility.INVISIBLE; // VISIBLE ou INVISIBLE
	
	public Playlist(int id, ArrayList<Music> musics, String creator, _Visibility visibility) {
		this.id = id;
		this.musics = musics;
		this.creator = creator;
		this.visibility = visibility;
	}

	//---------------------getters-----------------//

	public int getId() {
		return id;
	}
	public ArrayList<Music> getMusics() {
		return musics;
	}
	public String getCreator() {
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
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public void setVisibility(_Visibility visibility) {
		this.visibility = visibility;
	}

	//--------------------metodos-------------------\\

	public void addMusicPlaylist(Music m) {
		musics.add(m);
	}

	public void removeMusicPlaylist(Music m) {
		musics.remove(m);
	}
	
	
	public void toogleVisibility() {
		if ( visibility.getValue() ) {
			visibility = _Visibility.INVISIBLE;
		} else {
			visibility = _Visibility.VISIBLE;
		}
	}


	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		Playlist other = (Playlist) obj;
		if (id != other.id) return false;
		
		return true;
	}
	

	public String toString() {
		String s = "=-= Dados do usuario =-=" + "\n";
		s += "creator: " + creator + "\n";
		s += "=-= dados da playlist =-=" + "\n";
		s += id + "\n";
		s += visibility + "\n";
		s += "=-= Lista de musicas =-=" + "\n";
		for (Music music : musics) {
			s += music.toString() + "\n";
		}

		return s;
	}
}
