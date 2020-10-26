package negocio.controllers;

import java.io.IOException;
import java.util.ArrayList;

import data.MusicRepo; // Repositórios
import data.PlaylistRepo;
import data.UserRepo;

import negocio.Music; // Classes base
import negocio.Playlist;
import negocio.User;

import negocio.UserPermission; // Enum

public class UserController {

    private UserRepo userRepoInstance = UserRepo.getInstance();
    
    private PlaylistRepo playlistRepoInstance = PlaylistRepo.getInstance();
    private MusicRepo musicRepoInstance = MusicRepo.getInstance();


    public void resetRepo() {
    	userRepoInstance.resetRepo();
    }


    public void populateUsersRepo() throws IOException {
        userRepoInstance.populateUserRepo(musicRepoInstance, playlistRepoInstance);
    }


    public void handleUserRegister(UserPermission permission, String email, String name, String password) throws IOException {
        
    	Boolean emailAlreadyExist = false;
    	Boolean nameAlreadyExist = false;
    	
    	// TODO Checa se existe um @ no email e não existe um @ no name ( caracter que diferencia email de nome )
    	
    	
    	// Checa se o email já foi utilizado por outro user
        ArrayList<String> emails = userRepoInstance.getEmails();
        
        for (String eachEmail : emails) {
			if ( email.equalsIgnoreCase(eachEmail) ) {
				emailAlreadyExist = true;
				break;
			}
		}
        

        // Checa se o name já foi utilizado por outro user
        ArrayList<String> names = userRepoInstance.getNames();
        
        for (String eachName : names) {
			if ( name.equalsIgnoreCase(eachName) ) {
				nameAlreadyExist = true;
				break;
			}
		}
        
        if ( emailAlreadyExist || nameAlreadyExist ) {
        	// Não cria conta
        } else {
        	registerUser(permission, email, name, password);
        }
    }

    
    private void registerUser(UserPermission userPermission, String email, String name, String password) throws IOException {
        userRepoInstance.createUser(userPermission, email, name, password);
    }
    
    
    public void handleUserLogin(String nameOrEmail, String password) {

        Boolean exist = false;

        // Explora os emails
        for (String email : userRepoInstance.getEmails()) {
            if (nameOrEmail.equalsIgnoreCase(email)) {
                exist = true;
                break;
            }
        }

        // Explora os nomes caso não encontre um email
        if ( !exist ) {
            for (String name : userRepoInstance.getEmails()) {
                if (nameOrEmail.equalsIgnoreCase(name)) {
                    exist = true;
                    break;
                }
            }
        }

        if (exist) {
        	// TODO Faz login
        }
    }
    

    public void addFavoriteMusic(User u, Music m) throws IOException {
    	
        u.addFavMusic(m);
        userRepoInstance.updateUserFavoriteMusics(u.getId(), m.getId() );
    }
    

    public void addFavoritePlaylist(User u, Playlist p) throws IOException {
    	
        u.addFavPlaylist(p);
        userRepoInstance.updateUserFavoritePlaylists(u.getId(), p.getId() );
    }


    public void editUser(String[] stringsToChange) {


    }


    public boolean editNome(int usuarioAtual) {
        // User usuario = userRepoInstance.getUser(usuarioAtual);
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


    public boolean isValidateInput() { // verifica se os dados do input são validos para acesso.
    	
    	// // Função antiga que nem sei se pode apagar, então comentei // //
    	
        // caso seja encontrado login = usuario caso
        // contratio login = null;
        // User login = userRepoInstance.searchUserByEmail(this.emailInput);
        
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
    
    
    public User getUserByIndex(int index) {
		return userRepoInstance.getUserByIndex(index);
	}
}
