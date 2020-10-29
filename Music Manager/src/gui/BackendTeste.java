package gui;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import negocio.beans.UserPermission; // Enum

import negocio.beans.Music; // Classes base
import negocio.beans.Playlist;
import negocio.beans.User;

import negocio.controllers.MusicController; // Controladores
import negocio.controllers.PlaylistController;
import negocio.controllers.UserController;

public class BackendTeste {

	public static void backendTeste() throws IOException, SAXException, TikaException, Exception {
		
		System.out.println("[ ('¬')_Ll Loading Program... ]");

		// Instanciando os controladores para testar o sistema

		MusicController musicController = new MusicController();
		PlaylistController playlistController = new PlaylistController();
		UserController userController = new UserController();

		musicController.resetRepo();
		musicController.populateMusicLibrary(); // Preenche o array com as musicas ja guardadas nos .txt

		playlistController.resetRepo();
		playlistController.populatePlaylistLibrary();

		userController.resetRepo();
		userController.populateUsersRepo();

		////// Início dos teste  //////

		// Criando 2 usuários
		userController.handleUserRegister(UserPermission.NORMAL, "maria@gmail.com", "Maria Ferreira", "123456");
		userController.handleUserRegister(UserPermission.ADM, "logged@gmail.com", "usuário de teste", "1234");
		
		User defaultUser = userController.getUserByIndex(0);
		User loggedUser = userController.getUserByIndex(1);


		// Simulando o input do path duma música
		String mp3StoragePath = "Music Manager\\src\\data\\mp3 storage\\";
		String pathSong1 = mp3StoragePath + "GD\\BackOnTrack" + ".mp3";
		String pathSong2 = mp3StoragePath + "hey-jude" + ".mp3";
		String pathSong3 = mp3StoragePath + "GD\\53576" + ".mp3";
		String pathSong4 = mp3StoragePath + "Transistor\\Darren Korb - She Shines" + ".mp3";
		String pathSong5 = mp3StoragePath + "ADOFAI\\The Midnight Train" + ".mp3";

		// Simulando a criação da Music no repositório de musicas com base no input path
		musicController.extractMetaData(pathSong1);
		musicController.extractMetaData(pathSong2);
		musicController.extractMetaData(pathSong3);
		musicController.extractMetaData(pathSong4);
		musicController.extractMetaData(pathSong5);

		// Simulando a criação de playlists
		ArrayList<Music> selectedMusics = new ArrayList<Music>(2);
		for (Music music : musicController.getMusicLibrary()) {
			if (selectedMusics.size() < 2) {
				selectedMusics.add(music);
			}
		}

		playlistController.groupSelectedMusic(selectedMusics, defaultUser);

		ArrayList<Music> selectedMusics2 = new ArrayList<Music>(2);
		for (Music music : musicController.getMusicLibrary()) {
			if (selectedMusics2.size() < 2) {
				selectedMusics2.add(music);
			}
		}

		playlistController.groupSelectedMusic(selectedMusics2, defaultUser);

		// Alterando visibilidade da playlist
		Playlist selectedPlaylist = playlistController.getPlaylistsLibrary().get(0);
		playlistController.togglePlaylistVisibility(selectedPlaylist);
			
		// Adicionando musicas e playlists favoritas no loggedUser
		Music favMusic = musicController.getMusicById(3);
		Playlist favPlaylist = playlistController.getPlaylistByIndex(0);

		if (favMusic != null) userController.addFavoriteMusic(defaultUser, favMusic);
		if (favPlaylist != null) userController.addFavoritePlaylist(defaultUser, favPlaylist);
		
		// Testando da função delete e do gerador de ids (deletar e criar uma musica depois)
		// Deleta 2 musicas selecionada
		int id = 1;
		Music selectedMusic = musicController.getMusicById(id); // id da musica criada com o pathSong1
		if (selectedMusic != null ) musicController.deleteMusic(loggedUser, selectedMusic);

		id = 2;
		selectedMusic = musicController.getMusicById(id); // id da musica criada com o pathSong2
		if (selectedMusic != null ) musicController.deleteMusic(loggedUser, selectedMusic);

		musicController.extractMetaData(pathSong1); // Cria uma musica depois de deletar
	
	} // Fim do main

} // Fim da classe
