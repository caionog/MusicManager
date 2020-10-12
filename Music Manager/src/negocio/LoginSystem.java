package negocio;
import data.UserRepo;
import java.util.Scanner;


public class LoginSystem {
    
    private String emailInput;
    private String passWordInput;  
    private String name;
    private int alrightLogin;

    public boolean validateInput() { // verifica se os dados do input são validos para acesso.
        return true;
    }

    public void inputEmailAndPassWord(){// trata os dados do input para teste de validação.
        Scanner login = new Scanner(System.in);
        System.out.println("E-mail :");
        this.emailInput = login.nextLine();
        System.out.println("senha :");
        this.passWordInput = login.nextLine();
        
       
    }

    public boolean isValidateInput(UserRepo repositorioUser){// verifica se os dados do input são validos para acesso.
       User login = repositorioUser.searchUserEmail(this.emailInput);// caso seja encontrado login = usuario caso contratio login = null;
       if(login == null){// se login == null email nao encontrado.
        System.out.println("email nao encontrado");   
        return false;
       }
       if(login.getPasswordUser().equals(this.passWordInput) ){
        this.alrightLogin = login.getUserId();
        return true;
       }
       else{
        
           return false; 
        }
    }

    public void newAccount(UserRepo repositorioUser){// com dados verificados, ira chamar o construtor de user, cara novos usuarios;
        System.out.println("Name :");
        Scanner nameInput = new Scanner(System.in);
        this.name = nameInput.nextLine();
        User newUser = new User(false,emailInput,name,passWordInput);
        repositorioUser.addUser(newUser);
        
    }
    public LoginSystem(){
        this.emailInput = "";
        this.passWordInput = "";
    }
    public User loginNow(UserRepo repositorioUser){
        return repositorioUser.searchUserId(this.alrightLogin);
    }
}

