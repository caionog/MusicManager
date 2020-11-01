package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import negocio.beans.Music;

public class TelaGerarMetadadosController {

    @FXML
    private TableView<Music> tableViewTelaMetadados;

    @FXML
    private TableColumn<Music, String> metadadosColumn;

}
