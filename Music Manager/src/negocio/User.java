package negocio;

import java.util.ArrayList;

public class User {

	private int id; // único
	private UserPermission userPermission; // ADM ou NORMAL
	private String email;
	private String name;
	private String password;

	private ArrayList<Music> favoriteMusics = new ArrayList<>(0);
	private ArrayList<Playlist> favoritePlaylists = new ArrayList<>(0);
	
	
	public User(int id, UserPermission userPermission, String email, String name, String password) {
		this.id = id;
		this.userPermission = userPermission;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public User(int id, UserPermission userPermission, String email, String name, String password, 
			ArrayList<Music> favoriteMusics, ArrayList<Playlist> favoritePlaylists) {
		this.id = id;
		this.userPermission = userPermission;
		this.email = email;
		this.name = name;
		this.password = password;

		this.favoriteMusics = favoriteMusics;
		this.favoritePlaylists = favoritePlaylists;
	}


	//---------------------getters-----------------//

	public int getId() {
		return id;
	}
	public UserPermission getUserPermission() {
		return userPermission;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}

	public ArrayList<Music> getFavoriteMusics() {
		return favoriteMusics;
	}
	public void setFavoriteMusics(ArrayList<Music> favoriteMusics) {
		this.favoriteMusics = favoriteMusics;
	}
	
	//----------------------setters------------------//

	public void setId(int newUserId) {
		this.id = newUserId;
	}
	public void setUserPermission(UserPermission userPermission) {
		this.userPermission = userPermission;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ArrayList<Playlist> getFavoritePlaylists() {
		return favoritePlaylists;
	}
	public void setFavoritePlaylists(ArrayList<Playlist> favoritePlaylists) {
		this.favoritePlaylists = favoritePlaylists;
	}

	//--------------------metodos-------------------\\

	public void addFavMusic(Music m) {
		favoriteMusics.add(m);
	}

	public void addFavPlaylist(Playlist p) {
		favoritePlaylists.add(p);
	}

	public void removeFavMusic(Music m) {
		favoriteMusics.remove(m);
	}

	public void removeFavPlaylist(Playlist p) {
		favoritePlaylists.remove(p);
	}


	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		User other = (User) obj;
		if (id != other.id) return false;

		return true;
	}


	public String toString() {
		//nao mostrar senha
		return "ID: "+ this.id + "\n" + this.email +"\n"+ this.name + "\n" + "userPermission: " + this.userPermission;
	}


	public String musicsToIds() {
		String s = "";

		for (Music music : favoriteMusics) {
			s += music.getId() + ",";
		}

		return s;
	}


	public String playlistsToIds() {
		String s = "";

		for (Playlist playlist : favoritePlaylists) {
			s += playlist.getId() + ",";
		}

		return s;
	}
}
