package gui;

import java.util.ArrayList;

import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;


import negocio.LoginSystem;
import negocio.Music;
import negocio.User;
import data.UserRepo;

import negocio.Genre;
import negocio._Visibility;
public class MainScreen {
	
	public static void main(String[] args) throws IOException, SAXException, TikaException, Exception {

		String mp3StoragePath = "Music Manager\\src\\data\\mp3 storage\\GD\\";
		String pathSong = mp3StoragePath + "BackOnTrack" + ".mp3";
		
		Boolean teste = true;
		_Visibility v = Enum.valueOf(_Visibility.class, "VISIBLE");
		Genre g = Enum.valueOf(Genre.class, "ELETRONIC");
		ArrayList<Genre> genres = new ArrayList<Genre>();

		System.out.println(" ('¬')_Ll Loading Program... ");
		
		if (teste) {
			Music m = new Music(1, "title", "artist", genres, "summary", "metaData");
			m.createMusic(pathSong);
			m.addGenre(g);
			System.out.println( m.toString() );

		} else {
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
