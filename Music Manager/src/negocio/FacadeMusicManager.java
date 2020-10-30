package negocio;

import java.util.ArrayList;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import negocio.controllers.MusicController; // Controladores
import negocio.controllers.PlaylistController;
import negocio.controllers.UserController;

import negocio.beans.Music; // Classe base
import negocio.beans.Playlist;
import negocio.beans.User;

public class FacadeMusicManager {

    User loggedUser;

    MusicController musicController = new MusicController();
    PlaylistController playlistContrtoller = new PlaylistController();
    UserController UserController = new UserController();

    //------------------ Singleton + Construtor ---------------//
    
    private static FacadeMusicManager instance;
    
    public static FacadeMusicManager getInstance() {
		if (instance == null) {
            instance = new FacadeMusicManager();
        }
        return instance;
    }
    
    private FacadeMusicManager() {}

    //---------------------------------------------------------//

    public ArrayList<Music> getMusicLibrary() {
      
    	return musicController.getMusicLibrary(); // Retorna o array inteiro com todas as músicas;
    }


	public ArrayList<Playlist> getPlaylistLibrary() {
        
        return playlistContrtoller.getPlaylistsLibrary();
	}
  

	public ArrayList<Music> getLoggedUserFavMusics() {

    	return loggedUser.getFavoriteMusics();
  	}
  

	public ArrayList<Playlist> getLoggedUserFavPlaylists() {

    	return loggedUser.getFavoritePlaylists();
  	}
  

	public void addMusicToTable() {

	}

	public void addPlaylistToTable() {

  	}

	public int getLoggedUserId() {
		return loggedUser.getId();
	}
//FUÇÃO CRIADA
	public String getUserNameById() {
		// TODO Auto-generated method stub
		return loggedUser.getName();
	}
}
