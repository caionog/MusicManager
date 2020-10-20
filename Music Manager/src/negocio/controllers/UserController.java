package negocio.controllers;

import java.io.IOException;

import data.MusicRepo;
import data.PlaylistRepo;
import data.UserRepo;
import negocio.Music;
import negocio.Playlist;
import negocio.User;
import negocio.UserPermission;

public class UserController {

    private UserRepo userRepo;

    public UserController() {
        this.userRepo = UserRepo.getInstance(); 
    }


    public void handleUserLogin(String nameOrEmail, String password) {

        Boolean flag = false;

        // Explora os emails
        for (String email : userRepo.getEmails()) {
            if (nameOrEmail.equalsIgnoreCase(email)) {
                flag = true;
                break;
            }
        }

        // Explora os nomes caso não encontre um email
        if (flag == false) {
            for (String name : userRepo.getEmails()) {
                if (nameOrEmail.equalsIgnoreCase(name)) {
                    flag = true;
                    break;
                }
            }
        }



        
    }


    public void handleUserRegister(String email, String name, String password, UserPermission permission) {
        // Checa se o email já foi utilizado por outro user
        

        // Checa se o name já foi utilizado por outro user
    }


    public void registerUser(UserRepo userRepo, UserPermission userPermission, String email, String name, String password)
            throws IOException {
        userRepo.createUser(userPermission, email, name, password);
    }


    public void populateUsersRepo(UserRepo userRepo, MusicRepo musicRepo, PlaylistRepo playlistRepo)
            throws IOException {
        userRepo.populateUserRepo(musicRepo, playlistRepo);
    }
    

    public void addFavoriteMusic(UserRepo userRepo, User u, Music m) throws IOException {
        u.addFavMusic(m);

        userRepo.updateUserFavoriteMusics(u.getId(), m.getId() );
    }
    

    public void addFavoritePlaylist(UserRepo userRepo, User u, Playlist p) throws IOException {
        u.addFavPlaylist(p);

        userRepo.updateUserFavoritePlaylists(u.getId(), p.getId() );
    }


    public void editUser(String[] stringsToChange) {


    }


    public boolean editNome(int usuarioAtual) {
        // User usuario = this.repositorioUsuario.getUser(usuarioAtual);
        // usuario.

        return false;
    }


    public boolean mudarSenha() {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean mudarEmail() {
        // TODO Auto-generated method stub
        return false;
    }


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


    public boolean isValidateInput(UserRepo repositorioUser) { // verifica se os dados do input são validos para acesso.
        // caso seja encontrado login = usuario caso
        // contratio login = null;
        // User login = repositorioUser.searchUserByEmail(this.emailInput);
        
        // if (login == null) {// se login == null email nao encontrado.
        //     System.out.println("email nao encontrado");
        //     return false;
        // }

        // if (login.getPassword().equals(this.passWordInput)) {
        //     this.alrightLogin = login.getId();
        //     return true;
        // } else {
        //     return false;
        // }

        return true;
    }
}
