package negocio.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import data.MusicRepo; // Repositórios
import data.PlaylistRepo;

import negocio.beans.Playlist; // Classes base
import negocio.beans.Music;
import negocio.beans.User;

import negocio.interfaces.IPlaylistRepo; // Interface

public class PlaylistController {
	
	private IPlaylistRepo playlistRepoInstance = PlaylistRepo.getInstance();
	
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

    	p.toogleVisibility();
    	
        playlistRepoInstance.updateVisibility(p.getVisibility().getStrValue(), p.getId() );
    }


	public void editPlaylist(Music selectedMusic) {
		// playlistRepoInstance
    }

	
    public void deletePlaylist(Playlist selectedPlaylist) {
        playlistRepoInstance.deletePlaylist(selectedPlaylist);

        // TODO
        // Atualizar usuários que favoritaram essa playlist
    }


	public ArrayList<Playlist> getPlaylistsLibrary() {
		return playlistRepoInstance.getPlaylistsLibrary();
	}


	public Playlist getPlaylistByIndex(int index) {
		return playlistRepoInstance.getPlaylistByIndex(index);
	}
}
