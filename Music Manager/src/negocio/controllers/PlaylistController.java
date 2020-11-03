package negocio.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import data.MusicRepo; // Repositórios
import data.PlaylistRepo;

import negocio.beans.Playlist; // Classes base
import negocio.beans.Music;
import negocio.beans.User;
import negocio.beans._Visibility;
import negocio.interfaces.IPlaylistRepo; // Interface

public class PlaylistController {
	
	private IPlaylistRepo playlistRepoInstance = PlaylistRepo.getInstance();
	
	private MusicRepo musicRepoInstance = MusicRepo.getInstance();


    public void groupSelectedMusic(ArrayList<Music> selected, User creator) throws IOException {
    	playlistRepoInstance.createPlaylist(selected, creator.getName());
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

	//AQUI
//	public ArrayList<Playlist> getPlaylistMusicLibrary() {
//		return playlistRepoInstance.getPlaylistMusicLibrary();
//	}


	public Playlist getPlaylistByIndex(int index) {
		return playlistRepoInstance.getPlaylistByIndex(index);
	}


	public void createPlaylist(ArrayList<Music> p , String c) throws IOException {
		playlistRepoInstance.createPlaylist(p, c);
	}


	public void setPlaylistPublic(Playlist selectedPlaylist) throws IOException {

		String newVisibility = "VISIBLE";

		// Inverte a visibilidade atual da playlist
		if (selectedPlaylist.getVisibility().getValue()) {
			newVisibility = "INVISIBLE";
			selectedPlaylist.setVisibility(_Visibility.INVISIBLE);
		} else {
			selectedPlaylist.setVisibility(_Visibility.VISIBLE);
		}

		playlistRepoInstance.updateVisibility(newVisibility, selectedPlaylist.getId());
	}

}
