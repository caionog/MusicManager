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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import negocio.FacadeMusicManager; // Fachada

import negocio.beans.Playlist; // Classes base
import negocio.beans._Visibility;


public class TelaPlaylistController implements Initializable{

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	Stage telaPlaylistStage;
	
	@FXML
    private Button botãoVoltarTelaPlaylist;
	@FXML
	private Button botãoCriarPlaylist;
	@FXML
    private Button botãoDeletarTelaPlaylist;
	
	@FXML
    private TableView<Playlist> playlistTablePlaylist;

    @FXML
	 private TableColumn<Playlist, String> nameMusicColumnPlaylist;
    @FXML
    private ListView<Playlist> playlistListPlaylist;
    
    @FXML
    private Button botãoAtualizarTelaPlaylist;
    @FXML
    private Button botãoTornarPúblico;
    
    @FXML
    void fazerTornarPúblico(ActionEvent event) throws IOException {
    	Playlist selectedPlaylist = playlistListPlaylist.getSelectionModel().getSelectedItem();
    	if (selectedPlaylist != null) {
    		musicManager.setPlaylistPublic(selectedPlaylist);
			
		}

    }

    
    @FXML
    void atualizarTelaPlaylist(ActionEvent event) throws IOException {
    	Parent tabbleViewParent3 = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaPlaylist.fxml"));
		Scene tabbleViewScene3 = new Scene(tabbleViewParent3);
		Stage window3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window3.setScene(tabbleViewScene3);
		window3.show();

    }



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
    void criarPlaylistTelaPlaylist(ActionEvent event) throws IOException {
    	System.out.println("Botão criar playlist funciona");
    	
    	
 			Stage stage;
 			Parent root;
 			stage = new Stage();
 			root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaCriarPlaylist.fxml"));
 			stage.setScene(new Scene(root));
 			stage.initModality(Modality.APPLICATION_MODAL);
 			stage.initOwner(botãoCriarPlaylist.getScene().getWindow());
 			stage.showAndWait();
    	
    	//Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaCriarPlaylist.fxml"));
    	//Scene tabbleViewScene = new Scene(tabbleViewParent);
    	//Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
     	//window.setScene(tabbleViewScene);
    	//window.show();
    	
    	
    	
    	//ArrayList<Music> selectedMusics = new ArrayList<Music>();

    }
    @FXML
    void deletarTelaPlaylist(ActionEvent event) {
    	Playlist selectedPlaylist = playlistListPlaylist.getSelectionModel().getSelectedItem();
    	if ( selectedPlaylist != null ) {
			musicManager.deletePlaylist(selectedPlaylist);
		}
		else { 
			String msgErro = "Selecione uma playlist para deletar!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(telaPlaylistStage);;
			alert.showAndWait();
		}
    	//musicManager.deletePlaylist(selectedPlaylist);
    //	selectedPlaylist.
    	

    }
    
 
    public ObservableList<Playlist> playlistTablePlaylist()
	{
		ObservableList<Playlist> playlists = FXCollections.observableArrayList();
	//	String musicSelected = tableViewTelaPrincipal.getSelectionModel().getSelectedItem().getTitle();
	//	ArrayList<String> playlistSettings = musicManager.getPlaylistFilterSettings();
	//	String musicName = playlists.
		
		ArrayList<Playlist> playlistLibrary = musicManager.getPlaylistLibrary();
		String loggedUserName = musicManager.getLoggedUserName();
    	
		for (Playlist playlist : playlistLibrary) {
			if (playlist.getCreator().equals(loggedUserName) && playlist.getVisibility().equals(_Visibility.INVISIBLE)) {
				playlists.add(playlist);		
				System.out.println(playlist.getVisibility());
			}
		}
		

		
    	return playlists;
	}
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Configura as colunas da table view de playlists
	//	nameMusicColumnPlaylist.setCellValueFactory(new PropertyValueFactory<Playlist, String>("musics"));
		//playlistListPlaylist.getItems().addAll("musics");
		

	
		playlistListPlaylist.getItems().addAll(playlistTablePlaylist());
//		playlistTablePlaylist.setItems(playlistTablePlaylist());
		

		// carregar playlist criadas pelo usuário logado
		//tableViewTelaPlaylist.setItems(populateFavPlaylistTable());

	}
	

}
