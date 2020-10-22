package gui.controller;
import java.io.IOException;

import gui.Applications;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class TelaLoginController  {
	
	  @FXML
	    private Button botaoCadastrar;
	  
	  @FXML
	    private Button botaoEntrar;

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
	    	System.out.println("O botao entrar funciona");
	    	Parent tabbleViewParent2 = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaPrincipal.fxml"));
	    	Scene tabbleViewScene2 = new Scene(tabbleViewParent2);
	    	Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     	window2.setScene(tabbleViewScene2);
	    	window2.show();
	    	
	    	

	    }
	
	    //método de trocar de cenas
	    
	    
	
}
	 


