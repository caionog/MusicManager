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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocio.FacadeMusicManager;
import negocio.beans.Music;
import negocio.beans.Playlist;
import negocio.beans._Visibility;

public class TelaCriarPlaylistController implements Initializable{
	
	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	private Stage criarPlaylistStage;
	
	
	@FXML
    private TableView<Music> musicTableView;

    @FXML
    private TableColumn<Music, String> titleColumn;

    @FXML
    private ListView<Playlist> playlistListView;

    @FXML
    private Button addMusicToPlaylistButton;

    @FXML
    private Button createPlaylistButton;
    @FXML
    private Button botãoCriarPlaylist;
  
    @FXML
    private Button botãoDeletarTelaCriarPlaylist;
    @FXML
    private Label labelMinhasPlaylists;

    @FXML
    private Label labelTítulo;
    
    @FXML
    private Label errorMessageLabelTelaCriarPlaylist;
    
    
    

    @FXML
    void addMusic(ActionEvent event) {
    	Music selectedMusic = musicTableView.getSelectionModel().getSelectedItem();
    	Playlist selectedPlaylist = playlistListView.getSelectionModel().getSelectedItem();
    	if ( selectedMusic != null && selectedPlaylist != null) {
    	musicManager.addMusicToPlaylist(selectedMusic,selectedPlaylist);
    	System.out.println(selectedMusic);
    	System.out.println(selectedPlaylist);
    	 }
    	else {
			String msgErro = "Selecione uma música e uma playlist para realizar esta ação.\nPara criar uma playlist utilize o botão criar playlist.\nPara criar uma musica utiliza o botão adicionar música na Tela Principal";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(criarPlaylistStage);
			alert.showAndWait();
		}
    	

    }

    @FXML
    void createPlaylist(ActionEvent event) throws IOException {
    	
    	int userId = musicManager.getLoggedUserId();
    	musicManager.createPlaylist(userId);
    	Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaCriarPlaylist.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();
		String errorMessage = "Playlist criada com sucesso!";
		errorMessageLabelTelaCriarPlaylist.setText(errorMessage);
    }
    @FXML
    void deletarTelaCriarPlaylist(ActionEvent event) {
    	Playlist selectedPlaylist = playlistListView.getSelectionModel().getSelectedItem();
    	if ( selectedPlaylist != null ) {
			musicManager.deletePlaylist(selectedPlaylist);
			String errorMessage = "Playlist deletada com sucesso!";
			errorMessageLabelTelaCriarPlaylist.setText(errorMessage);
		}
		else { 
			String msgErro = "Selecione uma playlist para deletar!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(criarPlaylistStage);
			alert.showAndWait();
		}

    }
    
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		playlistListView.getItems().addAll(playlistListView());
		playlistListView.setItems(playlistListView());
		titleColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("title"));
        musicTableView.setItems(musicTableView());
		
	}

	public ObservableList<Playlist> playlistListView()
	{
		ObservableList<Playlist> playlists = FXCollections.observableArrayList();
		ArrayList<Playlist> playlistLibrary = musicManager.getPlaylistLibrary();
		String loggedUserName = musicManager.getLoggedUserName();
    	
		for (Playlist playlist : playlistLibrary) {
			if (playlist.getCreator().equals(loggedUserName) && playlist.getVisibility().equals(_Visibility.INVISIBLE)) {
				playlists.add(playlist);		
				System.out.println(playlist.getVisibility());
			}
		}
		
	//	ArrayList<Playlist> playlistLibrary = musicManager.getPlaylistLibrary();
	//	String loggedUserName = musicManager.getLoggedUserName();
		
  
    	return playlists;
	}
	
	public ObservableList<Music> musicTableView()
	{
		ObservableList<Music> musics = FXCollections.observableArrayList();
	//	String musicSelected = tableViewTelaPrincipal.getSelectionModel().getSelectedItem().getTitle();
	//	ArrayList<String> playlistSettings = musicManager.getPlaylistFilterSettings();
	//	String musicName = playlists.
		
		ArrayList<Music> musicLibrary = musicManager.getMusicLibrary();
		String loggedUserName = musicManager.getLoggedUserName();
		
			for (Music music : musicLibrary) {
				
				musics.add(music);		
				//System.out.println(playlist.getVisibility());
			
		
		
		}
		return musics;
		

	}
}
