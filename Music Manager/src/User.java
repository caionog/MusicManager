
public class User {
	//Classe que vai informar dados do usu�rio para o cadastro e login
	//e fornercer informa��es necess�rias para as outras classes
	private String nameUser;
	private String passwordUser;
	private String emailUser;
	private boolean adm;
	
	
	public void creatUser() 
	{
		
		
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
