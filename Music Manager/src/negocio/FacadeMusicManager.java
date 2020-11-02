package negocio;

import java.io.IOException;
import java.util.ArrayList;

import negocio.beans.Filter;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import negocio.controllers.MusicController; // Controladores
import negocio.controllers.PlaylistController;
import negocio.controllers.UserController;

import negocio.beans.Music; // Classe base
import negocio.beans.Playlist;
import negocio.beans.User;
import negocio.beans.UserPermission;

public class FacadeMusicManager {

	User loggedUser;
	Filter settings = new Filter();

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
	//AQUI
//	public ArrayList<Playlist> getPlaylistMusicLibrary() {
//		return playlistContrtoller.getPlaylistMusicLibrary();
//	}


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
	public String getLoggedUserEmail() {
		return loggedUser.getEmail();
	}
	public String getLoggedUserPassword() {
		
		return loggedUser.getPassword();
	}
	


	public String getUserNameById(int id) {
		return userController.getUserNameById(id);
	}
	


	public boolean handleUserLogin(String nameOrEmail, String password) {

		loggedUser = userController.handleUserLogin(nameOrEmail, password);

		if (loggedUser != null) {
			return true;
		} else {
			return false;
		}
	}


	public boolean handleUserRegister(UserPermission adm, String email, String name, String password) throws IOException {
		return userController.handleUserRegister(adm, email, name, password);
	}


	public void favMusic(Music selectedMusic) {
		userController.addFavoriteMusic(loggedUser, selectedMusic);
	}

	public void unfavMusic(Music selectedMusic) {
		userController.removeFavoriteMusic(loggedUser, selectedMusic);
	}


	public void favPlaylist(Playlist selectedPlaylist) throws IOException {
		userController.addFavoritePlaylist(loggedUser, selectedPlaylist);
	}

	public void unfavPlaylist(Playlist selectedPlaylist) {
		userController.removeFavoritePlaylist(loggedUser, selectedPlaylist);
	}


	public void editLoggedUser(String email, String password, String name) throws IOException {
		userController.modifyUser(loggedUser, name, password, email);
	}

	
	public void setFilterSettings(String title, String artist, String genreStr, String durationStr, Boolean check) {
		settings.setTitle(title);
		settings.setArtist(artist);
		settings.setMusicGenreStr(genreStr);
		settings.setDurationStr(durationStr);
		settings.setShowMusicFav(check);
	}
	public void setFilterSettings(String creatorName, String genreStr, Boolean check) {
		settings.setCreatorName(creatorName);
		settings.setPlaylistGenreStr(genreStr);
		settings.setShowPlaylistFav(check);
	}


	public ArrayList<String> getMusicFilterSettings() {
		ArrayList<String> s = new ArrayList<>(5);
		s.add(settings.getTitle());
		s.add(settings.getArtist());
		s.add(settings.getMusicGenreStr());
		s.add(settings.getDurationStr());
		s.add(settings.getShowMusicFav().toString());
		return s;
	}


	public ArrayList<String> getPlaylistFilterSettings() {
		ArrayList<String> s = new ArrayList<>(3);
		s.add(settings.getCreatorName());
		s.add(settings.getPlaylistGenreStr());
		s.add(settings.getShowPlaylistFav().toString());
		return s;
	}


	public void createMusic(String path) throws IOException, SAXException, TikaException {
		musicController.extractMetaData(path);
	}

	public boolean getMusicFavCheck() {
		return settings.getShowMusicFav();
	}

	public boolean getPlaylistFavCheck() {
		return settings.getShowPlaylistFav();
	}

	public boolean getLoggedPermission() {
		return loggedUser.getUserPermission().getValue();
	}

	public void deleteMusic(Music selectedMusic) throws IOException {
		musicController.deleteMusic(selectedMusic);
	}

	public void deletePlaylist(Playlist selectedPlaylist) {
		playlistContrtoller.deletePlaylist(selectedPlaylist);
	}
}
