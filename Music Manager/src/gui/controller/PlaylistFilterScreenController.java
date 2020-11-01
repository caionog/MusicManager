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
    private void applyFilter(ActionEvent event) {
        String creatorName = creatorNameField.getText();
        String genreStr = genreChoice.getValue();

        PlaylistFilter settings = new PlaylistFilter(creatorName, genreStr);
        
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/TelaPrincipal.fxml"));
            stage.setUserData(settings);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
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
