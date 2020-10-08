import java.util.ArrayList;
import User;

public class UserRepo {
    private ArrayList<User> usuarioUsers;
    usuariosUsers = new arraylist();

    public User getUSer(String nomeUsuario ){// navega pelo array comparando nome dos usuarios com a String digitada
        int achou = usuarioUsers.size();
        for(int posicao=0;posicao<=achou;posicao++){
        User comparUser = usuarioUsers.get(posicao);
        if (comparUser.getNameUser() == nomeUsuario){
            return comparUser;
        }
        
        }
    }
    public void addUser(User usuario){
        this.usuarioUsers.add(usuario);
    }
    public removeUser(){

    }
}
