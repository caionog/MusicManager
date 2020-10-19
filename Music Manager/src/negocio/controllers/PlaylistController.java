package negocio.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import data.MusicRepo;
import data.PlaylistRepo;

import negocio.Playlist; // Classes base
import negocio.Music;
import negocio.User;

import negocio._Visibility; // Enum

public class PlaylistController {

    public void groupSelectedMusic(PlaylistRepo pRepo, ArrayList<Music> selected, User creator) throws IOException {
        pRepo.createPlaylist(selected, creator.getId());
    }


    public void populatePlaylistLibrary(PlaylistRepo playlistRepo, MusicRepo musicRepo) throws FileNotFoundException {
        playlistRepo.populatePlaylistLibrary(musicRepo);
    }
    

    public void togglePlaylistVisibility(PlaylistRepo playlistRepo, Playlist p) throws IOException {

        _Visibility newVisibility;

        if (p.getVisibility().getValue()) {
            newVisibility = _Visibility.INVISIBLE;
        } else {
            newVisibility = _Visibility.VISIBLE;
        }

        p.setVisibility(newVisibility);

        playlistRepo.updateVisibility(newVisibility.getStrValue(), p.getId() );
    }


	public void editPlaylist(PlaylistRepo playlistRepo, Music selectedMusic) {

    }

    
    public void deletePlaylist() {
        
    }
}
