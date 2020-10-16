package gui;
import java.util.ArrayList;

import java.io.IOException;
import java.util.Scanner;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.microsoft.SummaryExtractor;
import org.xml.sax.SAXException;

import negocio.LoginSystem;
import negocio.Music;
import negocio.Playlist;
import negocio.User;
import data.UserRepo;


public class MainScreen {
	
	public static void main(String[] args) throws IOException, SAXException, TikaException, Exception {
		
		System.out.println("teste");
		String path ="hey-jude.mp3";
		Music musica1 = new Music();
		musica1.CreatMusic(path);
		System.out.println("O caminho da musica de ID "+musica1.getIdSong()+" é: "+musica1.getPathSong());
		System.out.println("As informações da muisca de ID " + musica1.getIdSong()+" são: ");
		musica1.printSummary(musica1.getPathSong());
	

		
		
		Music musica2 = new Music();
		path = "nerdcast_746_relacoes_publicas_med.mp3";
		musica2.CreatMusic(path);
		System.out.println("O caminho da musica de ID "+musica2.getIdSong()+" é: "+musica2.getPathSong());
		System.out.println("As informações da muisca de ID " + musica2.getIdSong()+" são: ");
		musica2.printSummary(musica2.getPathSong());
	
		Music musica3 = new Music();
		path = "bensound-acousticbreeze.mp3";
		musica3.CreatMusic(path);
		System.out.println("O caminho da musica de ID "+musica3.getIdSong()+" é: "+musica3.getPathSong());
		System.out.println("As informações da muisca de ID " + musica3.getIdSong()+" são: ");
		musica2.printSummary(musica3.getPathSong());

		
	//	System.out.println("O caminho da musica de ID "+musica1.getIdSong()+" é: "+musica1.getPathSong());

		
	    //musica1.printMetadata(pathSong);
	    //musica1.printSummary(pathSong);
	    //System.out.println(musica1.getTitleSong());
		
	
		
		
	//	System.out.println(" ('Â¬')_Ll Loading Program... ");
		
	//	User defaultUser = new User(false,"maria@gmail.com","Maria Ferreira" , "123456");
		//CRIAR BIBLIOTECA QUE VAI ARMAZENAR TODAS AS MUSICAS
	//	Playlist library = new Playlist();
		//ADICIONAR MUSICA A BIBLIOTECA
	//	library.addMusicLibrary(musica1);
		
		//CRIAR PLAYLIST DO USUARIO 
	//	/Playlist userPlaylist1 = new Playlist(defaultUser);
	//	userPlaylist1.toString();
		/*
		
		
		UserRepo repositorioUser = new UserRepo();
		repositorioUser.addUser(defaultUser);
		LoginSystem login = new LoginSystem();
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
		if(validate==true){
			System.out.println(" bem vindo");

		}
		else{
			System.out.println("email invalido ou senha incorreta");
	}
	*/
	}
	
}