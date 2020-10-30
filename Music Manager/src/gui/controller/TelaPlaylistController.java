package gui.controller;

import java.io.FileNotFoundException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import negocio.FacadeMusicManager;

import negocio.beans.Music; // Classes base
import negocio.beans.Playlist;


public class TelaPlaylistController implements Initializable{

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	
	@FXML
    private Button botãoVoltarTelaPlaylist;
	@FXML
	private Button botãoCriarPlaylist;
	@FXML
	private TableView<Playlist> tableViewTelaPlaylist;
	
	@FXML
	private TableColumn<Playlist, String> titlePlaylist; // Modifica pra creatorName


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
    
    
    public ObservableList<Playlist> populateFavPlaylistTable()
	{
		ObservableList<Playlist> playlists = FXCollections.observableArrayList();
		
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
		//creatorName.setCellValueFactory(new PropertyValueFactory<Playlist, String>("Nome do criador"));
		//idPlaylistColumn.setCellValueFactory(new PropertyValueFactory<Playlist, String>("id"));
		//musicsNamesColumn.setCellValueFactory(new PropertyValueFactory<Playlist, String>("Nome das músicas")); // Exemplo: "Nome_A ; Nome_B ; Nome_C"

		// carregar playlist criadas pelo usuário logado
		//tableViewTelaPlaylist.setItems(populateFavPlaylistTable());

	}
	

}
