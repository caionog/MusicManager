package negocio;

import java.util.ArrayList;

public class Music {

	private int id;
	private String title;
	private String artist;
	private ArrayList<Genre> genres = new ArrayList<Genre>();

	private String summary;
	private String metaData;

	public Music(int id, String title, String artist, ArrayList<Genre> genres, String summary, String metaData) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.genres = genres;

		this.summary = summary;
		this.metaData = metaData;
	}

	//---------------------getters-----------------//

	public int getId() {
		return id;
	}
	public String getSummary() {
		return summary;
	}
	public String getMetaData() {
		return metaData;
	}
	public String getArtistSong() {
		return artist;
	}
	public String getTitle() {
		return title;
	}
	public ArrayList<Genre> getGenres() {
		return genres;
	}

	//----------------------setters------------------//
	
	public int setId(int id) {
		return this.id = id;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}

	//--------------------metodos-------------------\\

	public void addGenre(Genre g) {
		genres.add(g);
	}
	
	public String toString() {
		String s = "[";
		s += "id= " + id;
		s += ", title= " + title;
		s += ", artista= "+ artist;
		s += ", generos=" + genres;
		s += ", summary= " + summary;
		s += ", metadata= " + metaData;
		s += "]";

		return s;
	}

}
