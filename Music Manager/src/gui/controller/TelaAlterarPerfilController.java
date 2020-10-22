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

public class TelaAlterarPerfilController {

    @FXML
    private Button botaoAlterarDadosTelaAlterarPerfil;

    @FXML
    private Button botaoCancelarTelaAlterarPerfil;

    @FXML
    void alterarDados(ActionEvent event)throws IOException {
    	System.out.println("Dados alterados com sucesso");

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
