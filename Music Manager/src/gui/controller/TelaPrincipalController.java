package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import data.exceptions.MusicNotSelectedException;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import negocio.FacadeMusicManager; // Fachada

import negocio.beans.Music; // Classe base
import negocio.beans.Playlist;
import negocio.beans.User;

import negocio.beans.Genre; // Enum

public class TelaPrincipalController implements Initializable {

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	
	private boolean okClicked;
	private Stage metadadosStage;

	// Botão sair(deslogar)
	@FXML
	private Button botaoSairTelaPrincipal;

	// Botões de features do Music Manager
	@FXML
	private Button generateReportButton;
	@FXML
	private Button botaoGerarMetadados;
	

	// Botões de navegação do usuário
	@FXML
	private Button botaoPerfilTelaPrincipal;
	@FXML
	private Button loggedUserPlaylistButton;

	// Table view música
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

	// Botões que interagem com a tabela de músicas
	@FXML
	private Button musicFavoriteButton;
	@FXML
	private Button musicUnfavoriteButton;
	@FXML
	private Button musicFilterButton;
	@FXML
	private Button deleteMusicButton;
	@FXML
	private Button addMusicButton;
	
	// Table view playlist
	@FXML
    private TableView<Playlist> playlistTable;
	@FXML
    private TableColumn<Playlist, String> NomeDoCriadorColumn;
    @FXML
    private TableColumn<Playlist, String> playlistIdColumn;
    @FXML
	private TableColumn<Playlist, ArrayList<Music>> nomesMusicaColumn;

	// Table view user
	@FXML
    private TableView<User> userTableViewTelaPrincipal;
    @FXML
	private TableColumn<User, String> NomeColumn;
	
	// Botões que interagem com a tabela de playlist
	@FXML
	private Button playlistFavoriteButton;
	@FXML
	private Button playlistUnfavoriteButton;
	@FXML
	private Button playlistFilterButton;
	@FXML
	private Button deletePlaylistButton;
	@FXML
	private Button createPlaylisButton;

	// Funçõe/ações dos botões

	// Não sei onde  essa função deveria ficar
	public boolean isOkClicked() {
	    return okClicked;
	}

	// =-= // Função sair(deslogar) // =-= //
	@FXML
	void sairTelaPrincipal(ActionEvent event) throws IOException {

		Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaLogin.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();
	}

	// =-= // Funções das features do Music Manager // =-= //

	@FXML
	void irGerarMetadados(ActionEvent event) {

		// TODO

		Music musicSelected = tableViewTelaPrincipal.getSelectionModel().getSelectedItem();
		if ( musicSelected != null ) {
			System.out.println("Gerar metadados funciona");
			System.out.println(musicSelected);
	
		}
		//	throw new MusicNotSelectedException();
			//musicManager.
			// MusicController musicControler = new MusicController();
			
			//CÓDIGO DE GERAR METADADOS AQUI

	//	}
		else 
		{
			String msgErro = "Selecione uma musica para gerar metadados!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(metadadosStage);;
			alert.showAndWait();
		}
	}


	@FXML
	void generateReport(ActionEvent event) {

	}

	// =-= // Função de navegação do usuário // =-= //
	 
	@FXML
    void irMinhasPlaylists(ActionEvent event) throws IOException {

		Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaPlaylist.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();
	}


	@FXML
	void irMeuPerfilTelaPrincipal(ActionEvent event) throws IOException  {

		Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaAlterarPerfil.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();
	}

	// =-= // Funções que interagem com a tabela music // =-= //

	@FXML
    void favMusic(ActionEvent event) {
		Music selectedMusic = tableViewTelaPrincipal.getSelectionModel().getSelectedItem();
		
		if (selectedMusic != null ) {
			musicManager.favMusic(selectedMusic);
		} else {
			String msgErro = "Selecione uma musica para favoritar!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(metadadosStage);;
			alert.showAndWait();
		}
	}


	@FXML 
	void unfavMusic(ActionEvent event) {
		Music selectedMusic = tableViewTelaPrincipal.getSelectionModel().getSelectedItem();
		
		if ( selectedMusic != null && musicManager.getMusicFavCheck() ) {
			musicManager.unfavMusic(selectedMusic);
		} else {
			String msgErro = selectedMusic == null ? "Selecione uma musica para favoritar!" : "Necessário filtro de favoritos ativado!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(metadadosStage);;
			alert.showAndWait();
		}
	}


	@FXML
	void goMusicFilterScreen(ActionEvent event) throws IOException {

		Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/ScreenMusicFilter.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();
	}


	@FXML
	void deleteMusic(ActionEvent event) throws IOException {
		Music selectedMusic = tableViewTelaPrincipal.getSelectionModel().getSelectedItem();
		
		if ( selectedMusic != null && musicManager.getLoggedPermission() ) {
			musicManager.deleteMusic(selectedMusic);
		} else {
			String msgErro = selectedMusic == null ? "Selecione uma música para deletar!" : "Apenas usuários ADM tem permissão para deletar músicas!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(metadadosStage);;
			alert.showAndWait();
		}
	}


	@FXML
	void addMusic(ActionEvent event) throws IOException {

		if ( musicManager.getLoggedPermission() ) {
			Stage stage;
			Parent root;
			stage = new Stage();
			root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaAdicionarMusica.fxml"));
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(addMusicButton.getScene().getWindow());
			stage.showAndWait();
		} else {
			String msgErro = "Apenas usuários ADM tem permissão para adicionar músicas!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(metadadosStage);;
			alert.showAndWait();
		}
		
	}
	
	// =-= // Funções que interagem com a tabela playlist // =-= //

	@FXML
	void favPlaylist(ActionEvent event) throws IOException {
		Playlist playlistSelected = playlistTable.getSelectionModel().getSelectedItem();
		if (playlistSelected != null) {
			musicManager.favPlaylist(playlistSelected);
		}
		else { 
			String msgErro = "Selecione uma playlist para favoritar!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(metadadosStage);;
			alert.showAndWait();
		}
	}


	@FXML
	void unfavPlaylist(ActionEvent event) {

		Playlist playlistSelected = playlistTable.getSelectionModel().getSelectedItem();
		if ( playlistSelected != null && musicManager.getPlaylistFavCheck() ) {
			musicManager.unfavPlaylist(playlistSelected);
		}
		else { 
			String msgErro = playlistSelected == null ? "Selecione uma playlist para favoritar!" : "Necessário filtro de favoritos ativado!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(metadadosStage);;
			alert.showAndWait();
		}
	}


	@FXML
	void goPlaylistFilterScreen(ActionEvent event) throws IOException {
		
		Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/ScreenPlaylistFilter.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();
	}


	@FXML
	void deletePlaylist(ActionEvent event) {
		
		Playlist playlistSelected = playlistTable.getSelectionModel().getSelectedItem();
		if ( playlistSelected != null ) {
			musicManager.deletePlaylist(playlistSelected);
		}
		else { 
			String msgErro = "Selecione uma playlist para deletar!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(metadadosStage);;
			alert.showAndWait();
		}
		// TODO
		// Colocar essa função dentro da tela que mostra playlists somente criadas pelo usuário
		// OU Verificar se essa playlist foi criada pelo usuário que quer deletar
	}


	@FXML
	void createPlaylist(ActionEvent event) {
		// TODO
		// Abrir uma tela que pede ids ou nomes de música de música
	}

	// =-= // Função principal da tela // =-= //

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO
		// Verificar se esse código está certo
		// Somente popular a table de playlist com playlists públicas
		// Melhorar o visual + colunas da table de playlists
		// Adicionar os filtros padão na hora de preencher as tabelas

		// configurar colunas do tableview das músicas
		titleColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("title"));
		artistColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("artist"));
		durationColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("duration"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<Music, Genre>("genre"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("id"));

		// configurar colunas do tableview das playlist
		playlistIdColumn.setCellValueFactory(new PropertyValueFactory<Playlist, String>("id"));
		nomesMusicaColumn.setCellValueFactory(new PropertyValueFactory<Playlist, ArrayList<Music>>("musics"));

    	// configurar coluna da tableview usuário
		NomeColumn.setCellValueFactory(new PropertyValueFactory<User,String>("name"));

		tableViewTelaPrincipal.setItems(populateMusicTable()); // carregar os atributos na tabela música
		userTableViewTelaPrincipal.setItems(populateUserTable()); // carrega os atributos na table user
		playlistTable.setItems(populatePlaylistTable()); //carregar os atributos na table playlist
	}

	// =-= // Funções auxiliares // =-= //

	private ObservableList<Music> populateMusicTable()
	{
		ObservableList<Music> musicTable = FXCollections.observableArrayList();

		ArrayList<String> musicSettings = musicManager.getMusicFilterSettings();
		String title = musicSettings.get(0);
		String artist = musicSettings.get(1);
		String genreStr = musicSettings.get(2);
		String durationStr = musicSettings.get(3);
		Boolean check = Boolean.valueOf(musicSettings.get(4));

		Boolean valid = true;

		ArrayList<Music> musicLibrary;
		if ( check ) {
			musicLibrary = musicManager.getLoggedUserFavMusics();
		} else {
			musicLibrary = musicManager.getMusicLibrary();
		}


		// Adiciona todas as músicas do repositório na tabela da GUI
		for (Music music : musicLibrary) {

			if ( !artist.isEmpty() ) { // Aplica filtro artist
				valid = music.getArtist().equalsIgnoreCase(artist);
			}

			if ( valid && !title.isEmpty() ) { // Aplica filtro title
				valid = music.getTitle().equalsIgnoreCase(title);
			}

			if ( valid && !genreStr.equals("Todos") ) { // Aplica filtro genre
				valid = music.getGenre().getValueStr().equals(genreStr.toUpperCase());
			}

			if ( valid && !durationStr.equals("Todas as durações") ) { // Aplica filtro duration
				Double duration = Double.valueOf(music.getDuration());
				int minutes = (int) ((duration / (1000*60)) % 60);

				if ( durationStr.equals("Curto (0-4 min)") && minutes <= 4 ) {
					valid = true;
				} else if ( durationStr.equals("Médio (4-20 min)") && minutes >= 4 && minutes <= 20) {
					valid = true;
				} else if ( durationStr.equals("Longo (20 min ou mais)") && minutes >= 20 ) { // Longo 20min+
					valid = true;
				} else {
					valid = false;
				}
			}

			if (valid) { musicTable.add(music); }
			else { valid = true; }
		}
		
		return musicTable;
	}


	private ObservableList<Playlist> populatePlaylistTable() {

		ObservableList<Playlist> playlistTable = FXCollections.observableArrayList();
		
		ArrayList<String> playlistSettings = musicManager.getPlaylistFilterSettings();
		String creatorName = playlistSettings.get(0);
		String genreStr = playlistSettings.get(1);
		Boolean check = Boolean.valueOf(playlistSettings.get(2));

		Boolean valid = true;

		ArrayList<Playlist> playlistLibrary;
		if ( check ) {
			playlistLibrary = musicManager.getLoggedUserFavPlaylists();
		} else {
			playlistLibrary = musicManager.getPlaylistLibrary();
		}

		// Adiciona todas as playlists do repositório na tabela da GUI
		for (Playlist playlist : playlistLibrary) {

			if ( !creatorName.isEmpty() ) { // Aplica filtro artist
				valid = playlist.getCreator().equalsIgnoreCase(creatorName);
			}

			if ( valid && !genreStr.equals("Todos") ) { // Aplica filtro title
				for ( Music m : playlist.getMusics() ) {
					if ( m.getGenre().getValueStr().equals(genreStr.toUpperCase()) ) {
						valid = true;
						break;
					} else {
						valid = false;
					}
				}
			}

			if (valid) { playlistTable.add(playlist); }
			else { valid = true; }
		}
		return playlistTable;
	}


	private ObservableList<User> populateUserTable() 
	{
		ObservableList<User> userTable = FXCollections.observableArrayList();
		ArrayList<User> userLibrary = musicManager.getUserLibrary();
		for (User user : userLibrary) {
			userTable.add(user);
			
		}
		//System.out.println("@mostrar userTable"+userLibrary.toString());

		return userTable;
	}

}
