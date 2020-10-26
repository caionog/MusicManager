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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocio.Music;
import negocio.controllers.MusicController;
import negocio.Genre;
import data.MusicRepo;

public class TelaPrincipalController implements Initializable{
	//configurar table view m�sica da tela principal
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
	    void irMeuPerfilTelaPrincipal(ActionEvent event)throws IOException  {
	    	System.out.println("Bot�o meu perfil funciona ");
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
			MusicController musicControler = new MusicController(); // provavelmente é melhor mudar essa linha criando uma classe que enxerga todos os controladores e chamando essa classe
			
			Music m = musicControler.getMusicById(1); // Retorna a música que tem id 1, se não existir retorna null
			ArrayList<Music> musicLibrary = musicControler.getMusicLibrary(); // Retorna o array inteiro com todas as músicas
			
			// Adiciona todas as músicas do repositório no array musica
			for (Music music : musicLibrary) {
				musica.add(music);
			}
			//////////////////////////
			
			musica.add(new Music(1, "title", "testeArtist", genre, "TesteDuration"));
			return musica;
		}
	    


}
