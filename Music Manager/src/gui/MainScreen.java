package gui;

import java.util.Scanner;
import negocio.LoginSystem;
import negocio.User;
import data.UserRepo;

public class MainScreen {
	public static void main(String[] args) {
		System.out.println(" ('¬')_Ll Loading Program... ");
		
		User defaultUser = new User(false,"maria@gmail.com","Maria Ferreira" , "123456");
		UserRepo repositorioUser = new UserRepo();
		repositorioUser.addUser(defaultUser);
		LoginSystem login = new LoginSystem();
		login.inputEmailAndPassWord();
		login.newAccount(repositorioUser);
		
		
	
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
	}
}