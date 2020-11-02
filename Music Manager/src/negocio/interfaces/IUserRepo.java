package negocio.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

import negocio.beans.User; // Classes base

import data.MusicRepo; // Repos
import data.PlaylistRepo;

import negocio.beans.UserPermission; // Enum

public interface IUserRepo {

    public void createUser(UserPermission userPermission, String email, String name, String password) throws IOException;

    public ArrayList<String> readUser(int userId) throws FileNotFoundException;

    public void updateUserFavoriteMusics(int userId, int newMusicId, Boolean add) throws IOException;

    public void updateUserFavoritePlaylists(int userId, int newPlaylistId, Boolean add) throws IOException;

    public void updateUserData(int loggedUserId, String newName, String newPassword, String newEmail) throws IOException;

    public void updateDeletedMusics(int selectedMusicId) throws IOException;

    public void populateUserRepo(MusicRepo musicRepo, PlaylistRepo playlistRepo) throws IOException;
    
    public ArrayList<User> getUserRepo();

    public User getUserByIndex(int index);

    public User getUserById(int id);

    public void resetRepo();

    public User searchUserByName(String nomeUsuario);

    public User searchUserById(int id);

    public User searchUserByEmail(String emailUser);

    public boolean addUser(User usuario);

    public boolean removeUser(User usuario);

    public void refreshList(int IdRemovido);

    public int getSize();

    public ArrayList<String> getEmails();

    public ArrayList<String> getNames();

    public ArrayList<String> getPasswords();

    public ArrayList<User> getUserLibrary();
}
