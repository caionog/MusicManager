package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import negocio.LoginSystem;
import negocio.Music;
import negocio.Playlist;
import negocio.User;
import data.MusicRepo;
import data.PlaylistRepo;
import data.UserRepo;

import negocio.controllers.MusicController;
import negocio.controllers.PlaylistController;

public class MainScreen {

	public static void main(String[] args) throws IOException, SAXException, TikaException, Exception {

		System.out.println("[ ('¬')_Ll Loading Program... ]");

		// Instanciando o básico para inicializar o sistema
		User loggedUser = new User(1, true, "logged@gmail.com", "usuário de teste", "1234");

		MusicController musicController = new MusicController();
		PlaylistController playlistController = new PlaylistController();

		MusicRepo musicRepo = new MusicRepo();
		musicRepo.resetRepo();
		musicController.populateMusicLibrary(musicRepo); // Preenche o array com as musicas ja guardas nos .txt

		PlaylistRepo playlistRepo = new PlaylistRepo();
		playlistRepo.resetRepo();
		playlistController.populatePlaylistLibrary(playlistRepo, musicRepo);

		// Simulando o input do path duma música
		String mp3StoragePath = "Music Manager\\src\\data\\mp3 storage\\";
		String pathSong1 = mp3StoragePath + "GD\\BackOnTrack" + ".mp3";
		String pathSong2 = mp3StoragePath + "hey-jude" + ".mp3";
		String pathSong3 = mp3StoragePath + "GD\\53576" + ".mp3";
		String pathSong4 = mp3StoragePath + "Transistor\\Darren Korb - She Shines" + ".mp3";
		String pathSong5 = mp3StoragePath + "ADOFAI\\The Midnight Train" + ".mp3";

		// Simulando a criação da Music no repositório de musicas com base no input path
		musicController.extractMetaData(musicRepo, pathSong1);
		musicController.extractMetaData(musicRepo, pathSong2);
		musicController.extractMetaData(musicRepo, pathSong3);
		musicController.extractMetaData(musicRepo, pathSong4);
		musicController.extractMetaData(musicRepo, pathSong5);

		// Testando a geração de ids (deletar e criar uma musica depois)
		int id = 1;
		Music selectedMusic = musicRepo.getMusicById(id); // id da musica criada com o pathSong1
		musicController.deleteMusic(musicRepo, selectedMusic); // Deleta uma musica
		musicController.extractMetaData(musicRepo, pathSong1); // Cria uma musica depois de deletar

		// Simulando a criação de playlists
		ArrayList<Music> selectedMusics = new ArrayList<Music>(2);
		for (Music music : musicRepo.getMusicLibrary()) {
			if (selectedMusics.size() < 2) {
				selectedMusics.add(music);
			}
		}

		playlistController.groupSelectedMusic(playlistRepo, selectedMusics, loggedUser);

		// Alterando visibilidade da playlist
		Playlist selectedPlaylist = playlistRepo.getPlaylistsLibrary().get(0);
		playlistController.togglePlaylistVisibility(playlistRepo, selectedPlaylist);

		// Print do resultado da criação e troca de visibilidade da playlist
		System.out.println(selectedPlaylist.toString());

		Boolean testarLogin = false;

		if (testarLogin) {
			User defaultUser = new User(1, false,"maria@gmail.com","Maria Ferreira" , "123456");
			UserRepo repositorioUser = new UserRepo();
			repositorioUser.addUser(defaultUser);
			LoginSystem login = new LoginSystem();
			
			System.out.println("-------criando conta------");
			login.inputEmailAndPassWord();
			login.newAccount(repositorioUser);
			System.out.println("dados salvos");
			System.out.println(repositorioUser.getSize());
			System.out.println(repositorioUser.getUser(0).getEmailUser());
			System.out.println(repositorioUser.getUser(1).getEmailUser());
			System.out.println(repositorioUser.getUser(2).getEmailUser());
			System.out.println(repositorioUser.getSize());
			defaultUser.setNameUser("Jorge");
			System.out.println(repositorioUser.searchUserName("Jorge"));
			System.out.println("isso aqui; "+ repositorioUser.searchUserEmail("murilo@gmail.com"));
			System.out.println(repositorioUser.searchUserEmail("murilo@gmail.com"));


			System.out.println("-------testando login------");
			login.inputEmailAndPassWord();
			boolean validate = login.isValidateInput(repositorioUser);
			System.out.println(validate);
			if(validate==true) {
				System.out.println(" bem vindo");

			} else {
				System.out.println("email invalido ou senha incorreta");
			}

		} // Fim do if de teste
	
	} // Fim do main
	
} // Fim da classe
