package gui;

import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import negocio.LoginSystem;

import negocio.User;

import data.MusicRepo;
import data.PlaylistRepo;
import data.UserRepo;

import negocio.controllers.MusicController;
public class MainScreen {
	
	public static void main(String[] args) throws IOException, SAXException, TikaException, Exception {

		System.out.println(" ('¬')_Ll Loading Program... ");

		// Instanciando o básico para inicializar o sistema
		User loggedUser = new User(1, true, "logged@gmail.com", "usuário de teste", "1234");

		MusicRepo mRepo = new MusicRepo();
		PlaylistRepo pRepo = new PlaylistRepo();

		MusicController mController = new MusicController();

		// _Visibility v = Enum.valueOf(_Visibility.class, "INVISIBLE"); // Somente usado em criação de playlist

		// Simulando o input do path duma música
		String mp3StoragePath = "Music Manager\\src\\data\\mp3 storage\\";
		String pathSong = mp3StoragePath + "GD\\BackOnTrack" + ".mp3";
		
		// Simulando a extração de dados e criação da Music no repositório de musicas com base no input path
		mController.extractMetaData(mRepo, pathSong);
		
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
