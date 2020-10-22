package gui.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class TelaCadastroController {
	
	@FXML
    private Button botaoCadastrarTelaCadastro;

    @FXML
    private Button botaoCancelarTelaCadastro;

    @FXML
    void cadastrarConta(ActionEvent event)throws IOException {
    	
    	System.out.println("Cadastro feito com sucesso");

    }

    @FXML
    void cancelarCadastroConta(ActionEvent event)throws IOException {
    	
    	Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaLogin.fxml"));
    	Scene tabbleViewScene = new Scene(tabbleViewParent);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
     	window.setScene(tabbleViewScene);
    	window.show();

    }



}