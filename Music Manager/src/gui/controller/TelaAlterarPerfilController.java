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

import negocio.FacadeMusicManager;
import negocio.beans.UserPermission;
import negocio.controllers.UserController;

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
    	System.out.println("Alterar dados funciona");
    	UserController controller = new UserController();
    	String email = emailFieldTelaAlterarPerfil.getText();
    	String senha = senhaFieldTelaAlterarPerfil.getText();
    	String nome = nomeFieldTelaAlterarPerfil.getText();
    	//AQUI FUNÇÃO DE ALTERAR DADOS

    	

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
