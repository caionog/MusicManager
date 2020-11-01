package data.exceptions;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import gui.controller.TelaPrincipalController;

public class MusicNotSelectedException extends Exception implements Initializable{
	private Stage exceptionStage;
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String msgErro = "Selecione uma musica usar essa funcionalidade!";
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(msgErro);
		alert.initOwner(exceptionStage);
		alert.showAndWait();
	}

}
