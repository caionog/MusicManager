package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.poi.ss.format.CellDateFormatter;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import negocio.FacadeMusicManager; // Fachada

import negocio.beans.Playlist; // Classes base


public class TelaPlaylistController implements Initializable{

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	
	@FXML
    private Button botãoVoltarTelaPlaylist;
	@FXML
	private Button botãoCriarPlaylist;
	
	@FXML
    private TableView<Playlist> playlistTablePlaylist;

    @FXML
	 private TableColumn<Playlist, String> nameMusicColumnPlaylist;
    @FXML
    private ListView playlistListPlaylist;


    @FXML
    void botãoVoltarTelaPlaylist(ActionEvent event) throws IOException {
    	System.out.println("Botão cancelar funciona");
    	Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaPrincipal.fxml"));
    	Scene tabbleViewScene = new Scene(tabbleViewParent);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
     	window.setScene(tabbleViewScene);
    	window.show();

    }
    
    
    @FXML
    void criarPlaylistTelaPlaylist(ActionEvent event) {
    	System.out.println("Botão criar playlist funciona");
    	
    	//ArrayList<Music> selectedMusics = new ArrayList<Music>();

    }
    
 
    public ObservableList<Playlist> playlistTablePlaylist()
	{
		ObservableList<Playlist> playlists = FXCollections.observableArrayList();
	//	String musicSelected = tableViewTelaPrincipal.getSelectionModel().getSelectedItem().getTitle();
	//	ArrayList<String> playlistSettings = musicManager.getPlaylistFilterSettings();
	//	String musicName = playlists.
		
		ArrayList<Playlist> playlistLibrary = musicManager.getPlaylistLibrary();
		int loggedUserId = musicManager.getLoggedUserId();
    	
		for (Playlist playlist : playlistLibrary) {
			if (playlist.getCreatorId() == loggedUserId) {
				playlists.add(playlist);		
			}
		}
		

		
    	return playlists;
	}
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Configura as colunas da table view de playlists
		nameMusicColumnPlaylist.setCellValueFactory(new PropertyValueFactory<Playlist, String>("musics"));
		//playlistListPlaylist.getItems().addAll("musics");
		

		//playlistListPlaylist.setItems(playlistTablePlaylist());
		playlistListPlaylist.getItems().addAll(playlistTablePlaylist());
		playlistTablePlaylist.setItems(playlistTablePlaylist());
		//creatorName.setCellValueFactory(new PropertyValueFactory<Playlist, String>("Nome do criador"));
		//idPlaylistColumn.setCellValueFactory(new PropertyValueFactory<Playlist, String>("id"));
		//musicsNamesColumn.setCellValueFactory(new PropertyValueFactory<Playlist, String>("Nome das músicas")); // Exemplo: "Nome_A ; Nome_B ; Nome_C"

		// carregar playlist criadas pelo usuário logado
		//tableViewTelaPlaylist.setItems(populateFavPlaylistTable());

	}
	

}
