package gui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import negocio.FacadeMusicManager; // Fachada


public class TelaLoginController  {

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	
	@FXML
	private Button botaoCadastrar;
	  
	@FXML
	private Button botaoEntrar;

	@FXML
	private TextField loginFieldTelaLogin;

	@FXML
	private PasswordField senhaFieldTelaLogin;

	@FXML
	private Label errorMessageLabelTelaLogin;

	@FXML
	void irBotaoCadastrar(ActionEvent event) throws IOException{
		
		
		System.out.println("O botao cadastrar Funciona");
		
		Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaCadastro.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();

	}
	
	@FXML
	void irBotaoEntrar(ActionEvent event) throws IOException{

		String email = loginFieldTelaLogin.getText();
		String senha = senhaFieldTelaLogin.getText();
		
		if ( isFieldFilled() && musicManager.handleUserLogin(email, senha) ) {
			
			Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaPrincipal.fxml"));
			Scene tabbleViewScene = new Scene(tabbleViewParent);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(tabbleViewScene);
			window.show();

		} else {
			errorMessageLabelTelaLogin.setText("Login ou senha incorretos");
		}
	}
	

	private boolean isFieldFilled() {

		String errorMessage = "";
		boolean isFilled = true;

		if ( loginFieldTelaLogin.getText().isEmpty() ) {
			isFilled = false;
			errorMessage = "O campo do email esta vazio";
		}
		
		if ( senhaFieldTelaLogin.getText().isEmpty() ) {
			isFilled = false;
			if( errorMessage.isEmpty() ) 
			{
				errorMessage = "O campo da senha esta vazio";
			}
			else 
			{
				errorMessage += "\nO campo da senha esta vazio";
			}
		}
		
		errorMessageLabelTelaLogin.setText(errorMessage);
		return isFilled;
	}

}
