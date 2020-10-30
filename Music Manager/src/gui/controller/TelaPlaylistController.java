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
import negocio.Music;
import negocio.Playlist;
import negocio.User;
import negocio.controllers.MusicController;
import negocio.controllers.PlaylistController;
import negocio.controllers.UserController;

public class TelaPlaylistController implements Initializable{
	@FXML
    private Button botãoVoltarTelaPlaylist;
	 @FXML
	    private Button botãoCriarPlaylist;
	 @FXML
	    private TableView<Playlist> tableViewTelaPlaylist;
	 
	 @FXML
	    private TableColumn<Playlist, String> titlePlaylist;


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
    
    
    /*COMEÇO DOS COMENTÁRIOS
    public ObservableList<Playlist> getPlaylist(ArrayList<Music> selectedMusics) throws IOException
	{
    	ObservableList<Playlist> playlist = FXCollections.observableArrayList();
        MusicController musicControler = new MusicController();
		//ArrayList<Music> musicLibrary = musicControler.getMusicLibrary();
        //playlist.add;
	    //	ArrayList<Music> musicLibrary = musicControler.getMusicLibrary();
    	
    	
    	
    	//ArrayList<Music> selectedMusics = new ArrayList<Music>(2);
		for (Music music : musicControler.getMusicLibrary()) {
			if (selectedMusics.size() < 2) {
				selectedMusics.add(music);
			}
		}
    	
    	
    	return playlist;
	}

FIM DOS COMENTÁRIOS*/
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		titlePlaylist.setCellValueFactory(new PropertyValueFactory<Playlist,String>("title"));
		//carregar data
		/*
		ArrayList<Music> selectedMusics = new ArrayList<Music>(2);
		try {
			tableViewTelaPlaylist.setItems(getPlaylist(selectedMusics));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	
	}
	

}
