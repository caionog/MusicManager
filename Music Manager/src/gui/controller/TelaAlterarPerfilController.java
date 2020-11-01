package gui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import negocio.FacadeMusicManager; // Fachada

public class TelaAlterarPerfilController {

    FacadeMusicManager musicManager = FacadeMusicManager.getInstance();

    @FXML
    private Button botaoAlterarDadosTelaAlterarPerfil;

    @FXML
    private Button botaoCancelarTelaAlterarPerfil;
    
    @FXML
    private TextField emailFieldTelaAlterarPerfil;

    @FXML
    private TextField nomeFieldTelaAlterarPerfil;

    @FXML
    private PasswordField senhaFieldTelaAlterarPerfil;

    @FXML
    void alterarDados(ActionEvent event)throws IOException {
    	
    	String email = emailFieldTelaAlterarPerfil.getText();
    	String password = senhaFieldTelaAlterarPerfil.getText();
    	String name = nomeFieldTelaAlterarPerfil.getText();
        
        musicManager.editLoggedUser(email, password, name);
    }

    @FXML
    void cancelarAlterarDados(ActionEvent event)throws IOException{
    	Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaPrincipal.fxml"));
    	Scene tabbleViewScene = new Scene(tabbleViewParent);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
     	window.setScene(tabbleViewScene);
    	window.show();
    }

}
