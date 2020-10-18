package negocio;

import java.util.ArrayList;

public class Playlist {

	private int id;
	private ArrayList<Music> musics;
	private int creatorId;
	private _Visibility visibility = _Visibility.INVISIBLE;
	
	public Playlist(int id, ArrayList<Music> musics, int creatorId, _Visibility visibility) {
		this.id = id;
		this.musics = musics;
		this.creatorId = creatorId;
		this.visibility = visibility;
	}

	//---------------------getters-----------------//

	public int getId() {
		return id;
	}
	public ArrayList<Music> getMusics() {
		return musics;
	}
	public int getCreatorId() {
		return creatorId;
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
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
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
		s += "creatorId: " + creatorId + "\n";
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
