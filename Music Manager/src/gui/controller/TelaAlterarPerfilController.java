package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import negocio.FacadeMusicManager; // Fachada

public class TelaAlterarPerfilController implements Initializable{

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
    private Label nameLabelTelaPerfil;

    @FXML
    private Label emailLabelTelaPerfil;

    @FXML
    private Label passwordLabelTelaPerfil;


	@FXML
	void editUser(ActionEvent event) throws IOException {
		
		try {
		
			String name = nameField.getText();
			String email = emailField.getText();
			String password = passwordField.getText();
				
			musicManager.editLoggedUser(email, password, name);
			//CHAMAR INITIALIZE DE PREFERENCIA
			//this.initialize(location, resources);
			
			Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaAlterarPerfil.fxml"));
			Scene tabbleViewScene = new Scene(tabbleViewParent);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(tabbleViewScene);
			window.show();
			

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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(musicManager.getLoggedUserName());
		String nome = musicManager.getLoggedUserName();
		System.out.println(musicManager.getLoggedUserPassword());
		String senha = musicManager.getLoggedUserPassword();
		System.out.println(musicManager.getLoggedUserEmail());
		String email = musicManager.getLoggedUserEmail();
		nameLabelTelaPerfil.setText(nome);
		emailLabelTelaPerfil.setText(email);
		passwordLabelTelaPerfil.setText(senha);
		
	}
}
