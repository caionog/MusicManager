package negocio.controllers;

import java.util.Scanner;

import data.UserRepo;
import negocio.User;
import negocio.UserPermission;

public class LoginController {
    
    private String emailInput = "";
    private String passWordInput = "";  
    private String name;
    private int alrightLogin;

    
    public boolean validateInput() { // verifica se os dados do input são validos para acesso.
        return true;
    }


    public void inputEmailAndPassWord() { // trata os dados do input para teste de validação.
        @SuppressWarnings("resource")
        Scanner login = new Scanner(System.in);
        // if (login.hasNextLine()) login.nextLine(); // Esvazia o buffer do teclado
        
        System.out.print("E-mail :");
        this.emailInput = login.nextLine();

        System.out.print("senha :");
        this.passWordInput = login.nextLine();
    }


    public boolean isValidateInput(UserRepo repositorioUser) { // verifica se os dados do input são validos para acesso.
        User login = repositorioUser.searchUserByEmail(this.emailInput);// caso seja encontrado login = usuario caso contratio login = null;
        if (login == null) {// se login == null email nao encontrado.
            System.out.println("email nao encontrado");   
            return false;
        }

        if (login.getPassword().equals(this.passWordInput) ) {
            this.alrightLogin = login.getId();
            return true;
        } else {
            return false; 
        }
    }


    public void newAccount(UserRepo repositorioUser) { // com dados verificados, chama o construtor de user, cara novos usuarios;
        @SuppressWarnings("resource")
        Scanner nameInput = new Scanner(System.in);

        System.out.println("Name :");
        this.name = nameInput.nextLine();

        User newUser = new User(1, UserPermission.NORMAL, emailInput, name, passWordInput);
        repositorioUser.addUser(newUser);
    }


    public User loginNow(UserRepo repositorioUser) {
        return repositorioUser.searchUserById(this.alrightLogin);
    }

    ///////////////////////

    public boolean validadeInput(String emailInput, String passwordInput){
        return true;
    }


    public void editName(){

    }


    public void editpassword(){

    }


    public void editEmail(){

    }


    public void newAccount(){
        
    }

    
    public void saveAccount(String emailInput, String passwordInput){

    }
}
