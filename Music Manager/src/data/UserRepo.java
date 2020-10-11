package data;

import java.util.ArrayList;

import negocio.User;
public class UserRepo {
    private ArrayList<User> usuarioUsers = new ArrayList<User>();
    

    //----------------buscadores-----------------\\
    public User searchUserName(String nomeUsuario ){// navega pelo array comparando nome dos usuarios com a String digitada
        int achou = usuarioUsers.size();
        for(int posicao=0;posicao<achou;posicao++){
        User comparUser = usuarioUsers.get(posicao);
        if (comparUser.getNameUser() == nomeUsuario){
            return comparUser;
        }
        }
        return null;
    }
    public User searchUserId(int id ){// navega pelo array comparando nome dos usuarios com a String digitada
        int achou = usuarioUsers.size();
        for(int posicao=0;posicao<achou;posicao++){
        User comparUser = usuarioUsers.get(posicao);
        if (comparUser.getUserId() == id){
            return comparUser;
        }
        }
        return null;
    }

    public User searchUserEmail(String emailUser ){// navega pelo array comparando nome dos usuarios com a String digitada
        int achou = usuarioUsers.size();
        for(int posicao=0;posicao<achou;posicao++){
        User comparUser = usuarioUsers.get(posicao);
        if (comparUser.getEmailUser().equalsIgnoreCase(emailUser)== true){
            return comparUser;
        }
        }
        return null;
    }

    public boolean addUser(User usuario){
        usuario.setUserId(this.usuarioUsers.size()+1);
        return this.usuarioUsers.add(usuario);
        
    }

    public boolean removeUser(User usuario){
      return usuarioUsers.remove(usuario);
        
    }
    //------------------construtor---------------//
    public UserRepo(){
        User defaultUSer = new User(false,"default","default","default");
        usuarioUsers.add(defaultUSer);
    }
    public int getSize(){
        return this.usuarioUsers.size();
    }
    public User getUser(int index){
        return this.usuarioUsers.get(index);
    }
}
