
import java.util.Scanner;

public class LoginSystem {
    
    private String emailInput;
    private String passwordInput;


    public void inputEmailAndPassWord(){// trata os dados do input para teste de validação.
        Scanner login = new Scanner(System.in);
        System.out.println("E-mail :");
        this.emailInput = login.nextLine();
        System.out.println("senha :");
        this.passwordInput = login.nextLine();
        //login.close();
       
    }

    public boolean isValidateInput(UserRepo repositorioUser){// verifica se os dados do input são validos para acesso.
       User login = repositorioUser.searchUserEmail(this.emailInput);// caso seja encontrado login = usuario caso contratio login = null;
       if(login == null){// se login == null email nao encontrado.
        System.out.println("email nao encontrado");   
        return false;
       }
       if(login.getPasswordUser() == this.passwordInput){
        System.out.println("im here");
        return false;
       }
       else{
        
           System.out.println("im fuking here yeeea");
           return true; 
        }
    }

    public void newAccount(UserRepo repositorioUser){// com dados verificados, ira chamar o construtor de user, cara novos usuarios;
        User newUser = new User(emailInput,"default",passwordInput);
        repositorioUser.addUser(newUser);
        
    }
    public LoginSystem(){
        this.emailInput = "";
        this.passwordInput = "";
    }
}
