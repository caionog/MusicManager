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

import negocio.controllers.UserController; // Controlador

import negocio.beans.UserPermission; // Enum


public class TelaCadastroController {

	FacadeMusicManager musicManager = FacadeMusicManager.getInstance();
	
	@FXML
    private Button botaoCadastrarTelaCadastro;

    @FXML
    private Button botaoCancelarTelaCadastro;
    @FXML
    private PasswordField senhaFieldTelaCadastro;

    @FXML
    private TextField emailFieldTelaCadastro;

    @FXML
    private TextField nomeFieldTelaCadastro;
    @FXML
    private Label errorMessageLabelTelaCadastro;
    @FXML
    private CheckBox checkAdminTelaCadastro;
    //CHECKBOX AQUI
    
    @FXML
    void setAdmin(ActionEvent event) {
    	

    }


 
    @FXML
    void cancelarCadastroConta(ActionEvent event)throws IOException {
    	
    	System.out.println("Botão cancelar funciona");
    	Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaLogin.fxml"));
    	Scene tabbleViewScene = new Scene(tabbleViewParent);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
     	window.setScene(tabbleViewScene);
    	window.show();

    }
    
    private String errorMessage = "";
    private boolean isFieldFilledCadastro() 
    {
    	boolean isFilled =true;
    	if(emailFieldTelaCadastro.getText().isEmpty()) 
    	{
    		isFilled = false;
    		errorMessage = "O campo do email esta vazio";
    	}
    	if(nomeFieldTelaCadastro.getText().isEmpty()) 
    	{
    		isFilled = false;
    		if(errorMessage.isEmpty()) 
    		{
    			errorMessage = "O campo do nome esta vazio";
    		}
    		else 
    		{
    			errorMessage += "\nO campo do nome esta vazio";
    		}
    	}
    	if(senhaFieldTelaCadastro.getText().isEmpty()) 
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
    	
    	
    	UserController controller = new UserController();
    	String email = emailFieldTelaCadastro.getText();
    	String senha = senhaFieldTelaCadastro.getText();
    	String nome = nomeFieldTelaCadastro.getText();
    	UserPermission adm =UserPermission.NORMAL ;
    	
   
    	
    	//MEXER AQUI TBM�
    	//UserPermission adm2 = checkAdminTelaCadastro.
    	//MEXER AQUI TBM
    	//User teste = new User(0, NORMAL, "email", "name"," password")
    	
    	
    	if(isFieldFilledCadastro()==true) 
    	{
    		//PAREI AQUI
    		
    	 	if(checkAdminTelaCadastro.isSelected()== true) 
        	{
        		adm = UserPermission.ADM;
        		System.out.println("Usuario escolheu Adm");
        	}
        	else if(checkAdminTelaCadastro.isSelected()== false)
        	{
        		adm = UserPermission.NORMAL;
        		System.out.println("Usuario escolheu normal");
        	}
    	 	
    	 	if(controller.handleUserRegister(adm, email, nome, senha)== true) 
    	 	{
    	 		errorMessageLabelTelaCadastro.setText("Cadastro feito com sucesso"); 
    	 	}else 
    	 	{
    	 		errorMessageLabelTelaCadastro.setText("Cadastro nao pode ser feito\nUma ou mais informacoes ja cadastradas"); 
    	 	}
    		
    		
    		
    	}
    	
    	

    }

    



}