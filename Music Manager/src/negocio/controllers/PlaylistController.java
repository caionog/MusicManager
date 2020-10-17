package negocio.controllers;

import java.util.ArrayList;

import data.PlaylistRepo;
import negocio.Music;
import negocio.User;

public class PlaylistController {
  
    public void groupSelectedMusic(PlaylistRepo pRepo, ArrayList<Music> selected, User creator) {
        pRepo.createPlaylist(selected, creator);
    }
}
