package negocio;

import java.util.ArrayList;

public class User {
	//Classe que vai informar dados do usuario para o cadastro e login
	//e fornercer informacoes necessarias para as outras classes
	private int id;
	private boolean adm;
	private String name;
	private String password;
	private String email;
	
	private ArrayList<Music> favoriteMusics = new ArrayList<Music>(0);
	private ArrayList<Playlist> favoritePlaylists = new ArrayList<Playlist>(0);
	
	
	public User(int id, Boolean adm, String email, String name, String password) {
		this.id = id;
		this.adm = adm;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	//---------------------getters-----------------//

	public String getNameUser() {
		return this.name;
	}
	public String getPasswordUser() {
		return this.password;
	}
	public String getEmailUser() {
		return this.email;
	}
	public int getUserId() {
		return this.id;
	}
	
	//----------------------setters------------------//

	public void setNameUser(String newNameUser) {
		this.name = newNameUser;
	}
	public void setPasswordUser(String newPasswordUser) {
		this.password = newPasswordUser;
	}
	public void setEmailUser(String newEmailUser) {
		this.email = newEmailUser;
	}
	public void setUserId(int newUserId) {
		this.id = newUserId;
	}

	//--------------------metodos-------------------\\

	public void modifyUser(String newName, String newPassword, String newEmail) {
		if (newName != "") {
			this.name = newName;
		} 

		if (newPassword != "") {
			this.password = newPassword;
		}

		if (newEmail != "") {
			this.email = newEmail;
		}
	}

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

	public ArrayList<Music> filterMusic(ArrayList<Genre> genres, String title) {

		ArrayList<Music> musics = new ArrayList<Music>(0);

		// Acessa repositório de Musicas <---------- falta completar

		return musics;
	}

	public ArrayList<Playlist> filterPlaylist(ArrayList<Genre> genres, String title) {

		ArrayList<Playlist> playlists = new ArrayList<Playlist>(0);

		// Acessa repositório de Musicas <---------- falta completar

		return playlists;
	}

	public void toggleVisibility(Playlist p) {
		if ( p.getVisibility().value ) {
			p.setVisibility( _Visibility.INVISIBLE );
		} else {
			p.setVisibility( _Visibility.VISIBLE );
		}
	}

	public String toString() {
		//nao mostrar senha
		return "ID: "+ this.id + "\n" + this.email +"\n"+ this.name + "\n" + "ADM: " + this.adm;
	}
}
