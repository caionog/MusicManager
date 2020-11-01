package gui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import negocio.FacadeMusicManager; // Fachada

public class TelaAlterarPerfilController {

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	
	private Stage perfilStage;
	

	@FXML
	private Button backButton;
	
	
	@FXML
	private TextField nameField;
	@FXML
	private TextField emailField;
	@FXML
	private PasswordField passwordField;

	@FXML
	private Button editUserButton;


	@FXML
	void editUser(ActionEvent event) throws IOException {
		
		try {
		
			String name = nameField.getText();
			String email = emailField.getText();
			String password = passwordField.getText();
				
			musicManager.editLoggedUser(email, password, name);

		} catch (Exception NullPointerException) {
			String msgErro = "ERRO null pointer exception!";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(msgErro);
			alert.initOwner(perfilStage);
			alert.showAndWait();
		}	
	}


	@FXML
	void goBack(ActionEvent event)throws IOException{
		Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaPrincipal.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();
	}
}
