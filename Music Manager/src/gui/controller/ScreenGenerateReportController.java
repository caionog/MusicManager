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
import javafx.scene.Node;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import negocio.FacadeMusicManager; // Fachada

import negocio.beans.Music;

public class ScreenGenerateReportController implements Initializable {
    
    FacadeMusicManager musicManager = FacadeMusicManager.getInstance();

    // Botão sair
    @FXML
    private Button backButton;

    @FXML
    private Text teste;

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

        int _null = 0, not_listed = 0, axe = 0, blues = 0, country = 0;
        int eletronic = 0, lining = 0, funk = 0, gospel = 0, hiphop = 0;
        int jazz = 0, mpb = 0, classic = 0, pagode = 0, pop = 0;
        int reague = 0, rock = 0, samba = 0, back_country = 0, podcast = 0;


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

	    nullText.setText("NULL: " + _null);
	    not_listedText.setText("NOT_LISTED: " + not_listed);
	    axeText.setText("Axe: " + axe);
	    bluesText.setText("Blues: " + blues);
        countryText.setText("Country: " + country);
        
        eletronicText.setText("Eletronic: " + eletronic);
	    liningText.setText("Lining: " + lining);
	    funkText.setText("Funk: " + funk);
	    gospelText.setText("Gospel: " + gospel);
        hiphopText.setText("Hiphop: " + hiphop);
        
        jazzText.setText("Jazz: " + jazz);
	    mpbText.setText("Mpb: " + mpb);
	    classicText.setText("Classic: " + classic);
	    pagodeText.setText("Pagode: " + pagode);
        popText.setText("Pop: " + pop);
        
        reagueText.setText("Reague: " + reague);
	    rockText.setText("Rock: " + rock);
	    sambaText.setText("Samba: " + samba);
	    back_countryText.setText("Back Country: "  + back_country);
	    podcastText.setText("Podcast: " + podcast);
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
