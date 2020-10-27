package negocio.interfaces;

import java.io.IOException;

import negocio.Music; // Classes base
import negocio.Playlist;
import negocio.User;

import negocio.UserPermission; // Enum

public interface IUserController {

    public void populateUsersRepo() throws IOException;

    public void resetRepo();

    public Boolean handleUserRegister(UserPermission permission, String email, String name, String password) throws IOException;

    public boolean handleUserLogin(String nameOrEmail, String password);

    public void addFavoriteMusic(User u, Music m) throws IOException;

    public void addFavoritePlaylist(User u, Playlist p) throws IOException;

    public void modifyUser(User loggedUser, String newName, String newPassword, String newEmail);

    public User getUserByIndex(int index);
}
