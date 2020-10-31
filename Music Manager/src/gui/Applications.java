package gui;

import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class Applications extends Application{
	
	private Stage primaryStage;
	private BorderPane rootScene;

	
	@Override
    public void start(Stage primaryStage)throws Exception {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Music Manager");
		this.rootScene = new BorderPane();
		
		// define tamanho da janela (stage) principal
		Scene scene = new Scene(rootScene, 1280, 720);
		primaryStage.setScene(scene);
		primaryStage.show();
		carregarTelaLogin();
		//	carregarTelaCadastro();
			
		//  String javaVersion = System.getProperty("java.version");
		// String javafxVersion = System.getProperty("javafx.version");
		//  Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		//  Scene scene = new Scene(new StackPane(l), 640, 480);
		//  stage.setScene(scene);
		//  stage.show();
    }
	
	public void carregarTelaLogin() 
	{
		try 
		{
			//carrega a tela de login no centro da tela inicial
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Applications.class.getResource("view/TelaLogin.fxml"));
			AnchorPane loginView = (AnchorPane) loader.load();
			
			
			// seta a tela de conta no centro da tela principal
			this.rootScene.setCenter(loginView);
			
			// seta uma referencia do bancoApp no ContaController
			// ContaPaneController contaController = loader.getController();
			// contaController.setBancoApp(this);
			// seta a lista de contas
			//  ObservableList<Conta> dados = FXCollections.observableArrayList();
			//  FachadaBanco.getInstance().listar().stream().forEach(c -> dados.add(c));
			//  contaController.setDados(dados);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void carregarTelaCadastro() 
	{
		try 
		{
			//carrega a tela de login no centro da tela inicial
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Applications.class.getResource("view/TelaCadastro.fxml"));
			AnchorPane cadastroView = (AnchorPane) loader.load();
			
			
			// seta a tela de conta no centro da tela principal
			this.rootScene.setCenter(cadastroView);
			
	        
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

    public static void main(String[] args) throws IOException, SAXException, TikaException, Exception {
    	BackendTeste.backendTeste();
        launch();
    }
 
}
