package gui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaPrincipalController {
	
	 @FXML
	    private Button botãoPerfilTelaPrincipal;

	    @FXML
	    private Button botãoSairTelaPrincipal;

	    @FXML
	    void irMeuPerfilTelaPrincipal(ActionEvent event)throws IOException  {
	    	System.out.println("Botão meu perfil funciona ");
	    	Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaAlterarPerfil.fxml"));
	    	Scene tabbleViewScene = new Scene(tabbleViewParent);
	    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     	window.setScene(tabbleViewScene);
	    	window.show();

	    }

	    @FXML
	    void sairTelaPrincipal(ActionEvent event)throws IOException {
	    	System.out.println("Botão sair funciona");
	       	Parent tabbleViewParent2 = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaLogin.fxml"));
	    	Scene tabbleViewScene2 = new Scene(tabbleViewParent2);
	    	Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     	window2.setScene(tabbleViewScene2);
	    	window2.show();

	    }


}
