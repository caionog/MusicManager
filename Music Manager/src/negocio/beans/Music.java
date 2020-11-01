package negocio.beans;

public class Music {

	private int id;
	private String title;
	private String artist;
	private Genre genre;
	private String duration;

	public Music(int id, String title, String artist, Genre genre, String duration) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.duration = duration;
		
	}

	//---------------------getters-----------------//

	public int getId() {
		return id;
	}
	public String getArtist() {
		return artist;
	}
	public String getTitle() {
		return title;
	}
	public Genre getGenre() {
		return genre;
	}
	public String getDuration() {
		return duration;
	}

	//----------------------setters------------------//
	
	public int setId(int id) {
		return this.id = id;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	//--------------------metodos-------------------\\
	

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		Music other = (Music) obj;
		if (id != other.id)  return false;
		
		return true;
	}


	public String toString() {
		String s = "[";
		s += "id= " + id;
		s += ", title= " + title;
		s += ", artista= "+ artist;
		s += ", generos=" + genre;
		s += ", duration=" + duration;
		// s += ", summary= " + summary;
		// s += ", metadata= " + metaData;
		s += "]";

		return s;
	}
}
