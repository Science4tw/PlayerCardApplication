package app;

import controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.PlayerCard;
import model.PlayerCardCollection;
import view.MainPane;

public class Main extends Application {

	/** 
	 * Initialisieren der Applikation (Model, View und Controller)
	 */
	public void start(Stage primaryStage) {
		
		// 1. Initialisieren des Models (= Liste aus PlayerCard Objekten)
		PlayerCardCollection playerCards = new PlayerCardCollection();
		for (PlayerCard p : playerCards)
			System.out.println(p);
		// 2. Initialisieren des Controllers (besitzt eine Referenz auf das Model) 
		MainController mainController = new MainController(playerCards);
		// 3. Initialisieren der View (besitzt eine Referenz auf den Controller)
		MainPane mainPane = new MainPane(mainController);
		// 4. Der Controller erhält mit einem Setter eine Referenz auf die View
		mainController.setMainView(mainPane);
		
		// Szene mit View initialisieren und im Fenster anzeigen
		Scene scene = new Scene(mainPane, 550, 350);
		primaryStage.setTitle("Spielerkarten Manager");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Starten der Applikation
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
