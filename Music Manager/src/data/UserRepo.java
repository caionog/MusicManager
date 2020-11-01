package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import negocio.beans.Music; // Classes base
import negocio.beans.Playlist;
import negocio.beans.User;

import negocio.beans.UserPermission; // Enum
import negocio.interfaces.IUserRepo;

public class UserRepo implements IUserRepo {
    
    private ArrayList<User> usersRepo = new ArrayList<User>();
    private String absolutePath = "Music Manager\\src\\data\\txt storage\\Users repository\\";
    private int IDs; // Somente usado na função addUser <--- revisar isso, da pra melhorar
    
    //------------------ Singleton + Construtor ---------------//
    
    private static UserRepo instance;
    
    public static UserRepo getInstance() {
		if (instance == null) {
            instance = new UserRepo();
        }
        return instance;
    }
    
    private UserRepo() {}

    //------------------ CRUD de users ---------------//

    // Create user no ArrayList e cria um .txt no repositorio
    @Override
    public void createUser(UserPermission userPermission, String email, String name, String password) throws IOException {
        
        // Cria (registra) o user
        int id = generateId();
        User newRegisteredUser = new User(id, userPermission, email, name, password);

        // Adiciona na biblioteca
        usersRepo.add(newRegisteredUser);

        // Cria o .txt da musica
        File userFile = new File(absolutePath + newRegisteredUser.getId() + ".txt");
        if (userFile.createNewFile()) {
            String s = "";
            s += newRegisteredUser.getId() + "\n";
            s += newRegisteredUser.getUserPermission().getStrValue() + "\n";
            s += newRegisteredUser.getEmail() + "\n";
            s += newRegisteredUser.getName() + "\n";
            s += newRegisteredUser.getPassword() + "\n";

            s += "\n"; // Cria sem musica ou playlist favoria
            s += "\n";

            // Escreve no file
            FileWriter writer = new FileWriter(userFile.getAbsolutePath());
            writer.write(s);
            writer.close();

        } else {
            System.out.println("file ja existe");  // Caso o gerador de ID falhe
        }
    }


    // Read user.txt
    @Override
    public ArrayList<String> readUser(int userId) throws FileNotFoundException {

        ArrayList<String> userData = new ArrayList<>(7);

        File userFile = new File(absolutePath + userId + ".txt");
        Scanner reader = new Scanner(userFile);

        while (reader.hasNextLine()) {
            String lineData = reader.nextLine();
            userData.add(lineData);
        }
        reader.close();

        return userData;
    }

    // Updaters no .txt
    @Override
    public void updateUserFavoriteMusics(int userId, int newMusicId) throws IOException {

        ArrayList<String> playlistData = readUser(userId);
        
        String id = playlistData.get(0);
        String userPermission = playlistData.get(1);
        String email = playlistData.get(2);
        String name = playlistData.get(3);
        String password = playlistData.get(4);

        String musicIds[] = playlistData.get(5).split(",");
        String playlistIds = playlistData.get(6);

        String s = "";
        s += id + "\n";
        s += userPermission + "\n";
        s += email + "\n";
        s += name + "\n";
        s += password + "\n";

        for (String musicId : musicIds) if( !musicId.isEmpty() ) s += musicId + ",";
        s += newMusicId + "\n";
        
        s += playlistIds + "\n";

        File user = new File(absolutePath + userId + ".txt");
        FileWriter writer = new FileWriter(user.getAbsolutePath());

        writer.write(s); // Sobrescreve o file atualizando os ids favoritos
        writer.close();
    }
    

    @Override
	public void updateUserFavoritePlaylists(int userId, int newPlaylistId) throws IOException {

        ArrayList<String> playlistData = readUser(userId);
        
        String id = playlistData.get(0);
        String userPermission = playlistData.get(1);
        String email = playlistData.get(2);
        String name = playlistData.get(3);
        String password = playlistData.get(4);

        String musicsIds = playlistData.get(5);
        String playlistIds[] = playlistData.get(6).split(",");

        String s = "";
        s += id + "\n";
        s += userPermission + "\n";
        s += email + "\n";
        s += name + "\n";
        s += password + "\n";

        s += musicsIds + "\n";
        for (String playlistId : playlistIds) if( !playlistId.isEmpty() ) s += playlistId + ",";
        s += newPlaylistId + "\n";

        File user = new File(absolutePath + userId + ".txt");
        FileWriter writer = new FileWriter(user.getAbsolutePath());

        writer.write(s); // Sobrescreve o file atualizando os ids favoritos
        writer.close();
    }
    

    @Override
    public void updateDeletedMusics(int selectedMusicId) throws IOException {
        
        // Procura por um user que contenha uma musica "deletada"
        for (User user : usersRepo) {

            ArrayList<Music> currentArray = user.getFavoriteMusics();
            for (Music music : currentArray) {
                
                int currentId = music.getId();
                if ( currentId == selectedMusicId ) {
                    // Se verdade, então atualiza lista de ids do arquivo e o array desse user
                    currentArray.remove(music);

                    File userFile = new File(absolutePath + user.getId() + ".txt");

                    ArrayList<String> userData = readUser(user.getId());

                    String userId = userData.get(0); // Str
                    String permission = userData.get(1); // Str
                    String email = userData.get(2); // Str
                    String name = userData.get(3); // Str
                    String password = userData.get(4); // Str
                    
                    String favoritedMusicIds[] = userData.get(5).split(","); // Str
                    String favoritedplaylistIds = userData.get(6); // Str

                    
                    // Remove o id copiando o vetor para outro sem copiar o id que precisa ser removido
                    String newfavoritedMusicIds = "";
                    for (int i = 0; i < favoritedMusicIds.length; i++) {
                        if ( !favoritedMusicIds[i].isEmpty() && currentId != Integer.valueOf(favoritedMusicIds[i]) ) {
                            newfavoritedMusicIds += favoritedMusicIds[i] + ",";
                        }
                    }

                    String s = "";
                    s += userId + "\n";
                    s += permission + "\n";
                    s += email + "\n";
                    s += name + "\n";
                    s += password + "\n";

                    s += newfavoritedMusicIds + "\n";
                    s += favoritedplaylistIds + "\n";

                    // Sobrescreve no file
                    FileWriter writer = new FileWriter(userFile.getAbsolutePath());
                    writer.write(s);
                    writer.close();

                    break;
                }
            } // Fim do for each music do user atual

        } // Fim do for each user
	}


    //------------------ Funções auxiliares ---------------//

    // Read todas os Users.txt e coloca tds no arraylist userRepo
    @Override
    public void populateUserRepo(MusicRepo musicRepo, PlaylistRepo playlistRepo) throws IOException {
        File userRepoFolder = new File(absolutePath);

        for (final File userFile : userRepoFolder.listFiles()) {

            int userId = Integer.valueOf(userFile.getName().split("[.]")[0]);
            ArrayList<String> userData = readUser(userId); 

            int id = Integer.valueOf(userData.get(0)); // Str -> int
            UserPermission userPermission = Enum.valueOf(UserPermission.class, userData.get(1)); // str -> UserPermission
            String email = userData.get(2); // str
            String name = userData.get(3); // str
            String password = userData.get(4); // Str

            String musicsIds[] = userData.get(5).split(","); // Str -> Str[] -> ArrayList<Music>
            String playlistsIds[] = userData.get(6).split(","); // Str -> Str[] -> ArrayList<Playlist>
            
            // Str[] -> ArrayList<Music>
            ArrayList<Music> musics = new ArrayList<>();
            for (String musicId : musicsIds) {
                if (!musicId.isEmpty()){
                    Music m = musicRepo.searchMusic(Integer.valueOf(musicId));
                    if (m != null) musics.add(m);
                }
            }

            // Str[] -> ArrayList<Playlist>
            ArrayList<Playlist> playlists = new ArrayList<>();
            for (String playlistId : playlistsIds) {
                if (!playlistId.isEmpty()) {
                    Playlist p = playlistRepo.searchPlaylist(Integer.valueOf(playlistId));
                    if (p != null) playlists.add(p);
                }
            }

            User u = new User(id, userPermission, email, name, password, musics, playlists);
            usersRepo.add(u);
        }
    }

    @Override
    public ArrayList<User> getUserRepo() {
        return usersRepo;
    }

    @Override
    public User getUserByIndex(int index) {
        return usersRepo.get(index);
    }

    @Override
    public User getUserById(int id) {
		User p = searchUserById(id);

        return p;
    }


    private int generateId() throws FileNotFoundException {

        int greaterId = 0, currentId;
        
        for (User user : usersRepo) {
        	currentId = user.getId();
        	
			if ( currentId >= greaterId) {
				greaterId = currentId;
			}
		}

        return greaterId+1;
    }

    
    @Override
    public void resetRepo() {
        File userRepoFolder = new File(absolutePath);

        for (final File user : userRepoFolder.listFiles()) {
            user.delete();
        }
        
        usersRepo = new ArrayList<User>(0);
    }
    
    //----------------buscadores-----------------\\
    @Override
    public User searchUserByName(String nomeUsuario) {// navega pelo array comparando nome dos usuarios com a String digitada
        int achou = usersRepo.size();
        for (int posicao = 0 ; posicao < achou ; posicao++) {
            User comparUser = usersRepo.get(posicao);
            if (comparUser.getName().equalsIgnoreCase(nomeUsuario)){
                return comparUser;
            }
        }
        return null;
    }

    @Override
    public User searchUserById(int id) {// navega pelo array comparando nome dos usuarios com a String digitada
        int achou = usersRepo.size();
        for (int posicao = 0; posicao < achou; posicao++){
            User comparUser = usersRepo.get(posicao);
            if (comparUser.getId() == id) {
                return comparUser;
            }
        }
        return null;
    }

    @Override
    public User searchUserByEmail(String emailUser) {// navega pelo array comparando nome dos usuarios com a String digitada
        int achou = usersRepo.size();
        for (int posicao = 0; posicao < achou; posicao++) {
            User comparUser = usersRepo.get(posicao);
            if (comparUser.getEmail().equalsIgnoreCase(emailUser)== true) {
                return comparUser;
            }
        }
        return null;
    }

    @Override
    public boolean addUser(User usuario) {
        this.IDs++;
        usuario.setId(this.IDs);
        return this.usersRepo.add(usuario);
    }

    @Override
    public boolean removeUser(User usuario) {
        // this.IdRemovido = usuario.getUserId();
        return usersRepo.remove(usuario);
    }

    @Override
    public void refreshList(int IdRemovido) {
        int achou = usersRepo.size();
        for(int posicao = IdRemovido-1; posicao < achou; posicao++ ) {
            User usuario = this.usersRepo.get(posicao);
            usuario.setId( usuario.getId() - 1 );
        }
    }

    @Override
    public int getSize() {
        return this.usersRepo.size();
    }

    @Override
	public ArrayList<String> getEmails() {
        ArrayList<String> emails = new ArrayList<>();
        
        for (User user : usersRepo) {
            emails.add(user.getEmail());
        }

        return emails;
	}

    @Override
	public ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<>();
        
        for (User user : usersRepo) {
            names.add(user.getName());
        }

        return names;
	}

    @Override
	public ArrayList<String> getPasswords() {
        ArrayList<String> passwords = new ArrayList<>();
        
        for (User user : usersRepo) {
            passwords.add(user.getPassword());
        }

        return passwords;
	}

    @Override
	public ArrayList<User> getUserLibrary() {
		return usersRepo;
	}
}
