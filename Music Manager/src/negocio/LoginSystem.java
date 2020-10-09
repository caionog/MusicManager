package negocio;

import java.util.Scanner;


public class LoginSystem {
    
    private String emailInput;
    private String passWordInput;  

    public void inputEmailAndPassWord() { // trata os dados do input para teste de validação.
        Scanner email = new Scanner(System.in);

        email.close(); // Corrige o warning de Resource leak
    }

    public boolean validateInput() { // verifica se os dados do input são validos para acesso.
        return true;
    }

}
