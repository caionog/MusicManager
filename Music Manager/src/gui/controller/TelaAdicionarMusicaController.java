package gui.controller;

import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import negocio.FacadeMusicManager; // Fachada


public class TelaAdicionarMusicaController {

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	
	@FXML
	private TextField pathFieldTelaAdiconarMusica;

	@FXML
	private Button botaoAdicionarTelaAdicionarMusica;
	 
	 
	@FXML
	void adicionarAdicionarMusica(ActionEvent event) throws IOException, SAXException, TikaException {
		
		String path = pathFieldTelaAdiconarMusica.getText();

		if ( path.endsWith(".mp3") )
		{
			path.replace('\\', '/');
			musicManager.createMusic(path);
			//TODO
			// fecha o popup automáticamente
			// Se possível atualiza a tabela quando fechar o popup
		} else {
			// Mostra msg de erro
			// "Path inválido"
		}

	}
}
