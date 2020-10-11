package negocio;

import java.util.ArrayList;

public class User {
	//Classe que vai informar dados do usu_rio para o cadastro e login
	//e fornercer informacoes necessarias para as outras classes
	private int id;
	private boolean adm;
	private String name;
	private String password;
	private String email;
	
	private ArrayList<Music> favoriteMusics = new ArrayList<>(0);
	private ArrayList<Playlist> favoritePlaylists = new ArrayList<>(0);
	
	
	public User(Boolean adm, String email, String name, String password) {
	
		this.adm = adm;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	//---------------------getters-----------------//

	public String getNameUser(){
		return this.name;
	}
	public String getPasswordUser(){
		return this.password;
	}
	public String getEmailUser(){
		return this.email;
	}
	public int getUserId(){
		return this.id;
	}
//----------------------setters------------------//
	public void setNameUser(String newNameUser){
		this.name = newNameUser;
	}

	public void setPasswordUser(String newPasswordUser){
		this.password = newPasswordUser;
	}
	public void setEmailUser(String newEmailUser){
		this.email = newEmailUser;
	}
	public void setUserId(int newUserId){
		this.id = newUserId;
	}


//--------------------metodos-------------------\\
	public void modifyUser() 
	{
		
	}
	public String toString() 
	{
		//nao mostrar senha
		return "ID: "+ this.id + "\n" + this.email +"\n"+ this.name + "\n" + "ADM: " + this.adm;
	}
}
