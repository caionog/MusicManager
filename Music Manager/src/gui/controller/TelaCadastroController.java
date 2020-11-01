package gui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import negocio.FacadeMusicManager; // Fachada

import negocio.beans.UserPermission; // Enum


public class TelaCadastroController {

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	

	@FXML
	private Button botaoCancelarTelaCadastro;


	@FXML
    private TextField nomeFieldTelaCadastro;
    @FXML
    private TextField emailFieldTelaCadastro;
    @FXML
	private PasswordField senhaFieldTelaCadastro;
	@FXML
	private CheckBox checkAdminTelaCadastro;
	

	@FXML
    private Button botaoCadastrarTelaCadastro;
    
    @FXML
    private Label errorMessageLabelTelaCadastro;
    
    
    @FXML
    void setAdmin(ActionEvent event) {
    	
    }

 
    @FXML
    void cancelarCadastroConta(ActionEvent event) throws IOException {
    	
    	Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaLogin.fxml"));
    	Scene tabbleViewScene = new Scene(tabbleViewParent);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
     	window.setScene(tabbleViewScene);
    	window.show();
    }
    

    private boolean isFieldFilledCadastro() {

		String errorMessage = "";
		boolean isFilled =true;
		
		if ( emailFieldTelaCadastro.getText().isEmpty() ) 
		{
    		isFilled = false;
    		errorMessage = "O campo do email esta vazio";
    	}
    	if ( nomeFieldTelaCadastro.getText().isEmpty() ) 
    	{
    		isFilled = false;
    		if ( errorMessage.isEmpty() ) 
    		{
    			errorMessage = "O campo do nome esta vazio";
    		}
    		else 
    		{
    			errorMessage += "\nO campo do nome esta vazio";
    		}
    	}
    	if ( senhaFieldTelaCadastro.getText().isEmpty() ) 
    	{
    		isFilled=false;
    		if(errorMessage.isEmpty()) 
    		{
    			errorMessage = "O campo da senha esta vazio";
    		}
    		else 
    		{
    			errorMessage += "\nO campo da senha esta vazio";
    		}
    	}
    	
    	errorMessageLabelTelaCadastro.setText(errorMessage);
    	return isFilled;
    } 
    
    @FXML
    void cadastrarConta(ActionEvent event)throws IOException {
    	
    	String email = emailFieldTelaCadastro.getText();
    	String senha = senhaFieldTelaCadastro.getText();
    	String nome = nomeFieldTelaCadastro.getText();
    	UserPermission adm;
    	
    	if( isFieldFilledCadastro() == true ) {
    	 	if ( checkAdminTelaCadastro.isSelected() == true ) {

				adm = UserPermission.ADM; // Usuario escolheu ADM
				
        	} else {

        		adm = UserPermission.NORMAL; // Usuario escolheu normal
        	}
    	 	
    	 	if ( musicManager.handleUserRegister(adm, email, nome, senha) ) {
    	 		errorMessageLabelTelaCadastro.setText("Cadastro feito com sucesso"); 
    	 	} else {
    	 		errorMessageLabelTelaCadastro.setText("Cadastro não pode ser feito\nAlguma regra foi violada"); 
    	 	}
    	}

    }

}