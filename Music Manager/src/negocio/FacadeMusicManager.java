package negocio;

import negocio.controllers.MusicController;
import negocio.controllers.PlaylistController;
import negocio.controllers.UserController;

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

    // TODO interligar os controladores das telas e das calsses base com essa classe
}
