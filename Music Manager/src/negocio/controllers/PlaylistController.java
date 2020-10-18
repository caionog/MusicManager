package negocio.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import data.MusicRepo;
import data.PlaylistRepo;
import negocio.Music;
import negocio.Playlist;
import negocio.User;

public class PlaylistController {

    public void groupSelectedMusic(PlaylistRepo pRepo, ArrayList<Music> selected, User creator) throws IOException {
        pRepo.createPlaylist(selected, creator);
    }

    public void populatePlaylistLibrary(PlaylistRepo playlistRepo, MusicRepo musicRepo) throws FileNotFoundException {
        playlistRepo.readPlaylistLibrary(musicRepo);
	}

    public void togglePlaylistVisibility(PlaylistRepo playlistRepo, Playlist selectedPlaylist) throws IOException {
        playlistRepo.updatePlaylist(selectedPlaylist);
    }

	public void editPlaylist(PlaylistRepo playlistRepo, Music selectedMusic) {

    }
    
    public void deletePlaylist() {
        
    }

	

}
