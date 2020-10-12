package data;

import java.util.ArrayList;

import negocio.User;
public class UserRepo {
    private ArrayList<User> usuarioUsers = new ArrayList<User>();
    private int IDs;
    private int IdRemovido;
    

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
        this.IDs++;
        usuario.setUserId(this.IDs);
        return this.usuarioUsers.add(usuario);
        
    }

    public boolean removeUser(User usuario){
      this.IdRemovido = usuario.getUserId();
        return usuarioUsers.remove(usuario);
        
    }
    public void refreshList(int IdRemovido){
        int achou = usuarioUsers.size();
        for(int posicao = IdRemovido-1; posicao < achou; posicao++ ){
            User usuario = this.usuarioUsers.get(posicao);
           usuario.setUserId( usuario.getUserId() - 1 );
        }
        }
    
    //------------------construtor---------------//
    public UserRepo(){
        User defaultUSer = new User(false,"default","","");
        usuarioUsers.add(defaultUSer);
    }
    public int getSize(){
        return this.usuarioUsers.size();
    }
    public User getUser(int index){
        return this.usuarioUsers.get(index);
    }
}
