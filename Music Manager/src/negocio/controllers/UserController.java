package negocio.controllers;

import java.io.IOException;
import java.util.ArrayList;

import data.MusicRepo; // Repositórios
import data.PlaylistRepo;
import data.UserRepo;

import negocio.beans.Music; // Classes base
import negocio.beans.Playlist;
import negocio.beans.User;

import negocio.beans.UserPermission; // Enum

import negocio.interfaces.IUserRepo; // Interface

public class UserController {

    private IUserRepo userRepoInstance = UserRepo.getInstance();
    
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
        for (String eachEmail : userRepoInstance.getEmails()) {
			if ( email.equalsIgnoreCase(eachEmail) ) {
                System.out.println("Email inválido! problema: email já está cadastrado");
                return false;
			}
		}

        // Checa se o name já foi utilizado por outro user
        for (String eachName : userRepoInstance.getNames()) {
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
    
    
    public User handleUserLogin(String nameOrEmail, String password) {

        Boolean nameOrEmailExist = false, passwordExist = false;
        int i = 0, j = 0;

        // Explora e verifica os emails
        for (String email : userRepoInstance.getEmails()) {
            i++;
            if (nameOrEmail.equalsIgnoreCase(email)) {
                nameOrEmailExist = true;
                break;
            }
        }

        // Explora e verifica os nomes caso não encontre um email
        if ( !nameOrEmailExist ) {
            i = 0;
            for (String name : userRepoInstance.getNames()) {
                i++;
                if (nameOrEmail.equalsIgnoreCase(name)) {
                    nameOrEmailExist = true;
                    break;
                }
            }
        }

        // Explora e verfica as senhas se encontrou um email ou nome
        if (nameOrEmailExist) {
            for (String eachPassword : userRepoInstance.getPasswords()) {
                j++;
                if ( password.equals(eachPassword) && (i == j) ) {
                    passwordExist = true;
                    break;
                }
            }
        }


        if ( nameOrEmailExist && passwordExist ) {
            return userRepoInstance.getUserByIndex(i-1);
        }
        else 
        {
        	System.out.println("Nao existe");
        	return null;
        }
    }
    

    public void addFavoriteMusic(User u, Music m) {
        try {
            userRepoInstance.updateUserFavoriteMusics(u.getId(), m.getId(), true);
            u.addFavMusic(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void addFavoritePlaylist(User u, Playlist p) {
        try {
            userRepoInstance.updateUserFavoritePlaylists(u.getId(), p.getId(), true);
            u.addFavPlaylist(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void removeFavoriteMusic(User u, Music m) {
        try {
            userRepoInstance.updateUserFavoriteMusics(u.getId(), m.getId(), false);
            u.removeFavMusic(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void removeFavoritePlaylist(User u, Playlist p) {
        try {
            userRepoInstance.updateUserFavoritePlaylists(u.getId(), p.getId(), false);
            u.removeFavPlaylist(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}


    public void modifyUser(User loggedUser, String newName, String newPassword, String newEmail) throws IOException {
        
        Boolean validEmail = true;
        Boolean validName = true;
        String currentEmail, currentName;

        if ( newEmail.indexOf('@') == -1 ) {
            validEmail = false;
        }

		if ( newName.indexOf('@') != -1 ) {
            validName = false;
        }

        // Verifica se o newEmail e newName não é repetido
        for (User user : userRepoInstance.getUserLibrary()) {
            currentEmail = user.getEmail();
            currentName = user.getName();

            if ( newEmail.equals(currentEmail) ) {
                validEmail = false;
            }

            if ( newName.equals(currentName) ) {
                validName = false;
            }
        }

        if ( validEmail ) {
            loggedUser.setEmail(newEmail);
        } else {
            newEmail = loggedUser.getEmail();
        }

        if ( validName ) {
            loggedUser.setName(newName);
        } else {
            newName = loggedUser.getName();
        }

        loggedUser.setPassword(newPassword);

        userRepoInstance.updateUserData(loggedUser.getId(), newName, newPassword, newEmail);
    }
    
   
    
    
    public User getUserByIndex(int index) {
		return userRepoInstance.getUserByIndex(index);
	}


	public String getUserNameById(int id) {
        return userRepoInstance.getUserById(id).getName();
	}


	public ArrayList<User> getUserLibrary() {
		return userRepoInstance.getUserLibrary();
	}
}
