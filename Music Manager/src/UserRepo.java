import java.util.ArrayList;
import User;

public class UserRepo {
    private ArrayList<User> usuarioUsers;
    usuariosUsers = new arraylist();

    //----------------buscadores-----------------\\
    public User getUserName(String nomeUsuario ){// navega pelo array comparando nome dos usuarios com a String digitada
        int achou = usuarioUsers.size();
        for(int posicao=0;posicao<=achou;posicao++){
        User comparUser = usuarioUsers.get(posicao);
        if (comparUser.getNameUser() == nomeUsuario){
            return comparUser;
        }
        else{return null;}
        }
    }
    public User getUserId(int id ){// navega pelo array comparando nome dos usuarios com a String digitada
        int achou = usuarioUsers.size();
        for(int posicao=0;posicao<=achou;posicao++){
        User comparUser = usuarioUsers.get(posicao);
        if (comparUser.getUserId() == id){
            return comparUser;
        }
        else{return null;}
        }
    }
    public void addUser(User usuario){
        this.usuarioUsers.add(usuario);
    }

    public removeUser(){

    }
}
