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
	
	private PlaylistRepo playlistRepoInstance = PlaylistRepo.getInstance();
	
	private MusicRepo musicRepoInstance = MusicRepo.getInstance();


    public void groupSelectedMusic(ArrayList<Music> selected, User creator) throws IOException {
    	playlistRepoInstance.createPlaylist(selected, creator.getId());
    }
    
    
    public void resetRepo() {
    	playlistRepoInstance.resetRepo();
    }


    public void populatePlaylistLibrary() throws FileNotFoundException {
        playlistRepoInstance.populatePlaylistLibrary(musicRepoInstance);
    }
    

    public void togglePlaylistVisibility(Playlist p) throws IOException {

        _Visibility newVisibility;

        if (p.getVisibility().getValue()) {
            newVisibility = _Visibility.INVISIBLE;
        } else {
            newVisibility = _Visibility.VISIBLE;
        }

        p.setVisibility(newVisibility);

        playlistRepoInstance.updateVisibility(newVisibility.getStrValue(), p.getId() );
    }


	public void editPlaylist(Music selectedMusic) {
		// playlistRepoInstance
    }

    
    public void deletePlaylist() {
        
    }


	public ArrayList<Playlist> getPlaylistsLibrary() {
		return playlistRepoInstance.getPlaylistsLibrary();
	}


	public Playlist getPlaylistByIndex(int index) {
		return playlistRepoInstance.getPlaylistByIndex(index);
	}
}
