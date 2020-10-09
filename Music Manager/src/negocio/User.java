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
	
	
	public User(int id, Boolean adm, String name, String password, String email) {
		this.id = id;
		this.adm = adm;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public String toString() 
	{
		//nao mostrar senha
		return "ID: "+ this.id + "\n" + this.email +"\n"+ this.name + "\n" + "ADM: " + this.adm;
	}
}
