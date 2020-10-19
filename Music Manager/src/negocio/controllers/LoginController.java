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

    public void registerUser(UserRepo repositorioUser, String email, String name, String password, UserPermission permission)
            throws IOException {

        Boolean successfulValidation = validateInput();


        if ( successfulValidation ) {
            repositorioUser.createUser(permission, email, name, password);
        }
    }


    private boolean validateInput() { // verifica se os dados do input são validos para acesso
        return true;
    }

    
    public void handleUserRegister() { // trata os dados do input para teste de validação.
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


    public User handleUserLogin(UserRepo repositorioUser) {
        return repositorioUser.searchUserById(this.alrightLogin);
    }

    ///////////////////////
    
    public void saveAccount(String emailInput, String passwordInput){

    }
}
