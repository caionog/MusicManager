package negocio.controllers;

import java.io.IOException;

import data.MusicRepo;
import data.PlaylistRepo;
import data.UserRepo;
import negocio.Music;
import negocio.Playlist;
import negocio.User;
import negocio.UserPermission;
import negocio._Visibility;

public class UserController {

    public void validateLogin() {

    }

    public void registerUser(UserRepo userRepo, UserPermission userPermission, String email, String name, String password)
            throws IOException {
        userRepo.createUser(userPermission, email, name, password);
    }


    public void populateUsersRepo(UserRepo userRepo, MusicRepo musicRepo, PlaylistRepo playlistRepo)
            throws IOException {
        userRepo.populateUserRepo(musicRepo, playlistRepo);
    }
    

    public void addFavoriteMusic(UserRepo userRepo, User u, Music m) throws IOException {
        u.addFavMusic(m);

        userRepo.updateUserFavoriteMusics(u.getId(), m.getId() );
    }
    

    public void addFavoritePlaylist(UserRepo userRepo, User u, Playlist p) throws IOException {
        u.addFavPlaylist(p);

        userRepo.updateUserFavoritePlaylists(u.getId(), p.getId() );
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
}
