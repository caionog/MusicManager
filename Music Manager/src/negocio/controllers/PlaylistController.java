package negocio.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import data.MusicRepo; // Repositórios
import data.PlaylistRepo;

import negocio.Playlist; // Classes base
import negocio.Music;
import negocio.User;

import negocio.Genre; // Enum

import negocio.interfaces.IPlaylistController; // Interface

public class PlaylistController implements IPlaylistController {
	
	private PlaylistRepo playlistRepoInstance = PlaylistRepo.getInstance();
	
	private MusicRepo musicRepoInstance = MusicRepo.getInstance();


	@Override
    public void groupSelectedMusic(ArrayList<Music> selected, User creator) throws IOException {
    	playlistRepoInstance.createPlaylist(selected, creator.getId());
    }
    
	
	@Override
    public void resetRepo() {
    	playlistRepoInstance.resetRepo();
    }


	@Override
    public void populatePlaylistLibrary() throws FileNotFoundException {
        playlistRepoInstance.populatePlaylistLibrary(musicRepoInstance);
    }
    

	@Override
    public void togglePlaylistVisibility(Playlist p) throws IOException {

    	p.toogleVisibility();
    	
        playlistRepoInstance.updateVisibility(p.getVisibility().getStrValue(), p.getId() );
    }


	@Override
	public void editPlaylist(Music selectedMusic) {
		// playlistRepoInstance
    }

	
	@Override
    public void deletePlaylist() {
        
    }


	@Override
	public ArrayList<Playlist> getPlaylistsLibrary() {
		return playlistRepoInstance.getPlaylistsLibrary();
	}


	@Override
	public Playlist getPlaylistByIndex(int index) {
		return playlistRepoInstance.getPlaylistByIndex(index);
	}
	
	
	@Override
	public ArrayList<Playlist> filterPlaylist(Genre genre, String title) {

		ArrayList<Playlist> playlists = new ArrayList<Playlist>(0);

		// TODO Acessa repositório de Musicas e buscar as playlists compatíveis

		return playlists;
	}
}
