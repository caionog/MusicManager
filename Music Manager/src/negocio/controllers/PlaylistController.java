package negocio.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import data.MusicRepo; // Repositórios
import data.PlaylistRepo;

import negocio.beans.Playlist; // Classes base
import negocio.beans.Music;
import negocio.beans.User;

import negocio.beans.Genre; // Enum

import negocio.interfaces.IPlaylistRepo; // Interface

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

    	p.toogleVisibility();
    	
        playlistRepoInstance.updateVisibility(p.getVisibility().getStrValue(), p.getId() );
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
	

	public ArrayList<Playlist> filterPlaylist(Genre genre, String title) {

		ArrayList<Playlist> playlists = new ArrayList<Playlist>(0);

		// TODO Acessa repositório de Musicas e buscar as playlists compatíveis

		return playlists;
	}
}
