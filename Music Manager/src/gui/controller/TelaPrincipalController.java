package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import negocio.beans.Music; // Classe base
import negocio.beans.Playlist;
import negocio.beans.User;
import negocio.FacadeMusicManager;
import negocio.beans.Genre; // Enum

public class TelaPrincipalController implements Initializable{

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	
	private boolean okClicked;
	private Stage metadadosStage;

	//configurar table view música da tela principal
	@FXML
	private TableView<Music> tableViewTelaPrincipal;
	@FXML
	private TableColumn<Music, String> titleColumn;
	@FXML
	private TableColumn<Music, String> artistColumn;

	@FXML
	private TableColumn<Music, Genre> genreColumn;

	@FXML
	private TableColumn<Music, String> idColumn;

	@FXML
	private TableColumn<Music, String> durationColumn;

	@FXML
    private Button botãoFavoritarTelaPrincipal;

	
	
	@FXML
	private Button botaoPerfilTelaPrincipal;

	@FXML
	private Button botaoSairTelaPrincipal;
	
	@FXML
	private Button botaoGerarMetadados;
	@FXML
	private Button botãoMinhasPlaylists;
	
	//DECLARAR TABLEVIEW PLAYLIST
	
	@FXML
    private TableView<Playlist> playlistTable;
	
	@FXML
    private TableColumn<Playlist, String> NomeDoCriadorColumn;

    @FXML
    private TableColumn<Playlist, String> playlistIdColumn;

    @FXML
    private TableColumn<Playlist, ArrayList<Music>> nomesMusicaColumn;
	
    //TABLEVIEW USER
    @FXML
    private TableView<User> userTableViewTelaPrincipal;
    
    @FXML
    private TableColumn<User, String> NomeColumn;

	
	@FXML
    void favoritarTelaPrincipal(ActionEvent event) {
		Music musicSelected = tableViewTelaPrincipal.getSelectionModel().getSelectedItem();
		System.out.println(musicSelected);
		//CÓDIGO DE FAVORITAR MÚSICA AQUI
		

    }
	 
	@FXML
    void irMinhasPlaylists(ActionEvent event) throws IOException {
		System.out.println("Botão minhas playlists funciona ");
		Parent tabbleViewParent3 = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaPlaylist.fxml"));
		Scene tabbleViewScene3 = new Scene(tabbleViewParent3);
		Stage window3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window3.setScene(tabbleViewScene3);
		window3.show();
    }
	 
	@FXML
	void irGerarMetadados(ActionEvent event) {
		Music musicSelected = tableViewTelaPrincipal.getSelectionModel().getSelectedItem();
		if(musicSelected != null) {
		System.out.println("Gerar metadados funciona");
		//musicManager.
		// MusicController musicControler = new MusicController();
		System.out.println(musicSelected);
		//CÓDIGO DE GERAR METADADOS AQUI
		 
		
		 
		}
		else 
		{
			String msgErro = "Selecione uma musica para gerar metadados";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(metadadosStage);;
			alert.showAndWait();
			 
		}
	}
	 
	
	public boolean isOkClicked() {
	    return okClicked;
	}

	@FXML
	void irMeuPerfilTelaPrincipal(ActionEvent event)throws IOException  {
		System.out.println("Botão meu perfil funciona ");
		Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaAlterarPerfil.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();

	}

	@FXML
	void sairTelaPrincipal(ActionEvent event)throws IOException {
		System.out.println("Botão sair funciona");
		Parent tabbleViewParent2 = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaLogin.fxml"));
		Scene tabbleViewScene2 = new Scene(tabbleViewParent2);
		Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window2.setScene(tabbleViewScene2);
		window2.show();

	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//configurar colunas do tableview das músicas
		titleColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("title"));
		artistColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("artist"));
		durationColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("duration"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<Music, Genre>("genre"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("id"));

		//configurar colunas do tableview das playlist
		
		
		playlistIdColumn.setCellValueFactory(new PropertyValueFactory<Playlist, String>("id"));
		//nomesMusicaColumn.setCellValueFactory(new PropertyValueFactory<Playlist,ArrayList<Music>("id"));
		nomesMusicaColumn.setCellValueFactory(new PropertyValueFactory<Playlist,ArrayList<Music>>("musics"));
		
		
		//TENTANDO PEGAR O NOME DO USUARIO POR ID
		String nomePlaylist = musicManager.getUserNameById(1);
		System.out.println("O nome do usuario por id e "+nomePlaylist);
	

      // configurar coluna da tableview usuário
		NomeColumn.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
		

		// ??????? //

		
		tableViewTelaPrincipal.setItems(populateMusicTable()); // carregar os atributos na tabela música
		//carregar os atributos na table playlist
		playlistTable.setItems(populatePlaylistTable());
		//carrega os atributos na table user
		userTableViewTelaPrincipal.setItems(populateUserTable());
		
	}
	
	public ObservableList<Music> populateMusicTable()
	{
		ObservableList<Music> musicTable = FXCollections.observableArrayList();
		
		ArrayList<Music> musicLibrary = musicManager.getMusicLibrary();

		// Adiciona todas as músicas do repositório na tabela da GUI
		for (Music music : musicLibrary) {
			musicTable.add(music);
		}
		
		Genre genre = Enum.valueOf(Genre.class, "CLASSIC");
		musicTable.add(new Music(1, "Fur Elise", "Betoven", genre, "0.0"));
		

		return musicTable;
	}

	public ObservableList<Playlist> populatePlaylistTable() {

		ObservableList<Playlist> playlistTable = FXCollections.observableArrayList();
		
		ArrayList<Playlist> playlistLibrary = musicManager.getPlaylistLibrary();
	//	System.out.println("@mostrar playlistLibrary"+ playlistLibrary.toString());
		// ArrayList<Playlist> favPlaylists = musicManager.getLoggedUserFavPlaylists();

		// Adiciona todas as playlists do repositório na tabela da GUI
		for (Playlist playlist : playlistLibrary) {
			playlistTable.add(playlist);
			
		}
		System.out.println("@mostrar playlistTable"+playlistLibrary.toString());

		return playlistTable;
	}
	public ObservableList<User> populateUserTable() 
	{
		ObservableList<User> userTable = FXCollections.observableArrayList();
		ArrayList<User> userLibrary = musicManager.getUserLibrary();
		for (User user : userLibrary) {
			userTable.add(user);
			
		}
		System.out.println("@mostrar userTable"+userLibrary.toString());

		return userTable;
				
		
	}
	
	
	
	
	
	

}
