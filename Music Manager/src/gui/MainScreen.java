package gui;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import negocio.LoginSystem;
import negocio.Music;
import negocio.User;

import data.MusicRepo;
import data.PlaylistRepo;
import data.UserRepo;

import negocio.controllers.MusicController;
import negocio.controllers.PlaylistController;
public class MainScreen {
	
	public static void main(String[] args) throws IOException, SAXException, TikaException, Exception {

		System.out.println(" ('¬')_Ll Loading Program... ");

		// Instanciando o básico para inicializar o sistema
		User loggedUser = new User(1, true, "logged@gmail.com", "usuário de teste", "1234");

		MusicRepo mRepo = new MusicRepo();
		PlaylistRepo pRepo = new PlaylistRepo();

		MusicController mController = new MusicController();
		PlaylistController pController = new PlaylistController();

		// _Visibility v = Enum.valueOf(_Visibility.class, "INVISIBLE"); // Somente usado em criação de playlist

		// Simulando o input do path duma música
		String mp3StoragePath = "Music Manager\\src\\data\\mp3 storage\\";
		String pathSong = mp3StoragePath + "GD\\BackOnTrack" + ".mp3";
		String pathSong2 = mp3StoragePath + "hey-jude" + ".mp3";
		String pathSong3 = mp3StoragePath + "GD\\53576" + ".mp3";
		
		// Simulando a extração de dados e criação da Music no repositório de musicas com base no input path
		mController.extractMetaData(mRepo, pathSong);
		mController.extractMetaData(mRepo, pathSong2);
		mController.extractMetaData(mRepo, pathSong3);
		
		Music backOnTrack = mRepo.getMusic(0);
		Music heyJude = mRepo.getMusic(1);
		Music guitarVSpiano = mRepo.getMusic(2);

		System.out.println("Resultado da simulação de criar música: \n" + backOnTrack.toString() );
		System.out.println("Resultado da simulação de criar música: \n" + heyJude.toString() );
		System.out.println("Resultado da simulação de criar música: \n" + guitarVSpiano.toString() );

		ArrayList<Music> selectedMusic = new ArrayList<Music>(); 
		selectedMusic.add(backOnTrack);
		selectedMusic.add(heyJude);
		selectedMusic.add(guitarVSpiano);

		pController.groupSelectedMusic(pRepo, selectedMusic, loggedUser);

		mController.printMetadata(pathSong);
		mController.printMetadata(pathSong2);
		mController.printMetadata(pathSong3);

		// mController.printSummary(pathSong);
		// mController.printSummary(pathSong2);
		// mController.printSummary(pathSong3);

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
