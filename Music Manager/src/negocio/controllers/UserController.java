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


    public Boolean handleUserRegister(UserPermission permission, String email, String name, String password) throws IOException {
    	
        // Checa se o email e nome estão no formato correto
        if ( email.indexOf('@') == -1 ) { 
            System.out.println("Email inválido! Problema: email não possui @");
            return false;
        }
        
        if ( name.indexOf('@') != -1 ) {
            System.out.println("Nome inválido! Problema: nome possui @");
            return false;
        }

    	// Checa se o email já foi utilizado por outro user
        ArrayList<String> emails = userRepoInstance.getEmails();
        
        for (String eachEmail : emails) {
			if ( email.equalsIgnoreCase(eachEmail) ) {
                System.out.println("Email inválido! problema: email já está cadastrado");
                return false;
			}
		}

        // Checa se o name já foi utilizado por outro user
        ArrayList<String> names = userRepoInstance.getNames();
        
        for (String eachName : names) {
			if ( name.equalsIgnoreCase(eachName) ) {
				System.out.println("Nome inválido! problema: nome já está cadastrado");
				return false;
			}
		}
        
        // Se passar nos 4 testes, então retorna true e registra o user
        registerUser(permission, email, name, password);
        return true;
    }

    
    private void registerUser(UserPermission userPermission, String email, String name, String password) throws IOException {
        userRepoInstance.createUser(userPermission, email, name, password);
    }
    
    
    public boolean handleUserLogin(String nameOrEmail, String password) {

        Boolean nameOrEmailExist = false, passwordExist = false;

        // Explora e verifica os emails
        for (String email : userRepoInstance.getEmails()) {
            if (nameOrEmail.equalsIgnoreCase(email)) {
                nameOrEmailExist = true;
                break;
            }
        }

        // Explora e verifica os nomes caso não encontre um email
        if ( !nameOrEmailExist ) {
            for (String name : userRepoInstance.getNames()) {
                if (nameOrEmail.equalsIgnoreCase(name)) {
                    nameOrEmailExist = true;
                    break;
                }
            }
        }

        // Explora e verfica as senhas se encontrou um email ou nome
        if (nameOrEmailExist) {
            for (String eachPassword : userRepoInstance.getPasswords()) {
                if ( password.equals(eachPassword) ) {
                    passwordExist = true;
                    break;
                }
            }
        }


        if (nameOrEmailExist && passwordExist) {
            // TODO Faz login
        	return true;
        }
        else 
        {
        	System.out.println("Nao existe");
        	return false;
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


    public void modifyUser(User loggedUser, String newName, String newPassword, String newEmail) {
        if (newEmail != "") loggedUser.setEmail(newEmail);
        
		if (newName != "") loggedUser.setName(newName);

		if (newPassword != "") loggedUser.setPassword(newPassword);
	}
    
    
    public User getUserByIndex(int index) {
		return userRepoInstance.getUserByIndex(index);
	}
}
