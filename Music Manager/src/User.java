
public class User {
	//Classe que vai informar dados do usu�rio para o cadastro e login
	//e fornercer informa��es necess�rias para as outras classes
	private String nameUser;
	private String passwordUser;
	private String emailUser;
	private boolean adm;
	private int id;
	
	//------- construtor de uuario que será usado em "criar conta" pagina de login;
	public void creatUser(String emailUser, String nameUser,String passwordUSer) {
		this.adm = false;
		this.emailUser = emailUser;
		this.nameUser = nameUser;
		this.passwordUser = passwordUSer;
		//adicionar id aqui;
	}
	
	public void modifyUser() 
	{
		
	}
	
	public String toString() 
	{
		//nao mostrar senha
		return this.emailUser +"\n"+ this.nameUser + "\n"+ this.adm;
	}
	
	

}
