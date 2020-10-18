package negocio.controllers;

import java.io.IOException;

import data.MusicRepo;
import data.PlaylistRepo;
import data.UserRepo;
import negocio.Music;
import negocio.Playlist;
import negocio.User;
import negocio.UserPermission;

public class UserController {

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
}
