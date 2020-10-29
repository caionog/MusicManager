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
import negocio.Music;
import negocio.controllers.MusicController;
import negocio.Genre;

public class TelaPrincipalController implements Initializable{
	
	
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
	private Button botaoPerfilTelaPrincipal;

	@FXML
	private Button botaoSairTelaPrincipal;
	
	 @FXML
	    private Button botaoGerarMetadados;
	 @FXML
	    private Button botãoMinhasPlaylists;
	 
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
		 MusicController musicControler = new MusicController();
		 System.out.println(musicSelected);
		 
		//musicControler.extractMetaData();
		
		 
		 
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
		// TODO Auto-generated method stub
		//configurar colunas do tableview
		titleColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("title"));
		artistColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("artist"));
		durationColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("duration"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<Music, Genre>("genre"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Music, String>("id"));
		//carregar data
		tableViewTelaPrincipal.setItems(getMusic());
		
	}
	
	public ObservableList<Music> getMusic()
	{
		
		ObservableList<Music> musica = FXCollections.observableArrayList();
		Genre genre = Enum.valueOf(Genre.class, "CLASSIC");
		
		//ADICIONAR MUSICAS AQUI
		MusicController musicControler = new MusicController();
		
		ArrayList<Music> musicLibrary = musicControler.getMusicLibrary(); // Retorna o array inteiro com todas as músicas
		
		// Adiciona todas as músicas do repositório no array musica
		for (Music music : musicLibrary) {
			musica.add(music);
		}
		//////////////////////////
		
		musica.add(new Music(1, "Fur Elise", "Betoven", genre, "0.0"));
		return musica;
	}

}
