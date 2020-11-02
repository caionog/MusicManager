package gui.controller;

import java.io.File;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import negocio.FacadeMusicManager; // Fachada


public class TelaAdicionarMusicaController {

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();

	@FXML
	private Button chooseFileButton;
	
	@FXML
	private TextField pathFieldTelaAdiconarMusica;

	@FXML
	private Button botaoAdicionarTelaAdicionarMusica;
	 
	 
	@FXML
	void addMusic(ActionEvent event) throws IOException, SAXException, TikaException {

		String path = pathFieldTelaAdiconarMusica.getText();
		

		if ( path.endsWith(".mp3") )
		{
			path.replace('\\', '/');
			
			musicManager.createMusic(path);
			//TODO fecha o popup automáticamente
			// Se possível atualiza a tabela quando fechar o popup
		} else {
			// TODO Corrigir essa msg de erro (tarefa rápida)
			// String msgErro = "Path inválido";
			// Alert alert = new Alert(AlertType.ERROR);
			// alert.setContentText(msgErro);
			// alert.initOwner(metadadosStage);;
			// alert.showAndWait();
		}
	}

	@FXML
	void chooseFile(ActionEvent event) throws IOException, SAXException, TikaException {

		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("Music Manager\\src\\data\\mp3 storage"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("Audio files", "*.mp3"));

		File selectedFile = fc.showOpenDialog(null);

		if ( selectedFile != null ){
			pathFieldTelaAdiconarMusica.setText(selectedFile.getAbsolutePath());
		}
	}
}
