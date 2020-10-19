package negocio.controllers;

import java.io.IOException;
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
        // caso seja encontrado login = usuario caso
        // contratio login = null;
        User login = repositorioUser.searchUserByEmail(this.emailInput);
        
        if (login == null) {// se login == null email nao encontrado.
            System.out.println("email nao encontrado");
            return false;
        }

        if (login.getPassword().equals(this.passWordInput)) {
            this.alrightLogin = login.getId();
            return true;
        } else {
            return false;
        }
    }

    public void newAccount(UserRepo repositorioUser) throws IOException {
        // com dados verificados, chama o construtor
        // de user, para novos usuarios;
        @SuppressWarnings("resource")
        Scanner nameInput = new Scanner(System.in);

        System.out.print("Name :");
        this.name = nameInput.nextLine();

        UserPermission permission = UserPermission.NORMAL; //TO-DO Alterar para input do usuário

        repositorioUser.createUser(permission, emailInput, name, passWordInput);
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
