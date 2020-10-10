
public class User {
	//Classe que vai informar dados do usu�rio para o cadastro e login
	//e fornercer informa��es necess�rias para as outras classes
	private String nameUser;
	private String passwordUser;
	private String emailUser;
	private boolean adm;
	private int id;
	
	//------- construtor de uuario que será usado em "criar conta" pagina de login;
	public User(String emailUser, String nameUser,String passwordUSer) {
		this.adm = false;
		this.emailUser = emailUser;
		this.nameUser = nameUser;
		this.passwordUser = passwordUSer;
		
	}
	//---------------------getters-----------------//

	public String getNameUser(){
		return this.nameUser;
	}
	public String getPasswordUser(){
		return this.passwordUser;
	}
	public String getEmailUser(){
		return this.emailUser;
	}
	public int getUserId(){
		return this.id;
	}
//----------------------setters------------------//
	public void setNameUser(String newNameUser){
		this.nameUser = newNameUser;
	}

	public void setPasswordUser(String newPasswordUser){
		this.passwordUser = newPasswordUser;
	}
	public void setEmailUser(String newEmailUser){
		this.emailUser = newEmailUser;
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
		return this.emailUser +"\n"+ this.nameUser + "\n"+ this.adm;
	}
	

}
