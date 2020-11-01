package gui.controller;

import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.FacadeMusicManager;
import negocio.controllers.MusicController;

public class TelaAdicionarMusicaController {
	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	
	

	    @FXML
	    private Button botaoAdicionarTelaAdicionarMusica;
	
	 @FXML
	    private TextField pathFieldTelaAdiconarMusica;
	 
	
	 
	 @FXML
	    void adicionarAdicionarMusica(ActionEvent event) throws IOException, SAXException, TikaException, Exception {
		 
		 //LEMBRAR DE FAZER EXCEÇÃO
		 //if(musicManager.)
		 String path = pathFieldTelaAdiconarMusica.getText();
		 MusicController musicController = new MusicController();
		// musicController.extractMetaData(path);
	//	 String pathSong = mp3StoragePath +path+ ".mp3";
		 musicController.extractMetaData(path);
	//	 musicController.extractMetaData(pathSong);
	//	 System.out.println(pathSong);
		 System.out.println("Música adicionada com sucesso");

	    }

	   


}
