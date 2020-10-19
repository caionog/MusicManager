package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import negocio.UserPermission; // Enum

import negocio.Music; // Classes base
import negocio.Playlist;
import negocio.User;

import data.MusicRepo; // Repositorios
import data.PlaylistRepo;
import data.UserRepo;

import negocio.controllers.LoginController; // Controladores
import negocio.controllers.MusicController;
import negocio.controllers.PlaylistController;
import negocio.controllers.UserController;

public class MainScreen {

	public static void main(String[] args) throws IOException, SAXException, TikaException, Exception {

		System.out.println("[ ('¬')_Ll Loading Program... ]");

		// Instanciando o básico para inicializar o sistema

		LoginController login = new LoginController();
		UserController userController = new UserController();
		MusicController musicController = new MusicController();
		PlaylistController playlistController = new PlaylistController();

		MusicRepo musicRepo = new MusicRepo();
		//musicRepo.resetRepo();
		musicController.populateMusicLibrary(musicRepo); // Preenche o array com as musicas ja guardas nos .txt

		PlaylistRepo playlistRepo = new PlaylistRepo();
		//playlistRepo.resetRepo();
		playlistController.populatePlaylistLibrary(playlistRepo, musicRepo);

		UserRepo userRepo = new UserRepo();
		//userRepo.resetRepo();
		userController.populateUsersRepo(userRepo, musicRepo, playlistRepo);

		////// Inicio dos teste  //////

		// Criando 2 usuarios
		userController.registerUser(userRepo, UserPermission.NORMAL, "maria@gmail.com", "Maria Ferreira", "123456");
		userController.registerUser(userRepo, UserPermission.ADM, "logged@gmail.com", "usuário de teste", "1234");
		
		User defaultUser = userRepo.getUserByIndex(0);
		User loggedUser = userRepo.getUserByIndex(1);


		// Simulando o input do path duma música
		String mp3StoragePath = "Music Manager\\src\\data\\mp3 storage\\";
		String pathSong1 = mp3StoragePath + "GD\\BackOnTrack" + ".mp3";
		String pathSong2 = mp3StoragePath + "hey-jude" + ".mp3";
		String pathSong3 = mp3StoragePath + "GD\\53576" + ".mp3";
		String pathSong4 = mp3StoragePath + "Transistor\\Darren Korb - She Shines" + ".mp3";
		String pathSong5 = mp3StoragePath + "ADOFAI\\The Midnight Train" + ".mp3";

		// Simulando a criação da Music no repositório de musicas com base no input path
		musicController.extractMetaData(musicRepo, pathSong1);
		// musicController.extractMetaData(musicRepo, pathSong2);
		// musicController.extractMetaData(musicRepo, pathSong3);
		// musicController.extractMetaData(musicRepo, pathSong4);
		// musicController.extractMetaData(musicRepo, pathSong5);

		// Simulando a criação de playlists
		ArrayList<Music> selectedMusics = new ArrayList<Music>(2);
		for (Music music : musicRepo.getMusicLibrary()) {
			if (selectedMusics.size() < 2) {
				selectedMusics.add(music);
			}
		}

		playlistController.groupSelectedMusic(playlistRepo, selectedMusics, defaultUser);

		ArrayList<Music> selectedMusics2 = new ArrayList<Music>(2);
		for (Music music : musicRepo.getMusicLibrary()) {
			if (selectedMusics2.size() < 2) {
				selectedMusics2.add(music);
			}
		}

		// playlistController.groupSelectedMusic(playlistRepo, selectedMusics2, defaultUser);

		// Alterando visibilidade da playlist
		Playlist selectedPlaylist = playlistRepo.getPlaylistsLibrary().get(0);
		playlistController.togglePlaylistVisibility(playlistRepo, selectedPlaylist);
			
		// Adicionando musicas e playlists favoritas no loggedUser
		Music favMusic = musicRepo.getMusicById(3);
		Playlist favPlaylist = playlistRepo.getPlaylistByIndex(0);

		if (favMusic != null) userController.addFavoriteMusic(userRepo, defaultUser, favMusic);
		if (favPlaylist != null) userController.addFavoritePlaylist(userRepo, defaultUser, favPlaylist);
		
		// Testando a geração de ids (deletar e criar uma musica depois) + teste da função delete music
		// Deleta 2 musicas selecionada
		int id = 1;
		Music selectedMusic = musicRepo.getMusicById(id); // id da musica criada com o pathSong1
		if (selectedMusic != null ) musicController.deleteMusic(loggedUser, musicRepo, playlistRepo, userRepo, selectedMusic);

		id = 2;
		selectedMusic = musicRepo.getMusicById(id); // id da musica criada com o pathSong2
		if (selectedMusic != null ) musicController.deleteMusic(loggedUser, musicRepo, playlistRepo, userRepo, selectedMusic);

		// musicController.extractMetaData(musicRepo, pathSong1); // Cria uma musica depois de deletar
		
		System.out.println("-------criando conta------");
		
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

        System.out.print("E-mail :"); String email = input.nextLine();

        System.out.print("senha :"); String password = input.nextLine();

        System.out.print("Name :"); String name = input.nextLine();

		input.close();

		UserPermission permission = UserPermission.NORMAL;
		
		login.registerUser(userRepo, email, name, password, permission);
		login.handleUserLogin(userRepo);
		login.handleUserRegister();
		// login.newAccount(userRepo);
		System.out.println("dados salvos");
		// System.out.println("userRepo size: " + userRepo.getSize());
		// System.out.println(userRepo.getUserByIndex(0).getEmail());
		// System.out.println(userRepo.getUserByIndex(1).getEmail());
		// System.out.println(userRepo.getUserByIndex(2).getEmail());
		// System.out.println("UserRepo size: " + userRepo.getSize());
		// defaultUser.setNameUser("Jorge");
		// System.out.println("To string do user Jorge: \n" + userRepo.searchUserByName("Jorge").toString());
		// System.out.println("isso aqui; " + userRepo.searchUserByEmail("murilo@gmail.com"));
		// System.out.println("To string do user murilo@gamil.com: \n" + userRepo.searchUserByEmail("murilo@gmail.com"));


		System.out.println("-------testando login------");
		login.handleUserLogin(userRepo);
		boolean validate = login.isValidateInput(userRepo);
		System.out.println(validate);
		if(validate==true) {
			System.out.println(" bem vindo");

		} else {
			System.out.println("email invalido ou senha incorreta");
		}
	
	} // Fim do main
	
} // Fim da classe
