package gui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;

import negocio.FacadeMusicManager; // Fachada

public class PlaylistFilterScreenController  implements Initializable {
    
    FacadeMusicManager musicManager = FacadeMusicManager.getInstance();

    // Botão voltar
    @FXML
    private Button backButton;

    // Input filtro
    @FXML
    private TextField creatorNameField;
    @FXML
    private ComboBox<String> genreChoice;

    // Botão aplicar filtro
    @FXML
    private Button filterButton;



    @FXML
    private void goBack(ActionEvent event)  throws IOException {
        Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaPrincipal.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();
    }

    @FXML
    private void applyFilter(ActionEvent event) throws IOException {
        String creatorName = creatorNameField.getText();
        String genreStr = genreChoice.getValue();

        musicManager.setFilterSettings(creatorName, genreStr);

        Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaPrincipal.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {

        genreChoice.setItems(FXCollections.observableArrayList(
            "Todos", "Null", "Não listado", 
            "Axe", "Blues", "Country", "Eletronic", "Lining", 
            "Funk", "Gospel", "Hiphop", "Jazz", "Mpb", 
            "Classic", "Pagode", "Pop", "Reague", "Rock", 
            "Samba", "Back counrty"
        ));

        genreChoice.setValue("Todos");
    }
    
}
