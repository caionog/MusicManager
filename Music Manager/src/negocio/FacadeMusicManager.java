package negocio;

import java.io.IOException;
import java.util.ArrayList;

import negocio.controllers.MusicController; // Controladores
import negocio.controllers.PlaylistController;
import negocio.controllers.UserController;

import negocio.beans.Music; // Classe base
import negocio.beans.Playlist;
import negocio.beans.User;

public class FacadeMusicManager {

	User loggedUser;

	MusicController musicController = new MusicController();
	PlaylistController playlistContrtoller = new PlaylistController();
	UserController userController = new UserController();

	// ------------------ Singleton + Construtor ---------------//

	private static FacadeMusicManager instance;

	public static FacadeMusicManager getInstance() {
		if (instance == null) {
			instance = new FacadeMusicManager();
		}
		return instance;
	}

	private FacadeMusicManager() {
	}

	// ---------------------------------------------------------//

	public ArrayList<Music> getMusicLibrary() {
		return musicController.getMusicLibrary(); // Retorna o array inteiro com todas as músicas;
	}


	public ArrayList<Playlist> getPlaylistLibrary() {
		return playlistContrtoller.getPlaylistsLibrary();
	}


	public ArrayList<User> getUserLibrary() {
		return userController.getUserLibrary();
	}


	public ArrayList<Music> getLoggedUserFavMusics() {
		return loggedUser.getFavoriteMusics();
	}


	public ArrayList<Playlist> getLoggedUserFavPlaylists() {
		return loggedUser.getFavoritePlaylists();
	}


	public void addMusicToTable() {

	}


	public void addPlaylistToTable() {

	}


	public int getLoggedUserId() {
		return loggedUser.getId();
	}


	public String getLoggedUserName() {
		return loggedUser.getName();
	}


	public String getUserNameById(int id) {
		return userController.getUserNameById(id);
	}


	public boolean handleUserLogin(String nameOrEmail, String password) {

		User user = userController.handleUserLogin(nameOrEmail, password);

		if (user != null) {
			return true;
		} else {
			return false;
		}
	}


	public void favMusic(Music selectedMusic) {
		userController.addFavoriteMusic(loggedUser, selectedMusic);
	}


	public void favPlaylist(Playlist selectedPlaylist) throws IOException {
		userController.addFavoritePlaylist(loggedUser, selectedPlaylist);
	}

}
