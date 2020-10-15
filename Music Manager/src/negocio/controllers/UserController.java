package negocio.controllers;

import data.UserRepo;
import negocio.User;
import negocio.interfaces.IUserController;

public class UserController implements IUserController{
    private UserRepo repositorioUsuario = new UserRepo();
    
    
    @Override
    public boolean mudarNome(int usuarioAtual) {
        User usuario = this.repositorioUsuario.getUser(usuarioAtual);
        usuario.
    }

    @Override
    public boolean mudarSenha() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mudarEmail() {
        // TODO Auto-generated method stub
        return false;
    }
  
}
