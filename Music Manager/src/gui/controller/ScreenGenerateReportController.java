package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import negocio.FacadeMusicManager; // Fachada
import negocio.beans.Music;
import negocio.beans.Playlist;

public class ScreenGenerateReportController implements Initializable {
    
    FacadeMusicManager musicManager = FacadeMusicManager.getInstance();

    // Botão sair
    @FXML
    private Button backButton;

    // Resultado do generate report
    @FXML
    private Text nullText;
    @FXML
    private Text not_listedText;
    @FXML
    private Text axeText;
    @FXML
    private Text bluesText;
    @FXML
    private Text countryText;
    
    @FXML
    private Text eletronicText;
    @FXML
    private Text liningText;
    @FXML
    private Text funkText;
    @FXML
    private Text gospelText;
    @FXML
    private Text hiphopText;

    @FXML
    private Text jazzText;
    @FXML
    private Text mpbText;
    @FXML
    private Text classicText;
    @FXML
    private Text pagodeText;
    @FXML
    private Text popText;

    @FXML
    private Text reagueText;
    @FXML
    private Text rockText;
    @FXML
    private Text sambaText;
    @FXML
    private Text back_countryText;
    @FXML
    private Text podcastText;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {

        ArrayList<Music> musicLibrary = musicManager.getMusicLibrary();
        ArrayList<Playlist> playlistLibrary = musicManager.getPlaylistLibrary();

        int _null, not_listed, axe, blues, country;
        int eletronic, lining, funk, gospel, hiphop;
        int jazz, mpb, classic, pagode, pop;
        int reague, rock, samba, back_country, podcast;


        for (Music music : musicLibrary) {
            switch(music.getGenre().getValue()) {
                case -1: _null++; break;
                case 0: not_listed++; break;
                case 1: axe++; break;
                case 2: blues++; break;
                case 3: country++; break;

                case 4: eletronic++; break;
                case 5: lining++; break;
                case 6: funk++; break;
                case 7: gospel++; break;
                case 8: hiphop++; break;

                case 9: jazz++; break;
                case 10: mpb++; break;
                case 11: classic++; break;
                case 12: pagode++; break;
                case 13: pop++; break;

                case 14: reague++; break;
                case 15: rock++; break;
                case 16: samba++; break;
                case 17: back_country++; break;
                case 18: podcast++; break;
            }
        }

        for (Playlist playlist : playlistLibrary) {
            
        }

	    nullText.setText("NULL: " + _null);
	    not_listedText.setText("NOT_LISTED: " + );
	    axeText.setText("value");
	    bluesText.setText("value");
        countryText.setText("value");
        
        eletronicText.setText("value");
	    liningText.setText("value");
	    funkText.setText("value");
	    gospelText.setText("value");
        hiphopText.setText("value");
        
        jazzText.setText("value");
	    mpbText.setText("value");
	    classicText.setText("value");
	    pagodeText.setText("value");
        popText.setText("value");
        
        reagueText.setText("value");
	    rockText.setText("value");
	    sambaText.setText("value");
	    back_countryText.setText("value");
	    podcastText.setText("value");
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent tabbleViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/view/TelaLogin.fxml"));
		Scene tabbleViewScene = new Scene(tabbleViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tabbleViewScene);
		window.show();
    }
}
